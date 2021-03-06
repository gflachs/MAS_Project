package mas.mockup.masMockup.web.api.restcontroller;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import mas.mockup.masMockup.persistence.accounts.SupplierEntity;
import mas.mockup.masMockup.persistence.products.ArticleEntity;
import mas.mockup.masMockup.services.AccountInfoService;
import mas.mockup.masMockup.services.ArticleService;
import mas.mockup.masMockup.services.Bestellauftragsservice;
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
import mas.mockup.masMockup.web.database.banf.ImporteurBestellung;
import mas.mockup.masMockup.web.database.banf.ImporteurBestellungBody;
import mas.mockup.masMockup.web.database.banf.Lieferantenauftrag;
import mas.mockup.masMockup.web.database.banf.LieferantenauftragBody;
import mas.mockup.masMockup.web.database.banf.Lieferauftragsdate;
import mas.mockup.masMockup.web.database.banf.banfitem.BanfItemBodyBanf;
import mas.mockup.masMockup.web.database.banf.banfitem.BanfItemChangePriceAndAmountRequest;
import mas.mockup.masMockup.web.database.banf.banfitem.Banfitem;
import mas.mockup.masMockup.web.database.banf.banfitem.itemstatus.ItemStatus;
import mas.mockup.masMockup.web.database.order.Order;
import mas.mockup.masMockup.web.database.order.OrderBody;
import mas.mockup.masMockup.web.database.order.OrderReklamtion;
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
    private final Bestellauftragsservice bestellauftragsservice;

    public Restcontroller(AccountInfoService accountInfoService, SupplierService supplierService,
            ArticleService articleService, OfferService offerService, OrderLineItemService orderLineItemService,
            OrderService orderService, EmailService emailService, Bestellauftragsservice bestellauftragsservice) {
        this.accountInfoService = accountInfoService;
        this.supplierService = supplierService;
        this.articleService = articleService;
        this.offerService = offerService;
        this.orderLineItemService = orderLineItemService;
        this.orderService = orderService;
        this.emailService = emailService;
        this.bestellauftragsservice = bestellauftragsservice;
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

    @GetMapping(path = "/api/v1/accountsById/{id}")
    ResponseEntity<AccountInfo> fetchAccountInfoByMail(@PathVariable(name = "id") int id) {
        AccountInfo info = accountInfoService.findByID(id);
        if (info == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(info);
    }

    @GetMapping(path = "/api/v1/accounts/exists/{email}")
    ResponseEntity<Boolean> checkAccountExistens(@PathVariable(name = "email") String accountEmail) {
        return ResponseEntity.ok(accountInfoService.userExist(accountEmail));
    }

    @PostMapping(path = "/api/v1/accounts", produces = "application/json;charset=UTF-8")
    ResponseEntity<URI> createNewAccount(@RequestBody AccountInfoBody body) throws URISyntaxException {
        AccountInfo info = accountInfoService.createFromBody(body);
        MailBody mailBody = new MailBody("Kundenservice", info.getAccountEmail(),
                "Herzlich Willkommen bei der NaturNah GmbH",
                "Sehr geehrte Damen und Herren,\nvielen Dank f??r Ihre Registrierung bei der NaturNah GmbH. Wir freuen uns auf eine erfoglreiche Zusammenarbeit. Bitte geben Sie ab jetzt bei jeder Bestellung Ihre Emailadresse an.\n\nIhre NaturNah GmbH");
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
    ResponseEntity<Order> getOrderByID(@PathVariable(name = "id") long orderID) {
        Order order = orderService.findById(orderID);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(order);
    }

    @PostMapping(path = "/api/v1/order")
    ResponseEntity<Long> createNewOrder(@RequestBody OrderBody orderBody) throws URISyntaxException {
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
                "Bestellbest??tigung zu Bestellung Nummer " + order.getOrderID(),
                EmailService.orderConfirmationTemplate(items, totalPrice, order.getRabatt(), order.getVersandkosten())
                        .getText());
        emailService.sendSimpleMessage(mailBody);
        URI uri = new URI("api/v1/order/" + order.getOrderID());
        return ResponseEntity.created(uri).body(order.getOrderID());
    }

    @GetMapping(path = "api/v1/banfitem/{id}")
    ResponseEntity<Banfitem> fetchBanfItemById(@PathVariable(name = "id") int banfItemId) {
        Banfitem item = bestellauftragsservice.findBanfItemById(banfItemId);
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(item);
    }

    @GetMapping(path = "api/v1/article/{articleid}/openBanf")
    ResponseEntity<Integer> checkBanfItemExistens(@PathVariable(name = "articleid") int articleID) {
        return ResponseEntity.ok(articleService.checkOpenBanf(articleID));
    }

    @PostMapping(path = "api/v1/banfitem")
    ResponseEntity<Banfitem> createBanfItem(@RequestBody BanfItemBodyBanf body) throws URISyntaxException {
        ArticleEntity articleEntity = articleService.findByIdToEntity(body.getArticleID());
        Banfitem banfitem = bestellauftragsservice.createBanfItem(body, articleEntity);
        URI uri = new URI("api/v1/banfitem/" + banfitem.getItemID());
        return ResponseEntity.created(uri).body(banfitem);
    }

    @PutMapping(path = "api/v1/banfitem/{id}/status")
    ResponseEntity<Banfitem> updateBanfItemStatus(@PathVariable(name = "id") int banfItemId,
            @RequestBody ItemStatus itemStatus) {
        Banfitem banfitem = bestellauftragsservice.updateBanfItemStatus(banfItemId, itemStatus);
        if (banfitem == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(banfitem);
    }

    @PutMapping(path = "api/v1/banfitem/{id}/priceAndamount")
    ResponseEntity<Banfitem> updateBanfItemPriceAndAmount(@PathVariable(name = "id") int banfItemId,
            @RequestBody BanfItemChangePriceAndAmountRequest banfItemChangePriceAndAmountRequest) {
        Banfitem banfitem = bestellauftragsservice.updateBanfItem(banfItemId, banfItemChangePriceAndAmountRequest);
        if (banfitem == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(banfitem);
    }

    @GetMapping(path = "api/v1/lieferantenauftrag/{id}")
    ResponseEntity<Lieferantenauftrag> fetchLieferantenAuftragById(@PathVariable(name = "id") int id) {
        Lieferantenauftrag bestellung = bestellauftragsservice.findLieferantenauftragById(id);
        return bestellung == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(bestellung);
    }

    @GetMapping(path = "api/v1/lieferantenauftrag/{id}/bezahlt")
    ResponseEntity<Lieferantenauftrag> setBezahlt(@PathVariable(name = "id") long id) {
        Lieferantenauftrag lA = bestellauftragsservice.setLieferantenauftragBezahlt(id);
        return lA == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(lA);
    }

    @PutMapping(path = "api/v1/lieferantenauftrag/{id}/rechnung")
    ResponseEntity<Lieferantenauftrag> setRechnung(@PathVariable(name = "id") long id, @RequestBody File rechnung) {
        Lieferantenauftrag lA = bestellauftragsservice.setRechnung(id, rechnung);
        return lA == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(lA);
    }

    @PostMapping(path = "api/v1/lieferantenauftrag")
    ResponseEntity<Lieferantenauftrag> createLieferantenAuftrag(@RequestBody LieferantenauftragBody body)
            throws URISyntaxException {
        SupplierEntity supplier = supplierService.findEntityById(body.getSupplierID());
        Lieferantenauftrag lieferantenauftrag = bestellauftragsservice.createLieferantenauftrag(body, supplier);
        URI uri = new URI("api/v1/lieferantenauftrag/" + lieferantenauftrag.getLieferauftragsID());
        return ResponseEntity.created(uri).body(lieferantenauftrag);
    }

    @PutMapping(path = "api/v1/lieferantenauftragabholung/{id}")
    ResponseEntity<Lieferantenauftrag> updateLieferantenAuftragDatum(
            @PathVariable(name = "id") long lieferantenAuftragsid, @RequestBody Lieferauftragsdate date) {
        System.out.println(date.getLieferauftragsDatum());
        Date d = null;
        try {

            d = new SimpleDateFormat("mm/dd/yyyy HH:mm:ss").parse(date.getLieferauftragsDatum());
        } catch (ParseException e) {

            e.printStackTrace();
        }

        Lieferantenauftrag auftrag = bestellauftragsservice.updateLieferauftragAbholDatumById(lieferantenAuftragsid,
                d);
        if (auftrag == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(auftrag);
    }

    @GetMapping(path = "api/v1/importeurauftrag/{id}")
    ResponseEntity<ImporteurBestellung> fetchImporteurAuftragById(@PathVariable(name = "id") int id) {
        ImporteurBestellung bestellung = bestellauftragsservice.findImporteurBestellungById(id);
        return bestellung == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(bestellung);
    }

    @PostMapping(path = "api/v1/importeurauftrag")
    ResponseEntity<ImporteurBestellung> createImporteurAuftrag(@RequestBody ImporteurBestellungBody body)
            throws URISyntaxException {
        ImporteurBestellung importeurBestellung = bestellauftragsservice.createImporteurBestellung(body);
        URI uri = new URI("api/v1/importeurauftrag/" + importeurBestellung.getBestellID());
        return ResponseEntity.created(uri).body(importeurBestellung);
    }

    @PutMapping(path = "api/v1/importeurauftrag/{id}/geliefert")
    ResponseEntity<ImporteurBestellung> setImporteurAuftragGeliefert(@PathVariable(name = "id") int auftragsID) {
        ImporteurBestellung bestellung = bestellauftragsservice.setImportteurBestellungsGeliefert(auftragsID);

        if (bestellung == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(bestellung);
    }

    @PutMapping(path = "api/v1/banfitemFreigeben/{id}")
    ResponseEntity<Void> banfItemFreigeben(@PathVariable int id) {
        bestellauftragsservice.banfItemFreigeben(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "api/v1/sendAbsageSupplier/{id}")
    ResponseEntity<Void> sendAbsageSupplier(@RequestBody String text, @PathVariable(name = "id") int id) {
        Supplier supplier = supplierService.findByID(id);
        MailBody mailBody = new MailBody("werbungbraucheichnicht@gmail.com", supplier.getAccountEmail(),
                "Absage zu Ihrem Angebot", text);
        emailService.sendSimpleMessage(mailBody);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "api/v1/sendAbsageReklamation")
    ResponseEntity<Void> sendAbsageReklamation(@RequestBody MailBody mailBody) {
        emailService.sendSimpleMessage(mailBody);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "api/v1/orderReklamtion/{id}")
    ResponseEntity<OrderReklamtion> getOrderReklamation(@PathVariable(name = "id") long orderID) {
        OrderReklamtion reklamtion = orderService.getReklamationsInfo(orderID);
        return reklamtion == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(reklamtion);
    }

    @GetMapping(path = "api/v1/orderVersendet/{id}")
    ResponseEntity<Order> setOrderversendet(@PathVariable(name = "id") long orderID) {
        Order order = orderService.orderVersendet(orderID);
        return order == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(order);
    }

    private ArticleInfo articleToArticleInfo(Article article) {
        return new ArticleInfo(article.getArticleId(), article.getTransparency(), article.getProductdescription(),
                article.getPrice(), article.getImageurl());
    }
}
