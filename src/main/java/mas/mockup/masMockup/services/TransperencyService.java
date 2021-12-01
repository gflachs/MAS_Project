package mas.mockup.masMockup.services;

import java.util.Optional;


import org.springframework.stereotype.Service;


import mas.mockup.masMockup.persistence.products.transperency.TransperencyEntity;
import mas.mockup.masMockup.persistence.products.transperency.TransperencyRepository;
import mas.mockup.masMockup.web.database.product.transparency.Transparency;
import mas.mockup.masMockup.web.database.product.transparency.TransparencyBody;

@Service
public class TransperencyService {
    
    private TransperencyRepository transperencyRepository;
    

  
    public TransperencyService(TransperencyRepository transperencyRepository) {
        this.transperencyRepository = transperencyRepository;
       
    }

    public Transparency createToTransperency (TransparencyBody body) {
        TransperencyEntity entity = bodyToEntity(body);
        entity = transperencyRepository.save(entity);
        return entityToTrans(entity);
    }

    public static Transparency entityToTrans (TransperencyEntity entity) {
        return new Transparency(entity.getid(), entity.getProduzent(), AdressService.entityToAdress(entity.getProduktionsort()));
    }

    public static Transparency entityToTrans (Optional<TransperencyEntity> entity) {
        if (entity.isEmpty()) {
            return null;
        }

        return entityToTrans(entity);
    }

    public static TransperencyEntity bodyToEntity (TransparencyBody body) {
        return new TransperencyEntity(body.getProduzent(), AdressService.bodyToEntity(body.getProduktionsort()));
    }

    

}
