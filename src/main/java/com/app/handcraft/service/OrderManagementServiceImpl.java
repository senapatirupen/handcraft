package com.app.handcraft.service;

import com.app.handcraft.entity.*;
import com.app.handcraft.repository.*;
import com.app.handcraft.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class OrderManagementServiceImpl implements OrderManagementService {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    BillingAddressRepository billingAddressRepository;
    @Autowired
    DeliveryAddressRepository deliveryAddressRepository;
    @Autowired
    ShippingAddressRepository shippingAddressRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    ReturnRepository returnRepository;
    @Autowired
    ShippingRepository shippingRepository;
    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public Cart createCartByUserName(String username, Cart cart) {
        Person person = personRepository.findByUsername(username);
        cart.setPeId(person.getPeId());
        Cart newCart = cartRepository.save(cart);
        person.setCart(newCart);
        personRepository.save(person);
        log.info("Existing Person >>>>> {}", person.toString());
        log.info("New Cart >>>>> {}", newCart.toString());
        return newCart;
    }

    @Override
    public Cart getCartByUserName(String username) {
        Cart cart = personRepository.findCartByUsername(username);
        log.info("New Cart >>>>> {}", cart.toString());
        return cart;
    }

    @Override
    public Product createProduct(Product product) {
        Product newProduct = productRepository.save(product);
        log.info("New Product >>>>> {}", newProduct.toString());
        return newProduct;
    }

    @Override
    public void productSave() {
        Product product = Product.builder()
                .name("ball")
                .model("balls")
                .productStatus("good")
                .isStockAvailable(true)
                .build();
        defaultAuditLog(product);
        productRepository.save(product);
    }

    private Product defaultAuditLog(Product product) {
        product.setCreatedBy("system");
        product.setCreatedDate(new Date());
        product.setLastModifiedBy("system");
        product.setLastModifiedDate(new Date());
        product.setIsActive(true);
        product.setStatus("good");
        return product;
    }

    private Cart defaultAuditLog(Cart obj) {
        obj.setCreatedBy("system");
        obj.setCreatedDate(new Date());
        obj.setLastModifiedBy("system");
        obj.setLastModifiedDate(new Date());
        obj.setIsActive(true);
        obj.setStatus("good");
        return obj;
    }

    @Override
    public Product getProductByName(String name) {
        Product product = productRepository.findByName(name);
        log.info("New Product >>>>> {}", product.toString());
        return product;
    }

    @Override
    public Collection<Product> viewAllProducts() {
        Collection<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Cart addProductToCartWithProductByUserName(String username, Product product) {
        Cart cart = personRepository.findCartByUsername(username);
        setProductForCart(cart, product);
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public Cart addProductToCartByNameForUserName(String username, String productName) {
        Person person = personRepository.findByUsername(username);
        Cart cart = person.getCart();
        if (Objects.isNull(cart)) {
            cart = Cart.builder().cartStatus("OPEN").peId(person.getPeId()).build();
            defaultAuditLog(cart);
            cartRepository.save(cart);
            person.setCart(cart);
            personRepository.save(person);
        }
        Product product = productRepository.findByName(productName);
        if (cart.getProductNames().size() == 0)
            cart.getProductNames().add(productName);
        Optional<String> name = cart.getProductNames().stream().filter(p -> p.equalsIgnoreCase(productName)).findAny();
        if (!name.isPresent()) {
            cart.getProductNames().add(productName);
        }
//        cart.getProductNames().add(productName);
//        setProductForCart(cart, product);
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public Cart removeProductFromCartByNameForUserName(String username, String productName, Long cartId) {
        Person person = personRepository.findByUsername(username);
        Cart cart = person.getCart();

//        Product product = productRepository.findByName(productName);
//        Product product = productRepository.findProductByCartId(cart.getCaId());
//        product.setCaId(null);
//        productRepository.save(product);
//        Product product = cart.getProducts().stream().filter(p -> productName.equalsIgnoreCase(p.getName())).findAny().get();
//        cart.getProducts().remove(product);
        cart.getProductNames().stream().filter(p -> p.equalsIgnoreCase(productName)).findAny();
        cart.getProductNames().remove(productName);
//        Cart cart = personRepository.findCartByUserName(username);
//        cartRepository.findProduct
//        setProductForCart(cart, product);
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public Collection<Order> createOrderByTransferProductFromCartToOrderByUserName(String username) {
        Person person = personRepository.findByUsername(username);
        Cart cart = person.getCart();
        if (!CollectionUtils.isEmpty(cart.getProducts())) {
            Order order = new Order();
            order.setCreatedBy(username);
            order.setCreatedDate(new Date());
            order.setLastModifiedBy(username);
            order.setLastModifiedDate(new Date());
            order.setIsActive(true);
            order.setStatus("OPEN");
            order.setPeId(person.getPeId());
            Order newOrder = orderRepository.save(order);
            Set<Product> products = cart.getProducts();
            products.stream().forEach(product -> {
                product.setCaId(null);
                product.setOdId(newOrder.getOdId());
                productRepository.save(product);
            });
            order.setProducts(products);
            cart.setProducts(null);
            cartRepository.save(cart);
            setOrderForPerson(person, order);
            personRepository.save(person);
            order.setOrderStatus("NEW");
            orderRepository.save(order);
            log.info("New Order >>>>> {}", newOrder.toString());
        }
        return person.getOrders();
    }

    @Override
    public Optional<Set<Product>> findProductByNames(Set<String> names) {
        return productRepository.findByNameIn(names);
    }

    @Override
    public Order createOrderByTransferProductFromCartToOrderByUserName(String username, String status) {
        Person person = personRepository.findByUsername(username);
        Cart cart = person.getCart();
        Optional<Order> existing = orderRepository.findOrderByPersonIdAndStatus(person.getPeId(), status);
        if (!CollectionUtils.isEmpty(cart.getProductNames()) && !existing.isPresent()) {
            Order order = new Order();
            order.setPeId(person.getPeId());
            order.setProductNames(new HashSet<>(cart.getProductNames()));
            order.setOrderStatus("NEW");
            order.setCreatedDate(new Date());
            order.setCreatedBy(username);
            order.setLastModifiedDate(new Date());
            order.setLastModifiedBy(username);
            order.setIsActive(true);
            order.setStatus("OPEN");
            orderRepository.save(order);
            cart.setProductNames(new HashSet<>());
            cartRepository.save(cart);
            person.addOrder(order);
            personRepository.save(person);
            log.info("New Order >>>>> {}", order.toString());
            return order;
        }
        return existing.get();
    }

    @Override
    public Order getOnlyOneOrderHavingStatusNewByUserName(String username) {
        Person person = personRepository.findByUsername(username);
        Optional<Order> order = orderRepository.findOrderByPersonIdAndStatus(person.getPeId(), "NEW");
        if (order.isPresent())
            return order.get();
        return null;
    }

    @Override
    public Address findAddressById(Long id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public Collection<Order> removeProductFromOrderByIds(String username, Long orderId, List<Long> productIds) {
        Person person = personRepository.findByUsername(username);
        Order existOrder = orderRepository.findOrderByPersonId(person.getPeId(), orderId);
        for (Long productId : productIds) {
            Product product = productRepository.findById(productId).get();
            existOrder.getProducts().remove(product);
        }
        orderRepository.save(existOrder);
        personRepository.save(person);
        log.info("New Order >>>>> {}", existOrder.toString());
        return person.getOrders();
    }

    @Override
    public Collection<Order> viewProductsFromOrder(String username, Long orderId) {
        Person person = personRepository.findByUsername(username);
        Order existOrder = orderRepository.findOrderByPersonId(person.getPeId(), orderId);
        return person.getOrders();
    }


    @Override
    public Order addPaymentToOrder(String username, Long orderId) {
        Person person = personRepository.findByUsername(username);
        Order order = orderRepository.findById(orderId).get();
        Payment payment = new Payment();
        Float totalAmount = 0f;
        List<Float> sellPrice = order.getProducts().stream().map(product -> product.getSellPrice()).collect(Collectors.toList());
        ListIterator<Float> listIterator = sellPrice.listIterator();
        while (listIterator.hasNext()) {
            totalAmount += listIterator.next();
        }
        payment.setPrice(totalAmount);
        payment.setOdId(orderId);
        paymentRepository.save(payment);
        order.setPayment(payment);
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order addBillingAddressToOrder(String username, Long orderId) {
        Person person = personRepository.findByUsername(username);
        Order order = orderRepository.findById(orderId).get();
        Address address = addressRepository.findByType(person.getPeId(), "BILLING");
        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setZipcode(address.getZipcode());
        billingAddress.setOdId(orderId);
        billingAddress.setCreatedBy(username);
        billingAddress.setCreatedDate(new Date());
        billingAddress.setLastModifiedBy(username);
        billingAddress.setLastModifiedDate(new Date());
        billingAddress.setIsActive(true);
        billingAddress.setStatus("OPEN");
        billingAddressRepository.save(billingAddress);
        order.setBillingAddress(billingAddress);
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order addBillingAddressToOrder(String username, Address address) {
        Person person = personRepository.findByUsername(username);
        Order order = getOnlyOneOrderHavingStatusNewByUserName(username);
        String status = address.getStatus();
        BillingAddress billingAddress = null;
        if (!StringUtils.isBlank(status) && status.length() != 11) {
            String adId = Arrays.asList(status.split(","))
                    .stream()
                    .filter(a -> a.contains("ID:"))
                    .findFirst()
                    .get()
                    .substring(3);
            Address existing = findAddressById(Long.parseLong(adId));
            billingAddress = BillingAddress.builder().addressLineOne(existing.getAddressLineOne())
                    .addressLineTwo(existing.getAddressLineTwo())
                    .zipcode(existing.getZipcode())
                    .landmark(existing.getLandmark())
                    .country(existing.getCountry())
                    .state(existing.getState())
                    .type("DELIVERY")
                    .odId(order.getOdId())
                    .build();
            billingAddress.setCreatedBy(username);
            billingAddress.setCreatedDate(new Date());
            billingAddress.setLastModifiedBy(username);
            billingAddress.setLastModifiedDate(new Date());
            billingAddress.setIsActive(true);
            billingAddress.setStatus("OPEN");
            billingAddressRepository.save(billingAddress);
            order.setBillingAddress(billingAddress);
        } else if (!StringUtils.isBlank(address.getAddressLineOne()) && !StringUtils.isBlank(address.getAddressLineTwo())) {
            billingAddress = BillingAddress.builder().addressLineOne(address.getAddressLineOne())
                    .addressLineTwo(address.getAddressLineTwo())
                    .zipcode(address.getZipcode())
                    .landmark(address.getLandmark())
                    .country(address.getCountry())
                    .state(address.getState())
                    .type("DELIVERY")
                    .odId(order.getOdId())
                    .build();
            billingAddress.setCreatedBy(username);
            billingAddress.setCreatedDate(new Date());
            billingAddress.setLastModifiedBy(username);
            billingAddress.setLastModifiedDate(new Date());
            billingAddress.setIsActive(true);
            billingAddress.setStatus("OPEN");
            billingAddressRepository.save(billingAddress);
            order.setBillingAddress(billingAddress);
        } else if (status.length() == 11) {
            Date pickupDate = DateUtil.stringToDate(status.substring(1));
            order.setExpectedDate(pickupDate);
        }
        order.setOrderStatus("SUMMARY");
        orderRepository.save(order);
        return order;
    }


    @Override
    public Collection<Order> findOrdersByUserWithStatusSummary(String username) {
        Person person = personRepository.findByUsername(username);
        Collection<Order> orders = orderRepository.findOrdersByPersonIdAndStatus(person.getPeId(), "SUMMARY");
        if (!CollectionUtils.isEmpty(orders))
            return orders;
        else
            return null;
    }

    @Override
    public Order addShippingAndDeliveryAndDeliveryAddressToOrder(String username, Long orderId, Long addressId,
                                                                 DeliveryAddress deliveryAddress) {
        Person person = personRepository.findByUsername(username);
        Order order = orderRepository.findOrderByPersonId(person.getPeId(), orderId);
        Shipping shipping = new Shipping();
        Delivery delivery = new Delivery();
        if (!Objects.isNull(addressId)) {
            Address address = addressRepository.findById(addressId).get();
            deliveryAddress.setAddressLineOne(address.getAddressLineOne());
            deliveryAddress.setAddressLineTwo(address.getAddressLineTwo());
            deliveryAddress.setCountry(address.getCountry());
            deliveryAddress.setState(address.getState());
            deliveryAddress.setLandmark(address.getLandmark());
            deliveryAddress.setZipcode(address.getZipcode());
            deliveryAddress.setType("DELIVERY");
        } else {
            delivery.setDeliveryAddress(deliveryAddress);
        }
        delivery.setDeliveryStatus("OPEN");
        deliveryRepository.save(delivery);
        deliveryAddress.setDeId(delivery.getDeId());
        deliveryAddressRepository.save(deliveryAddress);
        shipping.setDelivery(delivery);
        shipping.setOdId(orderId);
        List<String> productNames =
                order.getProducts().stream()
                        .map(Product::getName)
                        .collect(Collectors.toList());
        String products = productNames.stream().map(Object::toString).collect(Collectors.joining(","));
        shipping.setPrIds(products);
        shipping.setShippingStatus("OPEN");
        shippingRepository.save(shipping);
        delivery.setShId(shipping.getShId());
        setShippingForOrder(order, shipping);
        deliveryRepository.save(delivery);
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order addDeliveryAddressToDeliveryForShippingOnOrder(String username, Long orderId, Long addressId,
                                                                DeliveryAddress deliveryAddress) {
        Person person = personRepository.findByUsername(username);
        Order order = orderRepository.findOrderByPersonId(person.getPeId(), orderId);
        Shipping shipping = shippingRepository.findByOdId(orderId);
        Delivery delivery = deliveryRepository.findByShId(shipping.getShId());
        deliveryAddress.setDeId(delivery.getDeId());
        if (!Objects.isNull(addressId)) {
            Address address = addressRepository.findById(addressId).get();
            deliveryAddress.setAddressLineOne(address.getAddressLineOne());
            deliveryAddress.setAddressLineTwo(address.getAddressLineTwo());
            deliveryAddress.setCountry(address.getCountry());
            deliveryAddress.setState(address.getState());
            deliveryAddress.setLandmark(address.getLandmark());
            deliveryAddress.setZipcode(address.getZipcode());
            deliveryAddress.setType("DELIVERY");
        } else {
            delivery.setDeliveryAddress(deliveryAddress);
        }
        deliveryAddressRepository.save(deliveryAddress);
        return order;
    }

    @Override
    public Order addShippingAndDeliveryToOrder(String username, Long orderId) {
        Person person = personRepository.findByUsername(username);
        Order order = orderRepository.findOrderByPersonId(person.getPeId(), orderId);
        Shipping shipping = new Shipping();
        Delivery delivery = new Delivery();
        delivery.setDeliveryStatus("OPEN");
        deliveryRepository.save(delivery);
        shipping.setDelivery(delivery);
        shipping.setOdId(orderId);
        List<String> productNames =
                order.getProducts().stream()
                        .map(Product::getName)
                        .collect(Collectors.toList());
        String products = productNames.stream().map(Object::toString).collect(Collectors.joining(","));
        shipping.setPrIds(products);
        shipping.setShippingStatus("OPEN");
        shippingRepository.save(shipping);
        delivery.setShId(shipping.getShId());
        setShippingForOrder(order, shipping);
        deliveryRepository.save(delivery);
        orderRepository.save(order);
        return order;
    }

    @Override
    public Order addShippingAddressToShippingForOrder(String username, Long orderId, Long shippingId,
                                                      ShippingAddress shippingAddress) {
        Person person = personRepository.findByUsername(username);
        Order order = orderRepository.findOrderByPersonId(person.getPeId(), orderId);
        Shipping shipping = shippingRepository.findById(shippingId).get();
        shippingAddress.setShId(shippingId);
        ShippingAddress shippingAddress1 = shippingAddressRepository.save(shippingAddress);
        shipping.setShippingAddress(shippingAddress1);
        shipping.setStatus("START");
        shippingRepository.save(shipping);
        return order;
    }

    @Override
    public Order setDeliverAndShippingAsDoneForOrder(String username, Long orderId) {
        Person person = personRepository.findByUsername(username);
        Order order = orderRepository.findOrderByPersonId(person.getPeId(), orderId);
        Shipping shipping = shippingRepository.findByOdId(orderId);
        shipping.setStatus("DONE");
        shippingRepository.save(shipping);
        Delivery delivery = deliveryRepository.findByShId(shipping.getShId());
        delivery.setDeliveryStatus("DONE");
        deliveryRepository.save(delivery);
        return order;
    }

    @Override
    public Order setPaymentAsDoneForOrder(String username, Long orderId) {
        Person person = personRepository.findByUsername(username);
        Order order = orderRepository.findOrderByPersonId(person.getPeId(), orderId);
        Payment payment = paymentRepository.findByOdId(orderId);
        payment.setStatus("DONE");
        paymentRepository.save(payment);
        return order;
    }

    @Override
    public Order updateOrderAsDone(String username, Long orderId) {
        Person person = personRepository.findByUsername(username);
        Order order = orderRepository.findOrderByPersonId(person.getPeId(), orderId);
        order.setOrderStatus("DONE");
        order.setStatus("INACTIVE");
        orderRepository.save(order);
        return order;
    }

    @Override
    public Collection<Order> viewAllOrders(String username) {
        Person person = personRepository.findByUsername(username);
        return person.getOrders();
    }

    @Override
    public Order addShippingAndReturnAndReturnAddressToOrder(String username, Long orderId, Long addressId,
                                                             ReturnAddress returnAddress) {
        Person person = personRepository.findByUsername(username);
        Order order = orderRepository.findOrderByPersonId(person.getPeId(), orderId);
        if (null != addressId) {
            Address address = addressRepository.findById(addressId).get();
            returnAddress.setZipcode(address.getZipcode());
            returnAddress.setType("PICKUP");
        }
        Shipping shipping = new Shipping();
        ReturnProduct aReturnProduct = new ReturnProduct();
        aReturnProduct.setReturnAddress(returnAddress);
        aReturnProduct.setReturnStatus("OPEN");
        returnRepository.save(aReturnProduct);
        shipping.setAreturn(aReturnProduct);
        shipping.setOdId(orderId);
        shipping.setShippingStatus("OPEN");
        shippingRepository.save(shipping);
        aReturnProduct.setShId(shipping.getShId());
        setShippingForOrder(order, shipping);
        returnRepository.save(aReturnProduct);
        orderRepository.save(order);
        return order;
    }

    //    @Override
    public Order addProductToOrderFromUserNameByProductName(String username, String productName) {
//        Order newOrder = orderRepository.save(order);
//        log.info("New Order >>>>> {}", newOrder.toString());
        return null;
    }


    @Override
    public Order createOrderByProductNameByUserName(String username, String productName) {
        Person person = personRepository.findByUsername(username);
        Product product = productRepository.findByName(productName);
        Order order = new Order();
        order.setPeId(person.getPeId());
        setProductForOrder(order, product);
        Order newOrder = orderRepository.save(order);
        setOrderForPerson(person, newOrder);
        personRepository.save(person);
        log.info("New Order >>>>> {}", newOrder.toString());
        return newOrder;
    }

    @Override
    public Collection<Order> getOrderByUserName(String username) {
        Person person = personRepository.findByUsername(username);
        return person.getOrders();
    }

    private Order setProductForOrder(Order order, Product product) {
        if (!CollectionUtils.isEmpty(order.getProducts())) {
            order.getProducts().add(product);
        } else {
            Set<Product> productSet = new HashSet<Product>();
            productSet.add(product);
            order.setProducts(productSet);
        }
        return order;
    }

    private Person setOrderForPerson(Person person, Order order) {
        if (!CollectionUtils.isEmpty(person.getOrders())) {
            person.getOrders().add(order);
        } else {
            Set<Order> orderSet = new HashSet<Order>();
            orderSet.add(order);
            person.setOrders(orderSet);
        }
        return person;
    }

    private Person setProductForPerson(Person person, Product product) {
        if (!CollectionUtils.isEmpty(person.getProducts())) {
            person.getProducts().add(product);
        } else {
            Set<Product> productSet = new HashSet<Product>();
            productSet.add(product);
            person.setProducts(productSet);
        }
        return person;
    }

    private Cart setProductForCart(Cart cart, Product product) {
        if (!CollectionUtils.isEmpty(cart.getProducts())) {
            cart.getProducts().add(product);
        } else {
            Set<Product> productSet = new HashSet<Product>();
            productSet.add(product);
            cart.setProducts(productSet);
        }
        return cart;
    }

    private Order setShippingForOrder(Order order, Shipping shipping) {
        if (!CollectionUtils.isEmpty(order.getShipping())) {
            order.getShipping().add(shipping);
        } else {
            Set<Shipping> shippingSet = new HashSet<Shipping>();
            shippingSet.add(shipping);
            order.setShipping(shippingSet);
        }
        return order;
    }

}
