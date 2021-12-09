package mas.mockup.masMockup.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import mas.mockup.masMockup.persistence.accounts.SupplierEntity;
import mas.mockup.masMockup.persistence.accounts.SupplierRepository;
import mas.mockup.masMockup.persistence.products.ArticleEntity;
import mas.mockup.masMockup.web.database.accounts.Supplier;
import mas.mockup.masMockup.web.database.accounts.SupplierBody;
import mas.mockup.masMockup.web.database.product.Article;

@Service
public class SupplierService {

    private SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Supplier findByEmail(String emailAdress) {
        return entityToAccountInfo(supplierRepository.findByaccountEmail(emailAdress));
    }

    public Supplier createFromBody(SupplierBody body) {
        SupplierEntity entity = new SupplierEntity(body.getFirmenname(), body.getAccountEmail(), body.getUstID(),
                body.getTelefon(),
                ContactPersonService.bodyToEntity(body.getContactPerson()),
                AdressService.bodyToEntity(body.getDeliveryAdress()), body.getBankaccount());
        entity = supplierRepository.save(entity);
        return entityToAccountInfo(entity);
    }

    public boolean userExist(String email) {
        return supplierRepository.existsByaccountEmail(email);
    }

    public Set<Article> getSuppliersArticles(int supplierID) {
        Optional<SupplierEntity> optionalEntity = supplierRepository.findById(supplierID);
        if (optionalEntity.isEmpty()) {
            return new HashSet<Article>();
        }

        SupplierEntity entity = optionalEntity.get();

        Set<ArticleEntity> articleEntities = entity.getArticles();
        return articleEntities.stream()
                .map(articleEntity -> new Article(articleEntity.getArticleId(),
                        TransperencyService.entityToTrans(articleEntity.getTransparency()),
                        ProductDescriptionService.entityToProductDescription(articleEntity.getProductdescription()),
                        articleEntity.getPrice(), articleEntity.getImageurl(),
                        articleEntity.getSupplier().getAccountID(), articleEntity.getLagermenge(),
                        articleEntity.getMindestmenge(), articleEntity.getEinkaufspreis()))
                .collect(Collectors.toSet());
    }

    public static Supplier entityToAccountInfo(SupplierEntity entity) {

        return new Supplier(entity.getAccountID(), entity.getFirmenname(), entity.getAccountEmail(), entity.getUstID(),
                entity.getTelefon(),
                ContactPersonService.EntityToContact(entity.getContactPerson()),
                AdressService.entityToAdress(entity.getDeliveryAdress()), entity.getBankaccount());
    }

    public static Supplier entityToAccountInfo(Optional<SupplierEntity> entity) {
        if (entity.isEmpty()) {
            return null;
        }

        return entityToAccountInfo(entity.get());
    }

    public Supplier findByID(int id) {
        return entityToAccountInfo(supplierRepository.findById(id));
    }

    public SupplierEntity findByIDEntity(int id) {
        Optional<SupplierEntity> entity = supplierRepository.findById(id);
        if (entity.isEmpty()) {
            return null;
        }
        return entity.get();
    }

}
