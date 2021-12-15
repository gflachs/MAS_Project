package mas.mockup.masMockup.services;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import mas.mockup.masMockup.persistence.accounts.SupplierEntity;
import mas.mockup.masMockup.persistence.banf.ImporteuerBestellungEntity;
import mas.mockup.masMockup.persistence.banf.ImporteurBestellungRepository;
import mas.mockup.masMockup.persistence.banf.LieferauftragEntity;
import mas.mockup.masMockup.persistence.banf.LieferauftragRepository;
import mas.mockup.masMockup.persistence.banf.banfitem.BanfItemEntity;
import mas.mockup.masMockup.persistence.banf.banfitem.BanfItemRepository;
import mas.mockup.masMockup.persistence.banf.banfitem.itemstatus.ItemStatusEntity;
import mas.mockup.masMockup.persistence.products.ArticleEntity;
import mas.mockup.masMockup.web.database.banf.ImporteurBestellung;
import mas.mockup.masMockup.web.database.banf.ImporteurBestellungBody;
import mas.mockup.masMockup.web.database.banf.Lieferantenauftrag;
import mas.mockup.masMockup.web.database.banf.LieferantenauftragBody;
import mas.mockup.masMockup.web.database.banf.banfitem.BanfItemBodyBanf;
import mas.mockup.masMockup.web.database.banf.banfitem.BanfItemChangePriceAndAmountRequest;
import mas.mockup.masMockup.web.database.banf.banfitem.Banfitem;
import mas.mockup.masMockup.web.database.banf.banfitem.itemstatus.ItemStatus;

@Service
public class Bestellauftragsservice {

    private final ImporteurBestellungRepository importeurBestellungRepository;
    private final LieferauftragRepository lieferauftragRepository;
    private final BanfItemRepository banfItemRepository;

    public Bestellauftragsservice(ImporteurBestellungRepository importeurBestellungRepository,
            LieferauftragRepository lieferauftragRepository, BanfItemRepository banfItemRepository) {
        this.importeurBestellungRepository = importeurBestellungRepository;
        this.lieferauftragRepository = lieferauftragRepository;
        this.banfItemRepository = banfItemRepository;
    }

    public ImporteurBestellung createImporteurBestellung(ImporteurBestellungBody body) {
        ImporteuerBestellungEntity entity = new ImporteuerBestellungEntity(false);
        entity = importeurBestellungRepository.save(entity);
        Set<Lieferantenauftrag> lieferantenauftrags = new HashSet<>();
        for (Lieferantenauftrag lieferantenauftrag : body.getLieferauftraege()) {

            lieferantenauftrags
                    .add(updateLieferauftragImporteurBestellungById(lieferantenauftrag.getLieferauftragsID(), entity));
        }
        ImporteurBestellung importeurBestellung = iBEntityToIB(entity);
        importeurBestellung.setLieferauftraege(lieferantenauftrags);
        return importeurBestellung;
    }

    public ImporteurBestellung findImporteurBestellungById(int id) {
        Optional<ImporteuerBestellungEntity> optional = importeurBestellungRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }

        return iBEntityToIB(optional.get());
    }

    public Lieferantenauftrag createLieferantenauftrag(LieferantenauftragBody body,
            SupplierEntity supplier) {

        LieferauftragEntity lieferauftragEntity = lABodyToEntity(body, supplier);
        lieferauftragEntity = lieferauftragRepository.save(lieferauftragEntity);
        Set<Banfitem> banfitems = new HashSet<>();

        for (Banfitem banfitem : body.getBanfItems()) {
            banfitems.add(updateBanfItemLieferAuftrag(banfitem.getItemID(), lieferauftragEntity));
        }
        Lieferantenauftrag lieferantenauftrag = lAEntityToLA(lieferauftragEntity);
        lieferantenauftrag.setBanfItems(banfitems);

        return lieferantenauftrag;
    }

    public Lieferantenauftrag updateLieferauftragImporteurBestellungById(long id, ImporteuerBestellungEntity entity) {
        Optional<LieferauftragEntity> lieferauftragEntityO = lieferauftragRepository.findById(id);
        if (lieferauftragEntityO.isEmpty()) {
            return null;
        }
        LieferauftragEntity lieferauftragEntity = lieferauftragEntityO.get();
        lieferauftragEntity.setImportBestellung(entity);
        lieferauftragEntity = lieferauftragRepository.save(lieferauftragEntity);
        return lAEntityToLA(lieferauftragEntity);

    }

    public Lieferantenauftrag updateLieferauftragAbholDatumById(long id, Date abholDatum) {
        Optional<LieferauftragEntity> lieferauftragEntityO = lieferauftragRepository.findById(id);
        if (lieferauftragEntityO.isEmpty()) {
            return null;
        }
        LieferauftragEntity lieferauftragEntity = lieferauftragEntityO.get();
        lieferauftragEntity.setAbholDatum(abholDatum);
        lieferauftragEntity = lieferauftragRepository.save(lieferauftragEntity);
        return lAEntityToLA(lieferauftragEntity);

    }

    public Lieferantenauftrag findLieferantenauftragById(long id) {
        Optional<LieferauftragEntity> optional = lieferauftragRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }

        return lAEntityToLA(optional.get());
    }

    public Banfitem updateBanfItem(int id, BanfItemChangePriceAndAmountRequest banfitem) {
        Optional<BanfItemEntity> optional = banfItemRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        BanfItemEntity entity = optional.get();
        entity.setAmount(banfitem.getAmount());
        entity.setPrice(banfitem.getPrice());
        System.out.println(banfitem.getAmount() + " " + banfitem.getPrice());
        System.out.println(entity.getAmount() + " " + entity.getPrice());
        entity = banfItemRepository.save(entity);
        System.out.println(entity.getAmount() + " " + entity.getPrice());
        return bIEntityToBI(entity);
    }

    public Banfitem updateBanfItemLieferAuftrag(int id, LieferauftragEntity lieferauftragEntity) {
        Optional<BanfItemEntity> optional = banfItemRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        BanfItemEntity entity = optional.get();
        entity.setLieferauftragEntity(lieferauftragEntity);
        entity = banfItemRepository.save(entity);
        return bIEntityToBI(entity);
    }

    public Banfitem updateBanfItemStatus(int id, ItemStatus itemStatus) {
        Optional<BanfItemEntity> optional = banfItemRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        BanfItemEntity entity = optional.get();
        entity.setItemStatus(new ItemStatusEntity(itemStatus.getItemStatus()));
        entity = banfItemRepository.save(entity);
        return bIEntityToBI(entity);
    }

    public Banfitem createBanfItem(BanfItemBodyBanf body, ArticleEntity articleEntity) {
        BanfItemEntity entity = bIBodyToEntity(body, articleEntity);
        entity = banfItemRepository.save(entity);
        return bIEntityToBI(entity);
    }

    public Banfitem findBanfItemById(int id) {
        Optional<BanfItemEntity> optional = banfItemRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        return bIEntityToBI(optional.get());
    }

    public Banfitem findBanfItemByStatusAndArticleEntity(ItemStatus itemStatus, ArticleEntity entity) {
        Optional<BanfItemEntity> optional = banfItemRepository
                .findByItemStatusAndArticle(new ItemStatusEntity(itemStatus.getItemStatus()), entity);
        if (optional.isEmpty()) {
            return null;
        }
        return bIEntityToBI(optional.get());
    }

    public ImporteurBestellung setImportteurBestellungsGeliefert(int id) {
        Optional<ImporteuerBestellungEntity> optional = importeurBestellungRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        ImporteuerBestellungEntity bestellung = optional.get();
        bestellung.setAbholDatum(true);
        bestellung = importeurBestellungRepository.save(bestellung);
        return iBEntityToIB(bestellung);
    }

    public static BanfItemEntity bIBodyToEntity(BanfItemBodyBanf body, ArticleEntity entity) {
        return new BanfItemEntity(entity, body.getAmount(), body.getPrice(),
                new ItemStatusEntity(body.getItemStatus().getItemStatus()), null);
    }

    public static LieferauftragEntity lABodyToEntity(LieferantenauftragBody body, SupplierEntity supplier) {
        return new LieferauftragEntity(body.getOrderDate(), supplier, null, null);
    }

    public static ImporteurBestellung iBEntityToIB(ImporteuerBestellungEntity entity) {
        Set<Lieferantenauftrag> lieferantenauftrags = entity.getLieferauftraege() == null ? null
                : entity.getLieferauftraege().stream().map(e -> lAEntityToLA(e))
                        .collect(Collectors.toSet());
        return new ImporteurBestellung(entity.getBestellID(), lieferantenauftrags, entity.getAbholDatum());
    }

    public static Lieferantenauftrag lAEntityToLA(LieferauftragEntity entity) {
        Set<Banfitem> banfitems = entity.getBanfItems() == null ? null
                : entity.getBanfItems().stream().map(e -> bIEntityToBI(e)).collect(Collectors.toSet());
        int importeurBestelungsid = entity.getImportBestellung() == null ? -1
                : entity.getImportBestellung().getBestellID();
        return new Lieferantenauftrag(entity.getLieferauftragsID(), entity.getOrderDate(), banfitems,
                entity.getSupplier().getAccountID(), entity.getAbholDatum(), importeurBestelungsid);
    }

    public static Banfitem bIEntityToBI(BanfItemEntity entity) {
        long lieferauftragsID = entity.getLieferauftragEntity() == null ? -1
                : entity.getLieferauftragEntity().getLieferauftragsID();
        return new Banfitem(entity.getItemID(), entity.getArticle().getArticleId(), entity.getAmount(),
                entity.getPrice(), lieferauftragsID,
                new ItemStatus(entity.getItemStatus().getItemStatus()));
    }

}
