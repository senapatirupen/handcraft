package com.app.handcraft.service;

import com.app.handcraft.entity.*;
import com.app.handcraft.exception.DataNotFoundException;
import com.app.handcraft.repository.*;

import java.util.Collection;
import java.util.Optional;

public interface GenericEcomService {

    Collection<Address> findAllAddress();

    Optional<Address> findAddressById(Long id);

    Address saveStock(Address address);

    void deleteAddress(Long id);

    void deleteAddress(Address address);

    Boolean existsAddressById(Long id);

    Collection<Cart> findAllCart();

    Optional<Cart> findCartById(Long id);

    Cart saveCart(Cart cart);

    void deleteCart(Long id);

    void deleteCart(Cart cart);

    Boolean existsCartById(Long id);

    Collection<Delivery> findAllDelivery();

    Optional<Delivery> findDeliveryById(Long id);

    Delivery saveDelivery(Delivery delivery);

    void deleteDelivery(Long id);

    void deleteDelivery(Delivery delivery);

    Boolean existsDeliveryById(Long id);

    Collection<Feedback> findAllFeedback();

    Optional<Feedback> findFeedbackById(Long id);

    Feedback saveFeedback(Feedback feedback);

    void deleteFeedback(Long id);

    void deleteFeedback(Feedback feedback);

    Boolean existsFeedbackById(Long id);

    Collection<Invoice> findAllInvoice();

    Optional<Invoice> findInvoiceById(Long id);

    Invoice saveInvoice(Invoice invoice);

    void deleteInvoice(Long id);

    void deleteInvoice(Invoice invoice);

    Boolean existsInvoiceById(Long id);

    Collection<Order> findAllOrder();

    Optional<Order> findOrderById(Long id);

    Order saveOrder(Order order);

    void deleteOrder(Long id);

    void deleteOrder(Order order);

    Boolean existsOrderById(Long id);

    Collection<Payment> findAllPayment();

    Optional<Payment> findPaymentById(Long id);

    Payment savePayment(Payment payment);

    void deletePayment(Long id);

    void deletePayment(Payment payment);

    Boolean existsPaymentById(Long id);

    Collection<Person> findAllPerson();

    Optional<Person> findPersonById(Long id) throws DataNotFoundException;

    Person savePerson(Person person);

    Person updatePerson(Person person) throws DataNotFoundException;

    void deletePerson(Long id);

    void deletePerson(Person person);

    Boolean existsPersonById(Long id);

    Collection<Product> findAllProduct();

    Optional<Product> findProductById(Long id);

    Product saveProduct(Product product);

    void deleteProduct(Long id);

    void deleteProduct(Product product);

    Boolean existsProductById(Long id);

    Collection<ReturnProduct> findAllReturn();

    Optional<ReturnProduct> findReturnById(Long id);

    ReturnProduct saveReturn(ReturnProduct returns);

    void deleteReturn(Long id);

    void deleteReturn(ReturnProduct returns);

    Boolean existsReturnById(Long id);

    Collection<Shipping> findAllShipping();

    Optional<Shipping> findShippingById(Long id);

    Shipping saveShipping(Shipping shipping);

    void deleteShipping(Long id);

    void deleteShipping(Shipping shipping);

    Boolean existsShippingById(Long id);

    Collection<UserDetail> findAllUserDetail();

    Optional<UserDetail> findUserDetailById(Long id);

    UserDetail saveUserDetail(UserDetail userDetail);

    void deleteUserDetail(Long id);

    void deleteUserDetail(UserDetail userDetail);

    Boolean existsUserDetailById(Long id);

    Collection<WishList> findAllWishList();

    Optional<WishList> findWishListById(Long id);

    WishList saveWishList(WishList wishList);

    void deleteWishList(Long id);

    void deleteWishList(WishList wishList);

    Boolean existsWishListById(Long id);

    AddressRepository getAddressRepository();

    void setAddressRepository(AddressRepository addressRepository);

    CartRepository getCartRepository();

    void setCartRepository(CartRepository cartRepository);

    DeliveryRepository getDeliveryRepository();

    void setDeliveryRepository(DeliveryRepository deliveryRepository);

    FeedbackRepository getFeedbackRepository();

    void setFeedbackRepository(FeedbackRepository feedbackRepository);

    InvoiceRepository getInvoiceRepository();

    void setInvoiceRepository(InvoiceRepository invoiceRepository);

    OrderRepository getOrderRepository();

    void setOrderRepository(OrderRepository orderRepository);

    PaymentRepository getPaymentRepository();

    void setPaymentRepository(PaymentRepository paymentRepository);

    PersonRepository getPersonRepository();

    void setPersonRepository(PersonRepository personRepository);

    ProductRepository getProductRepository();

    void setProductRepository(ProductRepository productRepository);

    ReturnRepository getReturnRepository();

    void setReturnRepository(ReturnRepository returnRepository);

    ShippingRepository getShippingRepository();

    void setShippingRepository(ShippingRepository shippingRepository);

    UserDetailRepository getUserDetailRepository();

    void setUserDetailRepository(UserDetailRepository userDetailRepository);

    WishListRepository getWishListRepository();

    void setWishListRepository(WishListRepository wishListRepository);
}
