package mas.mockup.masMockup.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import mas.mockup.masMockup.persistence.accounts.SupplierEntity;
import mas.mockup.masMockup.persistence.products.OfferEntity;
import mas.mockup.masMockup.persistence.products.OfferRepository;
import mas.mockup.masMockup.persistence.products.offerStatus.OfferStatusEntity;
import mas.mockup.masMockup.web.database.product.Offer;
import mas.mockup.masMockup.web.database.product.OfferBody;
import mas.mockup.masMockup.web.database.product.offerStatus.OfferStatus;


@Service
public class OfferService {
    
    private OfferRepository offerRepository;
    private SupplierService supplierService;


    public OfferService(OfferRepository offerRepository, SupplierService supplierService) {
        this.offerRepository = offerRepository;
        this.supplierService = supplierService;
    }

    public Offer createOffer (OfferBody body) {
        OfferEntity entity = bodyToEntity(body, supplierService);
        entity = offerRepository.save(entity);
        return entityToOffer(entity);
    }

    public Offer updateOfferStatus(int offerID, OfferStatus offerStatus) {
        Optional<OfferEntity> optionalEntity = offerRepository.findById(offerID);
        if (optionalEntity.isEmpty()) {
            return null;
        }
        OfferEntity entity = optionalEntity.get();
        OfferStatusEntity offerStatusEntity = new OfferStatusEntity();
        offerStatusEntity.setOfferStatus(offerStatus.getOfferStatus());
        entity.setOfferStatusEntity(offerStatusEntity);
        entity = offerRepository.save(entity);
        return entityToOffer(entity);
    }

    public Offer findById (int id) {
        return entityToOffer(offerRepository.findById(id));
    }

    public List<Offer> findAll () {
        List<OfferEntity> offerEntities = offerRepository.findAll();
        return offerEntities.stream().map(entity -> entityToOffer(entity)).collect(Collectors.toList());
    }

    public static Offer entityToOffer (OfferEntity entity) {
        return new Offer(entity.getOfferId(), TransperencyService.entityToTrans(entity.getTransparency()), ProductDescriptionService.entityToProductDescription(entity.getProductdescription()), entity.getPrice(),entity.getImageurl(),new OfferStatus(entity.getOfferStatusEntity().getOfferStatus()), entity.getSupplier().getAccountID());
    }

    public static Offer entityToOffer (Optional<OfferEntity> entity) {
        if (entity.isEmpty()) {
            return null;
        }

        return entityToOffer(entity.get());
    }

    public static OfferEntity bodyToEntity (OfferBody body, SupplierService supplierService) {
        SupplierEntity supplier = supplierService.findByIDEntity(body.getSupplierID());
        OfferStatusEntity offerStatusEntity = new OfferStatusEntity();
        offerStatusEntity.setOfferStatus(body.getOfferStatus().getOfferStatus());
        OfferEntity entity = new OfferEntity(TransperencyService.bodyToEntity(body.getTransparency()), ProductDescriptionService.bodyToEntity(body.getProductdescription()), body.getPrice(), body.getImageURL(),offerStatusEntity, supplier);
        return entity;
    }

}
