package mas.mockup.masMockup.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import mas.mockup.masMockup.persistence.accounts.SupplierEntity;
import mas.mockup.masMockup.persistence.products.ArticleEntity;
import mas.mockup.masMockup.persistence.products.ArticleRepository;
import mas.mockup.masMockup.web.database.product.Article;
import mas.mockup.masMockup.web.database.product.ArticleBody;

@Service
public class ArticleService {
    
    private ArticleRepository articleRepository;
    private SupplierService supplierService;


    public ArticleService(ArticleRepository articleRepository, SupplierService supplierService) {
        this.articleRepository = articleRepository;
        this.supplierService = supplierService;
    }

    public Article createArticle (ArticleBody body) {
        ArticleEntity entity = bodyToEntity(body, supplierService);
        entity = articleRepository.save(entity);
        return entityToArticle(entity);
    }

    public Article findById (int id) {
        return entityToArticle(articleRepository.findById(id));
    }

    public List<Article> findAll () {
        List<ArticleEntity> articleEntities = articleRepository.findAll();
        return articleEntities.stream().map(entity -> entityToArticle(entity)).collect(Collectors.toList());
    }

    public static Article entityToArticle (ArticleEntity entity) {
        return new Article(entity.getArticleId(), TransperencyService.entityToTrans(entity.getTransparency()), ProductDescriptionService.entityToProductDescription(entity.getProductdescription()), entity.getPrice(),entity.getImageurl(), entity.getSupplier().getAccountID());
    }

    public static Article entityToArticle (Optional<ArticleEntity> entity) {
        if (entity.isEmpty()) {
            return null;
        }

        return entityToArticle(entity.get());
    }

    public static ArticleEntity bodyToEntity (ArticleBody body, SupplierService supplierService) {
        SupplierEntity supplier = supplierService.findByIDEntity(body.getSupplierID());
        return new ArticleEntity(TransperencyService.bodyToEntity(body.getTransparency()), ProductDescriptionService.bodyToEntity(body.getProductdescription()), body.getPrice(), body.getImageurl(), supplier);
    }

    public ArticleEntity findByIdToEntity(int articleID) {
        Optional<ArticleEntity> optional = articleRepository.findById(articleID);
        if (optional.isEmpty()) {
            return null;
        }
        return optional.get();
    }

}
