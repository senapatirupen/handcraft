package com.app.handcraft.service;

import com.app.handcraft.entity.*;
import com.app.handcraft.exception.DataNotFoundException;
import com.app.handcraft.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class GenericEcomServiceImpl implements GenericEcomService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    FeedbackRepository feedbackRepository;
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ReturnRepository returnRepository;
    @Autowired
    ShippingRepository shippingRepository;
    @Autowired
    UserDetailRepository userDetailRepository;
    @Autowired
    WishListRepository wishListRepository;

    @Override
    public Collection<Address> findAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Optional<Address> findAddressById(Long id) {
        return addressRepository.findById(id);
    }

    @Override
    public Address saveStock(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public void deleteAddress(Address address) {
        addressRepository.delete(address);
    }

    @Override
    public Boolean existsAddressById(Long id) {
        return addressRepository.existsById(id);
    }

    @Override
    public Collection<Cart> findAllCart() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> findCartById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void deleteCart(Cart cart) {
        cartRepository.delete(cart);
    }

    @Override
    public Boolean existsCartById(Long id) {
        return cartRepository.existsById(id);
    }

    @Override
    public Collection<Delivery> findAllDelivery() {
        return deliveryRepository.findAll();
    }

    @Override
    public Optional<Delivery> findDeliveryById(Long id) {
        return deliveryRepository.findById(id);
    }

    @Override
    public Delivery saveDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @Override
    public void deleteDelivery(Long id) {
        deliveryRepository.deleteById(id);
    }

    @Override
    public void deleteDelivery(Delivery delivery) {
        deliveryRepository.delete(delivery);
    }

    @Override
    public Boolean existsDeliveryById(Long id) {
        return deliveryRepository.existsById(id);
    }

    @Override
    public Collection<Feedback> findAllFeedback() {
        return feedbackRepository.findAll();
    }

    @Override
    public Optional<Feedback> findFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    @Override
    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }

    @Override
    public void deleteFeedback(Feedback feedback) {
        feedbackRepository.delete(feedback);
    }

    @Override
    public Boolean existsFeedbackById(Long id) {
        return feedbackRepository.existsById(id);
    }

    @Override
    public Collection<Invoice> findAllInvoice() {
        return invoiceRepository.findAll();
    }

    @Override
    public Optional<Invoice> findInvoiceById(Long id) {
        return invoiceRepository.findById(id);
    }

    @Override
    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @Override
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }

    @Override
    public void deleteInvoice(Invoice invoice) {
        invoiceRepository.delete(invoice);
    }

    @Override
    public Boolean existsInvoiceById(Long id) {
        return invoiceRepository.existsById(id);
    }

    @Override
    public Collection<Order> findAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public Boolean existsOrderById(Long id) {
        return orderRepository.existsById(id);
    }

    @Override
    public Collection<Payment> findAllPayment() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> findPaymentById(Long id) {
        return paymentRepository.findById(id);
    }

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public void deletePayment(Payment payment) {
        paymentRepository.delete(payment);
    }

    @Override
    public Boolean existsPaymentById(Long id) {
        return paymentRepository.existsById(id);
    }

    @Override
    public Collection<Person> findAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> findPersonById(Long id) throws DataNotFoundException {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent())
            return person;
        else
            throw new DataNotFoundException("person not found for id: " + id, "404");

    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) throws DataNotFoundException {
        if (existsPersonById(person.getPeId())) {
            return personRepository.save(person);
        } else {
            throw new DataNotFoundException("person not found for id: " + person.getPeId(), "404");
        }
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void deletePerson(Person person) {
        personRepository.delete(person);
    }

    @Override
    public Boolean existsPersonById(Long id) {
        return personRepository.existsById(id);
    }

    @Override
    public Collection<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Boolean existsProductById(Long id) {
        return productRepository.existsById(id);
    }

    @Override
    public Collection<ReturnProduct> findAllReturn() {
        return returnRepository.findAll();
    }

    @Override
    public Optional<ReturnProduct> findReturnById(Long id) {
        return returnRepository.findById(id);
    }

    @Override
    public ReturnProduct saveReturn(ReturnProduct returns) {
        return returnRepository.save(returns);
    }

    @Override
    public void deleteReturn(Long id) {
        returnRepository.deleteById(id);
    }

    @Override
    public void deleteReturn(ReturnProduct returns) {
        returnRepository.delete(returns);
    }

    @Override
    public Boolean existsReturnById(Long id) {
        return returnRepository.existsById(id);
    }

    @Override
    public Collection<Shipping> findAllShipping() {
        return shippingRepository.findAll();
    }

    @Override
    public Optional<Shipping> findShippingById(Long id) {
        return shippingRepository.findById(id);
    }

    @Override
    public Shipping saveShipping(Shipping shipping) {
        return shippingRepository.save(shipping);
    }

    @Override
    public void deleteShipping(Long id) {
        shippingRepository.deleteById(id);
    }

    @Override
    public void deleteShipping(Shipping shipping) {
        shippingRepository.delete(shipping);
    }

    @Override
    public Boolean existsShippingById(Long id) {
        return shippingRepository.existsById(id);
    }

    @Override
    public Collection<UserDetail> findAllUserDetail() {
        return userDetailRepository.findAll();
    }

    @Override
    public Optional<UserDetail> findUserDetailById(Long id) {
        return userDetailRepository.findById(id);
    }

    @Override
    public UserDetail saveUserDetail(UserDetail userDetail) {
        return userDetailRepository.save(userDetail);
    }

    public UserDetail updateUserDetail(UserDetail userDetail) throws DataNotFoundException {
        if (existsUserDetailById(userDetail.getUsId())) {
            return saveUserDetail(userDetail);
        } else {
            throw new DataNotFoundException("person not found for id: " + userDetail.getUsId(), "404");
        }
    }

    @Override
    public void deleteUserDetail(Long id) {
        userDetailRepository.deleteById(id);
    }

    @Override
    public void deleteUserDetail(UserDetail userDetail) {
        userDetailRepository.delete(userDetail);
    }

    @Override
    public Boolean existsUserDetailById(Long id) {
        return userDetailRepository.existsById(id);
    }

    @Override
    public Collection<WishList> findAllWishList() {
        return wishListRepository.findAll();
    }

    @Override
    public Optional<WishList> findWishListById(Long id) {
        return wishListRepository.findById(id);
    }

    @Override
    public WishList saveWishList(WishList wishList) {
        return wishListRepository.save(wishList);
    }

    @Override
    public void deleteWishList(Long id) {
        wishListRepository.deleteById(id);
    }

    @Override
    public void deleteWishList(WishList wishList) {
        wishListRepository.delete(wishList);
    }

    @Override
    public Boolean existsWishListById(Long id) {
        return wishListRepository.existsById(id);
    }

    @Override
    public AddressRepository getAddressRepository() {
        return addressRepository;
    }

    @Override
    public void setAddressRepository(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public CartRepository getCartRepository() {
        return cartRepository;
    }

    @Override
    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public DeliveryRepository getDeliveryRepository() {
        return deliveryRepository;
    }

    @Override
    public void setDeliveryRepository(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public FeedbackRepository getFeedbackRepository() {
        return feedbackRepository;
    }

    @Override
    public void setFeedbackRepository(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public InvoiceRepository getInvoiceRepository() {
        return invoiceRepository;
    }

    @Override
    public void setInvoiceRepository(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    @Override
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public PaymentRepository getPaymentRepository() {
        return paymentRepository;
    }

    @Override
    public void setPaymentRepository(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public PersonRepository getPersonRepository() {
        return personRepository;
    }

    @Override
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public ProductRepository getProductRepository() {
        return productRepository;
    }

    @Override
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ReturnRepository getReturnRepository() {
        return returnRepository;
    }

    @Override
    public void setReturnRepository(ReturnRepository returnRepository) {
        this.returnRepository = returnRepository;
    }

    @Override
    public ShippingRepository getShippingRepository() {
        return shippingRepository;
    }

    @Override
    public void setShippingRepository(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    @Override
    public UserDetailRepository getUserDetailRepository() {
        return userDetailRepository;
    }

    @Override
    public void setUserDetailRepository(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    @Override
    public WishListRepository getWishListRepository() {
        return wishListRepository;
    }

    @Override
    public void setWishListRepository(WishListRepository wishListRepository) {
        this.wishListRepository = wishListRepository;
    }
}
