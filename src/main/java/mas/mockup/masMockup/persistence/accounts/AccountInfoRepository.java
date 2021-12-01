package mas.mockup.masMockup.persistence.accounts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountInfoRepository extends JpaRepository<AccountInfoEntity, Integer>{

    public Optional<AccountInfoEntity> findByaccountEmail(String email);
    public boolean existsByaccountEmail (String email);
}
    

