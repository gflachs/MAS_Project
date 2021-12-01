package mas.mockup.masMockup.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import mas.mockup.masMockup.persistence.accounts.AccountInfoEntity;
import mas.mockup.masMockup.persistence.accounts.AccountInfoRepository;
import mas.mockup.masMockup.web.database.accounts.AccountInfo;
import mas.mockup.masMockup.web.database.accounts.AccountInfoBody;

@Service
public class AccountInfoService {
    
    private AccountInfoRepository accountInfoRepository;


    public AccountInfoService(AccountInfoRepository accountInfoRepository) {
        this.accountInfoRepository = accountInfoRepository;
    }

    public AccountInfo findByEmail (String emailAdress) {
        return entityToAccountInfo(accountInfoRepository.findByaccountEmail(emailAdress));
    }

    public AccountInfo findByID (int accountID) {
        return entityToAccountInfo(accountInfoRepository.findById(accountID));
    }

    public AccountInfo createFromBody (AccountInfoBody body) {
       
        AccountInfoEntity entity = new AccountInfoEntity(body.getAccountEmail(), body.getUstID(), body.getTelefon(), ContactPersonService.bodyToEntity(body.getContactPerson()), AdressService.bodyToEntity(body.getDeliveryAdress()), body.getBankaccount());
        entity = accountInfoRepository.save(entity);   
        return entityToAccountInfo(entity);
    }

    public boolean userExist (String email) {
        return accountInfoRepository.existsByaccountEmail(email);
    }

    public static AccountInfo entityToAccountInfo (AccountInfoEntity entity) {
        
        return new AccountInfo(entity.getAccountID(), entity.getAccountEmail(), entity.getUstID(), entity.getTelefon(), ContactPersonService.EntityToContact(entity.getContactPerson()), AdressService.entityToAdress(entity.getDeliveryAdress()), entity.getBankaccount());
    }

    public static AccountInfo entityToAccountInfo (Optional<AccountInfoEntity> entity) {
        if (entity.isEmpty()) {
            return null;
        }

        return entityToAccountInfo(entity.get());
    }

    public AccountInfoEntity findEntityByID(int accountInfoID) {
        Optional<AccountInfoEntity> optional = accountInfoRepository.findById(accountInfoID);
        return optional.isPresent()?optional.get():null;
    }

}
