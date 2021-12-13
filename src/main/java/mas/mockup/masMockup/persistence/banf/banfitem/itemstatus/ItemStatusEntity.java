package mas.mockup.masMockup.persistence.banf.banfitem.itemstatus;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import mas.mockup.masMockup.persistence.banf.banfitem.BanfItemEntity;

@Entity(name = "banfitemstatus")
public class ItemStatusEntity {

    @Id
    private String itemStatus;

    @OneToMany(mappedBy = "itemStatus", fetch = FetchType.LAZY)
    private Set<BanfItemEntity> banfItemEntities;

    public ItemStatusEntity() {
    }

    public Set<BanfItemEntity> getOrderLineItemEntity() {
        return banfItemEntities;
    }

    public void setOrderLineItemEntity(Set<BanfItemEntity> banfItemEntities) {
        this.banfItemEntities = banfItemEntities;
    }

    public ItemStatusEntity(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }
}
