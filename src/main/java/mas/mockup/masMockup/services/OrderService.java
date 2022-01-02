package mas.mockup.masMockup.services;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import mas.mockup.masMockup.persistence.accounts.AccountInfoEntity;
import mas.mockup.masMockup.persistence.orders.OrderEntity;
import mas.mockup.masMockup.persistence.orders.OrderRepository;
import mas.mockup.masMockup.persistence.orders.OrderStatusEntity;
import mas.mockup.masMockup.persistence.orders.orderlineitem.OrderLineItemEntity;
import mas.mockup.masMockup.web.database.order.Order;
import mas.mockup.masMockup.web.database.order.OrderBody;
import mas.mockup.masMockup.web.database.order.OrderReklamtion;
import mas.mockup.masMockup.web.database.order.OrderStatus;
import mas.mockup.masMockup.web.database.order.orderlineitem.OrderLineItemReklamation;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private AccountInfoService accountInfoService;

    public OrderService(OrderRepository orderRepository, AccountInfoService accountInfoService) {

        this.orderRepository = orderRepository;
        this.accountInfoService = accountInfoService;
    }

    public Order createOrder(OrderBody orderBody) {
        OrderEntity orderEntity = bodyToEntity(orderBody, accountInfoService);
        orderEntity = orderRepository.save(orderEntity);
        /*
         * Set<OrderLineItem> orderLineItems = new HashSet<>();
         * for (OrderLineItemBodyOrder o : orderBody.getOrderLineItems()) {
         * OrderLineItemBody body = new OrderLineItemBody(o.getArticleID(),
         * o.getAmount(), o.getPrice(), orderEntity.getId(), o.getItemStatus());
         * orderLineItems.add(orderLineItemService.createOrderLineItem(body));
         * }
         * Order order = entityToOrder(orderEntity);
         * order.setOrderLineItems(orderLineItems);
         */
        return entityToOrder(orderEntity);
    }

    public Order findById(long orderID) {
        return entityToOrder(orderRepository.findById(orderID));
    }

    public OrderEntity findByIdToEntity(long orderID) {
        Optional<OrderEntity> optional = orderRepository.findById(orderID);
        return optional.isPresent() ? optional.get() : null;
    }

    public OrderReklamtion getReklamationsInfo(long orderID) {
        Optional<OrderEntity> optional = orderRepository.findById(orderID);
        OrderEntity orderEntity;
        if (optional.isEmpty()) {
            return null;
        }
        orderEntity = optional.get();
        Set<OrderLineItemEntity> orderLineItems = orderEntity.getOrderLineItems();
        Set<OrderLineItemReklamation> orderLineItemReklamations = new HashSet<>();
        for (OrderLineItemEntity entity : orderLineItems) {
            orderLineItemReklamations.add(new OrderLineItemReklamation(entity.getItemID(),
                    entity.getArticle().getProductdescription().getProduktname(), entity.getAmount(),
                    entity.getPrice()));
        }
        OrderReklamtion orderReklamtion = new OrderReklamtion(orderID, orderEntity.getOrderDate(),
                orderEntity.getRabatt(), orderEntity.getVersandkosten(),
                orderLineItemReklamations,
                orderEntity.getAccountInfoEntity().getAccountID(),
                new OrderStatus(orderEntity.getStatus().getOrderStatus()));

        return orderReklamtion;
    }

    public static Order entityToOrder(OrderEntity entity) {
        if (entity.getOrderLineItems() != null) {
            return new Order(entity.getId(), entity.getOrderDate(), entity.getRabatt(), entity.getVersandkosten(),
                    entity.getOrderLineItems().stream().map(e -> OrderLineItemService.entityToOrderLineItem(e))
                            .collect(Collectors.toSet()),
                    entity.getAccountInfoEntity().getAccountID(), new OrderStatus(entity.getStatus().getOrderStatus()));

        } else {
            return new Order(entity.getId(), entity.getOrderDate(), entity.getRabatt(), entity.getVersandkosten(), null,
                    entity.getAccountInfoEntity().getAccountID(),
                    new OrderStatus(entity.getStatus().getOrderStatus()));
        }
    }

    public static Order entityToOrder(Optional<OrderEntity> entity) {

        if (entity.isEmpty()) {
            return null;
        }

        return entityToOrder(entity.get());
    }

    public static OrderEntity bodyToEntity(OrderBody body, AccountInfoService accountInfoService) {
        AccountInfoEntity account = accountInfoService.findEntityByID(body.getAccountInfoID());
        long id = body.getOrderDate().getTime() + account.getAccountID();
        return new OrderEntity(id, body.getOrderDate(), body.getRabatt(), body.getVersandkosten(),
                new OrderStatusEntity(body.getStatus().getOrderStatus()), account);

    }

}
