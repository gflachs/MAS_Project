package mas.mockup.masMockup.persistence.accounts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, Integer>{

    public Optional<SupplierEntity> findByaccountEmail(String email);
    public boolean existsByaccountEmail (String email);
}
    

