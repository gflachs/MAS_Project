package mas.mockup.masMockup.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import mas.mockup.masMockup.persistence.products.description.DescriptionEntity;
import mas.mockup.masMockup.persistence.products.description.DescriptionRepository;
import mas.mockup.masMockup.web.database.product.description.Productdescription;
import mas.mockup.masMockup.web.database.product.description.ProductdescriptionBody;

@Service
public class ProductDescriptionService {
    
    private DescriptionRepository descriptionRepository;

    public ProductDescriptionService(DescriptionRepository descriptionRepository) {
        this.descriptionRepository = descriptionRepository;
    }

    public Productdescription createProductdescription (ProductdescriptionBody body) {
        DescriptionEntity entity = bodyToEntity(body);
        entity = descriptionRepository.save(entity);
        return entityToProductDescription(entity);
    }

    public DescriptionEntity createProductdescriptionEntity (ProductdescriptionBody body) {
        DescriptionEntity entity = bodyToEntity(body);
        entity = descriptionRepository.save(entity);
        return entity;
    }




    public static DescriptionEntity bodyToEntity (ProductdescriptionBody body) {
        return new DescriptionEntity(body.getProduktname(), body.getDescription(), body.getIngridients());
    }

    public static Productdescription entityToProductDescription (DescriptionEntity entity) {
        return new Productdescription(entity.getID(), entity.getProduktname(), entity.getDescription(), entity.getIngridients());
    }

    public static Productdescription entityToProductDescription (Optional<DescriptionEntity> entity) {
        if (entity.isEmpty()) {
            return null;
        }

        return entityToProductDescription(entity.get());
    }

}
