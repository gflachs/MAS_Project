package mas.mockup.masMockup.persistence.products.offerStatus;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.OneToMany;


import mas.mockup.masMockup.persistence.products.OfferEntity;

@Entity
public class OfferStatusEntity {
    
    @Id
    @Column(name = "offerstatus")
    private String offerStatus;

    @OneToMany(mappedBy = "offerStatusEntity")
    private Set<OfferEntity> offerEntity;

    public OfferStatusEntity() {
    }

    public Set<OfferEntity> getOfferEntity() {
        return offerEntity;
    }

    public void setOfferEntity(Set<OfferEntity> offerEntity) {
        this.offerEntity = offerEntity;
    }

    public String getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(String offerStatus) {
        this.offerStatus = offerStatus;
    }


}
