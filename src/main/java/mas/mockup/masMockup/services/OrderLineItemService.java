package mas.mockup.masMockup.services;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import mas.mockup.masMockup.persistence.orders.OrderEntity;
import mas.mockup.masMockup.persistence.orders.orderlineitem.OrderLineItemEntity;
import mas.mockup.masMockup.persistence.orders.orderlineitem.OrderLineItemRepository;
import mas.mockup.masMockup.persistence.orders.orderlineitem.itemstatus.ItemStatusEntity;
import mas.mockup.masMockup.persistence.orders.orderlineitem.itemstatus.ItemStatusRepository;
import mas.mockup.masMockup.persistence.products.ArticleEntity;
import mas.mockup.masMockup.web.database.order.orderlineitem.OrderLineItem;
import mas.mockup.masMockup.web.database.order.orderlineitem.OrderLineItemBody;
import mas.mockup.masMockup.web.database.order.orderlineitem.itemstatus.ItemStatus;

@Service
public class OrderLineItemService {

    private OrderLineItemRepository orderLineItemRepository;
    private OrderService orderService;
    private ArticleService articleService;
    private ItemStatusRepository itemStatusRepository;

    public OrderLineItemService(OrderLineItemRepository orderLineItemRepository,
            ItemStatusRepository itemStatusRepository, OrderService orderService, ArticleService articleService) {
        this.orderLineItemRepository = orderLineItemRepository;
        this.itemStatusRepository = itemStatusRepository;
        this.orderService = orderService;
        this.articleService = articleService;
    }

    public OrderLineItem createOrderLineItem(OrderLineItemBody body) {
        OrderLineItemEntity entity = bodyToEntity(body, orderService, articleService);
        entity = orderLineItemRepository.save(entity);
        return entityToOrderLineItem(entity);
    }

    public OrderLineItem getOrderLineItemById(int id) {
        return entityToOrderLineItem(orderLineItemRepository.findById(id));

    }

    public OrderLineItem updateOrderLineItem(int id, OrderLineItemBody body) {
        Optional<OrderLineItemEntity> optionalOrderLineItemEntity = orderLineItemRepository.findById(id);
        if (optionalOrderLineItemEntity.isEmpty()) {
            return null;
        }
        OrderLineItemEntity entity = optionalOrderLineItemEntity.get();
        entity.setAmount(body.getAmount());
        entity.setItemStatus(new ItemStatusEntity(body.getItemStatus().getItemStatus()));
        entity.setPrice(body.getPrice());
        entity = orderLineItemRepository.save(entity);
        return entityToOrderLineItem(entity);

    }

    public Set<OrderLineItem> getOrderLineItemsByStatus(ItemStatus itemStatus) {

        Optional<ItemStatusEntity> optionalItemStatusEntity = itemStatusRepository.findById(itemStatus.getItemStatus());
        if (optionalItemStatusEntity.isEmpty()) {
            return null;
        }
        ItemStatusEntity entity = optionalItemStatusEntity.get();
        Set<OrderLineItemEntity> orderLineItemEntities = entity.getOrderLineItemEntity();
        return orderLineItemEntities.stream().map(orderLineItemEntitie -> entityToOrderLineItem(orderLineItemEntitie))
                .collect(Collectors.toSet());
    }

    public static OrderLineItem entityToOrderLineItem(OrderLineItemEntity entity) {
        return new OrderLineItem(entity.getItemID(), entity.getArticle().getArticleId(), entity.getAmount(),
                entity.getPrice(), entity.getOrderEntity().getId(),
                new ItemStatus(entity.getItemStatus().getItemStatus()));
    }

    public static OrderLineItem entityToOrderLineItem(Optional<OrderLineItemEntity> entity) {
        if (entity.isEmpty()) {
            return null;
        }

        return entityToOrderLineItem(entity.get());
    }

    public static OrderLineItemEntity bodyToEntity(OrderLineItemBody body, OrderService orderService,
            ArticleService articleService) {
        OrderEntity orderEntity = orderService.findByIdToEntity(body.getOrderID());
        ArticleEntity articleEntity = articleService.findByIdToEntity(body.getArticleID());
        return new OrderLineItemEntity(articleEntity, body.getAmount(), body.getPrice(), orderEntity,
                new ItemStatusEntity(body.getItemStatus().getItemStatus()));
    }

}
