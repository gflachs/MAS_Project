package mas.mockup.masMockup.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import mas.mockup.masMockup.persistence.orders.OrderEntity;
import mas.mockup.masMockup.persistence.orders.OrderRepository;
import mas.mockup.masMockup.persistence.orders.OrderStatusEntity;
import mas.mockup.masMockup.web.database.product.order.Order;
import mas.mockup.masMockup.web.database.product.order.OrderBody;
import mas.mockup.masMockup.web.database.product.order.OrderStatus;



@Service
public class OrderService {

    
    private OrderRepository orderRepository;
    private AccountInfoService accountInfoService;
    


    public OrderService(OrderRepository orderRepository, AccountInfoService accountInfoService) {
       
        this.orderRepository = orderRepository;
        this.accountInfoService = accountInfoService;
    }

    public Order createOrder (OrderBody orderBody) {
        OrderEntity orderEntity = bodyToEntity(orderBody, accountInfoService);
        orderEntity = orderRepository.save(orderEntity);
        /*Set<OrderLineItem> orderLineItems = new HashSet<>();
        for (OrderLineItemBodyOrder o : orderBody.getOrderLineItems()) {
            OrderLineItemBody body = new OrderLineItemBody(o.getArticleID(), o.getAmount(), o.getPrice(), orderEntity.getId(), o.getItemStatus());
            orderLineItems.add(orderLineItemService.createOrderLineItem(body));
        }
        Order order = entityToOrder(orderEntity);
        order.setOrderLineItems(orderLineItems);*/
        return entityToOrder(orderEntity);
    }

    public Order findById(int orderID) {
        return entityToOrder(orderRepository.findById(orderID));
    }

    public OrderEntity findByIdToEntity(int orderID) {
        Optional<OrderEntity> optional = orderRepository.findById(orderID);
        return optional.isPresent()?optional.get():null;
    }

    public static Order entityToOrder (OrderEntity entity) {
        if (entity.getOrderLineItems() != null) {
            return new Order(entity.getId(),entity.getOrderLineItems().stream().map(e ->OrderLineItemService.entityToOrderLineItem(e) ).collect(Collectors.toSet()) , entity.getAccountInfoEntity().getAccountID(), new OrderStatus(entity.getStatus().getOrderStatus()));

        }else {
            return new Order(entity.getId(),null , entity.getAccountInfoEntity().getAccountID(), new OrderStatus(entity.getStatus().getOrderStatus()));
        }
    }

    public static Order entityToOrder (Optional<OrderEntity> entity) {
        
        if (entity.isEmpty()){
            return null;
        }

        return entityToOrder(entity.get());
    }

    public static OrderEntity bodyToEntity (OrderBody body, AccountInfoService accountInfoService) {
        return new OrderEntity(new OrderStatusEntity(body.getStatus().getOrderStatus()),accountInfoService.findEntityByID(body.getAccountInfoID()));
        
    }
    
}
