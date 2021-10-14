package com.app.handcraft.service;

import com.app.handcraft.entity.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface OrderManagementService {

    public Cart createCartByUserName(String username, Cart cart);
    public Cart getCartByUserName(String username);
    public Product createProduct(Product product);

    void productSave();

    public Product getProductByName(String name);

    Collection<Product> viewAllProducts();

    public Cart addProductToCartWithProductByUserName(String username, Product product);
    public Cart addProductToCartByNameForUserName(String username, String name);
    public Cart removeProductFromCartByNameForUserName(String username, String productName, Long cartId);
    public Collection<Order> createOrderByTransferProductFromCartToOrderByUserName(String username);
    public Order createOrderByProductNameByUserName(String username, String productName);
    public Collection<Order> getOrderByUserName(String username);
    public Order addBillingAddressToOrder(String username, Long orderId);

    Order addBillingAddressToOrder(String username, Address address);

    Collection<Order> findOrdersByUserWithStatusSummary(String username);

    Collection<Order> findOrdersByUserWithStatusClosed(String username);

    public Order addShippingAndDeliveryAndDeliveryAddressToOrder(String username, Long orderId, Long addressId,
                                                                 DeliveryAddress deliveryAddress);

    Order addDeliveryAddressToDeliveryForShippingOnOrder(String username, Long orderId, Long addressId,
                                                         DeliveryAddress deliveryAddress);

    Order addShippingAndDeliveryToOrder(String username, Long orderId);

    Order addShippingAddressToShippingForOrder(String username, Long orderId, Long shippingId,
                                               ShippingAddress shippingAddress);

    Order setDeliverAndShippingAsDoneForOrder(String username, Long orderId);

    Order setPaymentAsDoneForOrder(String username, Long orderId);

    Order updateOrderAsDone(String username, Long orderId);

    Collection<Order> viewAllOrders(String username);

    public Order addShippingAndReturnAndReturnAddressToOrder(String username, Long orderId, Long addressId,
                                                             ReturnAddress returnAddress);

    Optional<Set<Product>> findProductByNames(Set<String> names);

    Order createOrderByTransferProductFromCartToOrderByUserName(String username, String status);

    Order getOnlyOneOrderHavingStatusNewByUserName(String username);

    Address findAddressById(Long id);

    Collection<Order> removeProductFromOrderByIds(String username, Long orderId, List<Long> productIds);

    Collection<Order> viewProductsFromOrder(String username, Long orderId);

    public Order addPaymentToOrder(String username, Long orderId);

}
