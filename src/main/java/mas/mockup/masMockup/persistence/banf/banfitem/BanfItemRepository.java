package mas.mockup.masMockup.persistence.banf.banfitem;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mas.mockup.masMockup.persistence.banf.banfitem.itemstatus.ItemStatusEntity;
import mas.mockup.masMockup.persistence.products.ArticleEntity;

@Repository
public interface BanfItemRepository extends JpaRepository<BanfItemEntity, Integer> {

    List<BanfItemEntity> findAllByItemStatus(ItemStatusEntity itemStatusEntity);

    Optional<BanfItemEntity> findByItemStatusAndByArticle(ItemStatusEntity itemStatusEntity,
            ArticleEntity articleEntity);

}
