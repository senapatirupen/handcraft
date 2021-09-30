package com.app.handcraft.web.restcontroller;

import com.app.handcraft.entity.*;
import com.app.handcraft.repository.ProductRepository;
import com.app.handcraft.repository.UserDetailRepository;
import com.app.handcraft.service.OrderManagementService;
import com.app.handcraft.service.UserInteractionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Slf4j
@RestController(value="/mgmt")
public class ProductMgmtEntityController {

    @Autowired
    UserInteractionService userInteractionService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserDetailRepository userDetailRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    OrderManagementService orderManagementService;

    @PostMapping(value = "/createuser")
    public ResponseEntity<UserDetail> createUser(@RequestBody UserDetail userDetail) {
        userDetail  = userInteractionService.createUserDetail(userDetail);
        displayObjectAsJson(userDetail);
        return new ResponseEntity<>(userDetail, HttpStatus.OK);
    }

    @GetMapping(value = "/getuser/{userName}")
    public ResponseEntity<UserDetail> getUserByUserName(@PathVariable String userName) {
        UserDetail userDetail = userInteractionService.findUserDetailByUserName(userName);
        displayObjectAsJson(userDetail);
        return new ResponseEntity<>(userDetail, HttpStatus.OK);
    }

    @GetMapping(value = "/getperson/{userName}")
    public ResponseEntity<Person> getPersonByUserName(@PathVariable String userName) {
        Person person = userInteractionService.findPersonByUserName(userName);
        displayObjectAsJson(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping(value = "/createaddress/{userName}")
    public ResponseEntity<Address> createAddress(@PathVariable String userName, @RequestBody Address address) {
        Address newAddress  = userInteractionService.createAddress(userName, address);
        displayObjectAsJson(newAddress);
        return new ResponseEntity<>(newAddress, HttpStatus.OK);
    }

    @PostMapping(value = "/updateaddress/{userName}")
    public ResponseEntity<Address> updateAddress(@PathVariable String userName, @RequestBody Address address) {
        Address newAddress  = userInteractionService.updateAddress(userName, address);
        displayObjectAsJson(newAddress);
        return new ResponseEntity<>(newAddress, HttpStatus.OK);
    }

    @GetMapping(value = "/getaddress/{userName}")
    public ResponseEntity<Collection<Address>> getAddresses(@PathVariable String userName) {
        Collection<Address> newAddress  = userInteractionService.findPersonAddressesByUserName(userName);
        displayObjectAsJson(newAddress);
        return new ResponseEntity<>(newAddress, HttpStatus.OK);
    }

    @GetMapping(value = "/removeaddress/{userName}")
    public ResponseEntity<Collection<Address>> removeAddresses(@PathVariable String userName, @RequestParam Long addressId) {
        userInteractionService.removeAddress(userName, addressId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/createcart/{userName}")
    public ResponseEntity<Cart> createCart(@PathVariable String userName, @RequestBody Cart cart) {
        cart  = orderManagementService.createCartByUserName(userName, cart);
        displayObjectAsJson(cart);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping(value = "/getcart/{userName}")
    public ResponseEntity<Cart> getCart(@PathVariable String userName) {
        Cart cart  = orderManagementService.getCartByUserName(userName);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PostMapping(value = "/createproduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        product  = orderManagementService.createProduct(product);
        displayObjectAsJson(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping(value = "/updateproduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        product  = orderManagementService.createProduct(product);
        displayObjectAsJson(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping(value = "/getproduct/{productName}")
    public ResponseEntity<Product> getProduct(@PathVariable String productName) {
        Product product  = orderManagementService.getProductByName(productName);
        displayObjectAsJson(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping(value = "/viewallproducts")
    public ResponseEntity<Collection<Product>> viewAllProducts() {
        Collection<Product> products  = orderManagementService.viewAllProducts();
        displayObjectAsJson(products);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping(value = "/addproducttocart/{userName}")
    public ResponseEntity<Cart> addProductToCart(@PathVariable String userName, @RequestBody Product product) {
        Cart cart  = orderManagementService.addProductToCartWithProductByUserName(userName, product);
        displayObjectAsJson(cart);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping(value = "/addproducttocartbyname/{userName}")
    public ResponseEntity<Cart> addProductToCartByName(@PathVariable String userName, @RequestParam String productName) {
        Cart cart  = orderManagementService.addProductToCartByNameForUserName(userName, productName);
        displayObjectAsJson(cart);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping(value = "/removeproductfromcartbyname/{userName}")
    public ResponseEntity<Cart> removeProductFromCart(@PathVariable String userName, @RequestParam String productName, @RequestParam Long cartId) {
        Cart cart  = orderManagementService.removeProductFromCartByNameForUserName(userName, productName, cartId);
        displayObjectAsJson(cart);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PostMapping(value = "/createorderbyproductname/{userName}")
    public ResponseEntity<Order> createProduct(@PathVariable String userName, @RequestParam String productName ) {
        Order order  = orderManagementService.createOrderByProductNameByUserName(userName, productName);
        displayObjectAsJson(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping(value = "/transferproductfromcarttoorder/{userName}")
    public ResponseEntity<Collection<Order>> transferProductFromCartToOrder(@PathVariable String userName) {
        Collection<Order> orders  = orderManagementService.createOrderByTransferProductFromCartToOrderByUserName(userName);
        displayObjectAsJson(orders);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping(value = "/removeproductfromorderbyids/{userName}")
    public ResponseEntity<Collection<Order>> removeproductfromorderbyids(@PathVariable String userName, @RequestParam Long orderId, @RequestParam List<Long> productIds) {
        Collection<Order> orders  = orderManagementService.removeProductFromOrderByIds(userName, orderId, productIds);
        displayObjectAsJson(orders);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping(value = "/viewproductsfromorder/{userName}")
    public ResponseEntity<Collection<Order>> viewproductsfromorder(@PathVariable String userName, @RequestParam Long orderId) {
        Collection<Order> orders  = orderManagementService.viewProductsFromOrder(userName, orderId);
        displayObjectAsJson(orders);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping(value = "/addbillingaddresstoorder/{userName}")
    public ResponseEntity<Order> addBillingAddressToOrder(@PathVariable String userName, @RequestParam Long orderId) {
        Order order  = orderManagementService.addBillingAddressToOrder(userName, orderId);
        displayObjectAsJson(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping(value = "/addpaymenttoorder/{userName}")
    public ResponseEntity<Order> addPaymentToOrder(@PathVariable String userName, @RequestParam Long orderId) {
        Order order  = orderManagementService.addPaymentToOrder(userName, orderId);
        displayObjectAsJson(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping(value = "/addshippinganddeliveryanddeliveryaddresstoorder/{userName}")
    public ResponseEntity<Order> addShippingAndDeliveryAndDeliveryAddressToOrder(@PathVariable String userName, @RequestParam Long orderId, @RequestParam(required = false) Long addressId, @RequestBody DeliveryAddress deliveryAddress) {
        Order order  = orderManagementService.addShippingAndDeliveryAndDeliveryAddressToOrder(userName, orderId, addressId, deliveryAddress);
        displayObjectAsJson(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping(value = "/adddeliveryaddresstodeliveryforshippingonorder/{userName}")
    public ResponseEntity<Order> addDeliveryAddressToDeliveryForShippingOnOrder(@PathVariable String userName, @RequestParam Long orderId, @RequestParam(required = false) Long addressId, @RequestBody DeliveryAddress deliveryAddress) {
        Order order  = orderManagementService.addDeliveryAddressToDeliveryForShippingOnOrder(userName, orderId, addressId, deliveryAddress);
        displayObjectAsJson(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping(value = "/addshippinganddeliverytoorder/{userName}")
    public ResponseEntity<Order> addShippingAndDeliveryToOrder(@PathVariable String userName, @RequestParam Long orderId) {
        Order order  = orderManagementService.addShippingAndDeliveryToOrder(userName, orderId);
        displayObjectAsJson(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping(value = "/addshippingaddresstoshippingfororder/{userName}")
    public ResponseEntity<Order> addShippingAddressToShippingForOrder(@PathVariable String userName, @RequestParam Long orderId, @RequestParam Long shippingId, @RequestBody ShippingAddress shippingAddress) {
        Order order  = orderManagementService.addShippingAddressToShippingForOrder(userName, orderId, shippingId, shippingAddress);
        displayObjectAsJson(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping(value = "/setdeliveryandshippingasdonefororder/{userName}")
    public ResponseEntity<Order> setDeliverAndShippingAsDoneForOrder(@PathVariable String userName, @RequestParam Long orderId) {
        Order order  = orderManagementService.setDeliverAndShippingAsDoneForOrder(userName, orderId);
        displayObjectAsJson(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping(value = "/setpaymentasdonefororder/{userName}")
    public ResponseEntity<Order> setPaymentAsDoneForOrder(@PathVariable String userName, @RequestParam Long orderId) {
        Order order  = orderManagementService.setPaymentAsDoneForOrder(userName, orderId);
        displayObjectAsJson(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping(value = "/updateorderasdone/{userName}")
    public ResponseEntity<Order> updateOrderAsDone(@PathVariable String userName, @RequestParam Long orderId) {
        Order order  = orderManagementService.updateOrderAsDone(userName, orderId);
        displayObjectAsJson(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping(value = "/viewallorders/{userName}")
    public ResponseEntity<Collection<Order>> viewAllOrders(@PathVariable String userName) {
        Collection<Order> orders  = orderManagementService.viewAllOrders(userName);
        displayObjectAsJson(orders);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping(value = "/addshippingandreturnandreturnaddresstoorder/{userName}")
    public ResponseEntity<Order> addShippingAndReturnAndReturnAddressToOrder(@PathVariable String userName, @RequestParam Long orderId, @RequestParam Long addressId, @RequestBody ReturnAddress returnAddress) {
        Order order  = orderManagementService.addShippingAndReturnAndReturnAddressToOrder(userName, orderId, addressId, returnAddress);
        displayObjectAsJson(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    private void displayObjectAsJson(Object obj) {
        try{
            log.info("object as json >>>>>> {}",objectMapper.writeValueAsString(obj));
        } catch (JsonProcessingException e){
            log.error(e.getMessage(), e);
        }
    }
}
