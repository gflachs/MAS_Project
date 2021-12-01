package mas.mockup.masMockup.persistence.accounts.contactPerson;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactPersonRepository extends JpaRepository<ContactPersonEntity, Integer>{
    
}
