package mas.mockup.masMockup.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import mas.mockup.masMockup.persistence.accounts.contactPerson.ContactPersonEntity;
import mas.mockup.masMockup.persistence.accounts.contactPerson.ContactPersonRepository;
import mas.mockup.masMockup.web.database.accounts.contactPerson.ContactBody;
import mas.mockup.masMockup.web.database.accounts.contactPerson.ContactPerson;

@Service
public class ContactPersonService {
    
    private ContactPersonRepository contactPersonRepository;

    public ContactPersonService(ContactPersonRepository contactPersonRepository) {
        this.contactPersonRepository = contactPersonRepository;
    }

    public ContactPerson getContactPersonById (int id) {
        return EntityToContact(contactPersonRepository.findById(id));
    }

    public ContactPersonEntity createContactPersontoEntity (ContactBody body) {

        ContactPersonEntity entity = bodyToEntity(body);
        entity = contactPersonRepository.save(entity);
        return entity;
    }

    public ContactPerson createContactPersontoPerson (ContactBody body) {

        ContactPersonEntity entity = bodyToEntity(body);
        entity = contactPersonRepository.save(entity);
        return EntityToContact(entity);
    }

    public static ContactPersonEntity bodyToEntity (ContactBody body) {
        return new ContactPersonEntity(body.getSurname(), body.getLastname(), body.getTelefonNumber());
    }

    public static ContactPerson EntityToContact (ContactPersonEntity contactEntity) {

        return new ContactPerson(contactEntity.getContactID(), contactEntity.getSurname(), contactEntity.getLastname(), contactEntity.getTelefonNumber());
    }

    public static ContactPerson EntityToContact (Optional<ContactPersonEntity> contactEntity) {

        if (!contactEntity.isPresent()) {
            return null;
        }
        return EntityToContact(contactEntity.get());
    }
    


}
