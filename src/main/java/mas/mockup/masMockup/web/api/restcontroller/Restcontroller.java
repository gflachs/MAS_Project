package mas.mockup.masMockup.web.api.restcontroller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mas.mockup.masMockup.services.AccountInfoService;
import mas.mockup.masMockup.services.ArticleService;
import mas.mockup.masMockup.services.OfferService;
import mas.mockup.masMockup.services.OrderLineItemService;
import mas.mockup.masMockup.services.OrderService;
import mas.mockup.masMockup.services.SupplierService;
import mas.mockup.masMockup.web.api.mailservice.EmailService;
import mas.mockup.masMockup.web.api.mailservice.MailBody;
import mas.mockup.masMockup.web.database.accounts.AccountInfo;
import mas.mockup.masMockup.web.database.accounts.AccountInfoBody;
import mas.mockup.masMockup.web.database.accounts.Supplier;
import mas.mockup.masMockup.web.database.accounts.SupplierBody;
import mas.mockup.masMockup.web.database.order.Order;
import mas.mockup.masMockup.web.database.order.OrderBody;
import mas.mockup.masMockup.web.database.order.orderlineitem.OrderLineItem;
import mas.mockup.masMockup.web.database.order.orderlineitem.OrderLineItemBody;
import mas.mockup.masMockup.web.database.order.orderlineitem.OrderLineItemBodyOrder;
import mas.mockup.masMockup.web.database.product.Article;
import mas.mockup.masMockup.web.database.product.ArticleBody;
import mas.mockup.masMockup.web.database.product.ArticleInfo;
import mas.mockup.masMockup.web.database.product.Offer;
import mas.mockup.masMockup.web.database.product.OfferBody;
import mas.mockup.masMockup.web.database.product.offerStatus.OfferStatus;

@CrossOrigin("*")
@RestController
public class Restcontroller {

    private final AccountInfoService accountInfoService;
    private final SupplierService supplierService;
    private final ArticleService articleService;
    private final OfferService offerService;
    private final OrderLineItemService orderLineItemService;
    private final OrderService orderService;
    private final EmailService emailService;

    public Restcontroller(AccountInfoService accountInfoService, SupplierService supplierService,
            ArticleService articleService, OfferService offerService, OrderLineItemService orderLineItemService,
            OrderService orderService, EmailService emailService) {
        this.accountInfoService = accountInfoService;
        this.supplierService = supplierService;
        this.articleService = articleService;
        this.offerService = offerService;
        this.orderLineItemService = orderLineItemService;
        this.orderService = orderService;
        this.emailService = emailService;
    }

    @PostMapping("/api/v1/sendMail")
    ResponseEntity<Void> sendEmail(@RequestBody MailBody mailBody) {
        emailService.sendSimpleMessage(mailBody);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/api/v1/accounts/{email}")
    ResponseEntity<AccountInfo> fetchAccountInfoByMail(@PathVariable(name = "email") String accountEmail) {
        AccountInfo info = accountInfoService.findByEmail(accountEmail);
        if (info == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(info);
    }

    @GetMapping(path = "/api/v1/accounts/exists/{email}")
    ResponseEntity<Boolean> checkAccountExistens(@PathVariable(name = "email") String accountEmail) {
        return ResponseEntity.ok(accountInfoService.userExist(accountEmail));
    }

    @PostMapping(path = "/api/v1/accounts")
    ResponseEntity<URI> createNewAccount(@RequestBody AccountInfoBody body) throws URISyntaxException {
        AccountInfo info = accountInfoService.createFromBody(body);
        URI uri = new URI("/api/v1/accounts/" + info.getAccountEmail());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/api/v1/accounts/{email}/orderAmount")
    ResponseEntity<Integer> getAccountOrderAmount(@PathVariable(name = "email") String accountEmail) {
        return ResponseEntity.ok(accountInfoService.getOrderAmount(accountEmail));
    }

    @GetMapping(path = "/api/v1/supplierByMail/{email}")
    ResponseEntity<Supplier> fetchSupplierInfoByMail(@PathVariable(name = "email") String accountEmail) {
        Supplier info = supplierService.findByEmail(accountEmail);
        if (info == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(info);
    }

    @GetMapping(path = "/api/v1/supplierById/{id}")
    ResponseEntity<Supplier> fetchSupplierInfoById(@PathVariable(name = "id") int id) {
        Supplier info = supplierService.findByID(id);
        if (info == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(info);
    }

    @GetMapping(path = "/api/v1/supplier/exists/{email}")
    ResponseEntity<Boolean> checkSupplierExistens(@PathVariable(name = "email") String accountEmail) {
        return ResponseEntity.ok(supplierService.userExist(accountEmail));
    }

    @PostMapping(path = "/api/v1/supplier")
    ResponseEntity<URI> createNewSupplier(@RequestBody SupplierBody body) throws URISyntaxException {
        Supplier info = supplierService.createFromBody(body);
        URI uri = new URI("/api/v1/supplier/" + info.getAccountEmail());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/api/v1/supplier/{id}/articles")
    ResponseEntity<Set<Article>> getSupplierArticles(@PathVariable(name = "id") int supplierID) {
        Set<Article> supplierArticles = supplierService.getSuppliersArticles(supplierID);
        return ResponseEntity.ok(supplierArticles);
    }

    @GetMapping(path = "/api/v1/article/{id}")
    ResponseEntity<Article> fetchArticleById(@PathVariable(name = "id") int id) {
        Article article = articleService.findById(id);
        if (article == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(article);
    }

    @GetMapping(path = "/api/v1/article")
    ResponseEntity<List<Article>> fetchAllArticles() {
        return ResponseEntity.ok(articleService.findAll());
    }

    @GetMapping(path = "/api/v1/articleInfo/{id}")
    ResponseEntity<ArticleInfo> fetchArticleInfoById(@PathVariable(name = "id") int id) {
        Article article = articleService.findById(id);
        if (article == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(articleToArticleInfo(article));
    }

    @GetMapping(path = "/api/v1/articleInfo")
    ResponseEntity<List<ArticleInfo>> fetchAllArticleInfos() {
        return ResponseEntity
                .ok(articleService.findAll().stream().map(a -> articleToArticleInfo(a)).collect(Collectors.toList()));
    }

    @PostMapping(path = "/api/v1/article")
    ResponseEntity<URI> createArticle(@RequestBody ArticleBody body) throws URISyntaxException {
        Article article = articleService.createArticle(body);
        URI uri = new URI("api/v1/article/" + article.getArticleId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/api/v1/offer/{id}")
    ResponseEntity<Offer> fetchOfferById(@PathVariable(name = "id") int id) {
        Offer offer = offerService.findById(id);
        if (offer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(offer);
    }

    @GetMapping(path = "/api/v1/offer")
    ResponseEntity<List<Offer>> fetchAllOffers() {
        return ResponseEntity.ok(offerService.findAll());
    }

    @PostMapping(path = "/api/v1/offer")
    ResponseEntity<URI> createOffer(@RequestBody OfferBody body) throws URISyntaxException {
        Offer offer = offerService.createOffer(body);
        URI uri = new URI("api/v1/offer/" + offer.getOfferID());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/offer/{id}")
    ResponseEntity<Offer> updateOfferStatus(@PathVariable(name = "id") int offerID,
            @RequestBody OfferStatus offerStatus) {
        Offer offer = offerService.updateOfferStatus(offerID, offerStatus);
        return offer == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(offer);
    }

    @GetMapping(path = "/api/v1/order/{id}")
    ResponseEntity<Order> getOrderByID(@PathVariable(name = "id") int orderID) {
        Order order = orderService.findById(orderID);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }

    @PostMapping(path = "/api/v1/order")
    ResponseEntity<URI> createNewOrder(@RequestBody OrderBody orderBody) throws URISyntaxException {
        Order order = orderService.createOrder(orderBody);
        Set<OrderLineItem> orderLineItems = new HashSet<>();
        String items = "";
        double totalPrice = 0;
        for (OrderLineItemBodyOrder o : orderBody.getOrderLineItems()) {
            OrderLineItemBody body = new OrderLineItemBody(o.getArticleID(), o.getAmount(), o.getPrice(),
                    order.getOrderID(), o.getItemStatus());
            orderLineItems.add(orderLineItemService.createOrderLineItem(body));
            Article article = articleService.findById(body.getArticleID());
            items += article.getProductdescription().getProduktname() + "- Menge: " + body.getAmount() + " Preis: "
                    + body.getPrice() + "\n";
            totalPrice += body.getPrice() * body.getAmount();
        }
        order.setOrderLineItems(orderLineItems);
        MailBody mailBody = new MailBody("werbungbraucheichnicht@gmail.com",
                accountInfoService.findByID(order.getAcoountInfoID()).getAccountEmail(),
                "Bestellbestätigung zu Bestellung Nummer " + order.getOrderID(),
                EmailService.orderConfirmationTemplate(items, totalPrice).getText());
        emailService.sendSimpleMessage(mailBody);
        URI uri = new URI("/api/v1/order/" + order.getOrderID());
        return ResponseEntity.created(uri).build();
    }

    private ArticleInfo articleToArticleInfo(Article article) {
        return new ArticleInfo(article.getArticleId(), article.getTransparency(), article.getProductdescription(),
                article.getPrice(), article.getImageurl());
    }
}
