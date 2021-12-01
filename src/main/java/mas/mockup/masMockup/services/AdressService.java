package mas.mockup.masMockup.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import mas.mockup.masMockup.persistence.accounts.adress.AdressEntity;
import mas.mockup.masMockup.persistence.accounts.adress.AdressRepository;
import mas.mockup.masMockup.web.database.accounts.adress.Adress;
import mas.mockup.masMockup.web.database.accounts.adress.AdressBody;

@Service
public class AdressService {
    
    private AdressRepository adressRepository;

    public AdressService(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    public Adress getById(int id) {
        return entityToAdress(adressRepository.findById(id));
    }

    public AdressEntity createAdressToEntity (AdressBody body) {
        AdressEntity entity = bodyToEntity(body);
        entity = adressRepository.save(entity);
        return entity;
    }

    public Adress createAdressToAdress (AdressBody body) {
        AdressEntity entity = bodyToEntity(body);
        entity = adressRepository.save(entity);
        return entityToAdress(entity);
    }

    

    public static Adress entityToAdress (AdressEntity entity) {
        return new Adress(entity.getAdressID(), entity.getStreet(), entity.getHouseNumber(), entity.getZipCode());
    }

    public static Adress entityToAdress (Optional<AdressEntity> entity) {
        if (!entity.isPresent()) {
            return null;
        }
        return entityToAdress(entity.get());
    }

    public static AdressEntity bodyToEntity (AdressBody body) {
        return new AdressEntity(body.getStreet(), body.getHouseNumber(), body.getZipCode());
    }

}
