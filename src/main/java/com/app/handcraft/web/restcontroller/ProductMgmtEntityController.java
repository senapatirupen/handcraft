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

    @GetMapping(value = "/getuser/{username}")
    public ResponseEntity<UserDetail> getUserByUserName(@PathVariable String username) {
        UserDetail userDetail = userInteractionService.findUserDetailByUserName(username);
        displayObjectAsJson(userDetail);
        return new ResponseEntity<>(userDetail, HttpStatus.OK);
    }

    @GetMapping(value = "/getperson/{username}")
    public ResponseEntity<Person> getPersonByUserName(@PathVariable String username) {
        Person person = userInteractionService.findPersonByUserName(username);
        displayObjectAsJson(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping(value = "/createaddress/{username}")
    public ResponseEntity<Address> createAddress(@PathVariable String username, @RequestBody Address address) {
        Address newAddress  = userInteractionService.createAddress(username, address);
        displayObjectAsJson(newAddress);
        return new ResponseEntity<>(newAddress, HttpStatus.OK);
    }

    @PostMapping(value = "/updateaddress/{username}")
    public ResponseEntity<Address> updateAddress(@PathVariable String username, @RequestBody Address address) {
        Address newAddress  = userInteractionService.updateAddress(username, address);
        displayObjectAsJson(newAddress);
        return new ResponseEntity<>(newAddress, HttpStatus.OK);
    }

    @GetMapping(value = "/getaddress/{username}")
    public ResponseEntity<Collection<Address>> getAddresses(@PathVariable String username) {
        Collection<Address> newAddress  = userInteractionService.findPersonAddressesByUserName(username);
        displayObjectAsJson(newAddress);
        return new ResponseEntity<>(newAddress, HttpStatus.OK);
    }

    @GetMapping(value = "/removeaddress/{username}")
    public ResponseEntity<Collection<Address>> removeAddresses(@PathVariable String username, @RequestParam Long addressId) {
        userInteractionService.removeAddress(username, addressId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/createcart/{username}")
    public ResponseEntity<Cart> createCart(@PathVariable String username, @RequestBody Cart cart) {
        cart  = orderManagementService.createCartByUserName(username, cart);
        displayObjectAsJson(cart);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping(value = "/getcart/{username}")
    public ResponseEntity<Cart> getCart(@PathVariable String username) {
        Cart cart  = orderManagementService.getCartByUserName(username);
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

    @PostMapping(value = "/addproducttocart/{username}")
    public ResponseEntity<Cart> addProductToCart(@PathVariable String username, @RequestBody Product product) {
        Cart cart  = orderManagementService.addProductToCartWithProductByUserName(username, product);
        displayObjectAsJson(cart);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping(value = "/addproducttocartbyname/{username}")
    public ResponseEntity<Cart> addProductToCartByName(@PathVariable String username, @RequestParam String productName) {
        Cart cart  = orderManagementService.addProductToCartByNameForUserName(username, productName);
        displayObjectAsJson(cart);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping(value = "/removeproductfromcartbyname/{username}")
    public ResponseEntity<Cart> removeProductFromCart(@PathVariable String username, @RequestParam String productName, @RequestParam Long cartId) {
        Cart cart  = orderManagementService.removeProductFromCartByNameForUserName(username, productName, cartId);
        displayObjectAsJson(cart);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PostMapping(value = "/createorderbyproductname/{username}")
    public ResponseEntity<Order> createProduct(@PathVariable String username, @RequestParam String productName ) {
        Order order  = orderManagementService.createOrderByProductNameByUserName(username, productName);
        displayObjectAsJson(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping(value = "/transferproductfromcarttoorder/{username}")
    public ResponseEntity<Collection<Order>> transferProductFromCartToOrder(@PathVariable String username) {
        Collection<Order> orders  = orderManagementService.createOrderByTransferProductFromCartToOrderByUserName(username);
        displayObjectAsJson(orders);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping(value = "/removeproductfromorderbyids/{username}")
    public ResponseEntity<Collection<Order>> removeproductfromorderbyids(@PathVariable String username, @RequestParam Long orderId, @RequestParam List<Long> productIds) {
        Collection<Order> orders  = orderManagementService.removeProductFromOrderByIds(username, orderId, productIds);
        displayObjectAsJson(orders);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping(value = "/viewproductsfromorder/{username}")
    public ResponseEntity<Collection<Order>> viewproductsfromorder(@PathVariable String username, @RequestParam Long orderId) {
        Collection<Order> orders  = orderManagementService.viewProductsFromOrder(username, orderId);
        displayObjectAsJson(orders);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping(value = "/addbillingaddresstoorder/{username}")
    public ResponseEntity<Order> addBillingAddressToOrder(@PathVariable String username, @RequestParam Long orderId) {
        Order order  = orderManagementService.addBillingAddressToOrder(username, orderId);
        displayObjectAsJson(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping(value = "/addpaymenttoorder/{username}")
    public ResponseEntity<Order> addPaymentToOrder(@PathVariable String username, @RequestParam Long orderId) {
        Order order  = orderManagementService.addPaymentToOrder(username, orderId);
        displayObjectAsJson(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping(value = "/addshippinganddeliveryanddeliveryaddresstoorder/{username}")
    public ResponseEntity<Order> addShippingAndDeliveryAndDeliveryAddressToOrder(@PathVariable String username, @RequestParam Long orderId, @RequestParam(required = false) Long addressId, @RequestBody DeliveryAddress deliveryAddress) {
        Order order  = orderManagementService.addShippingAndDeliveryAndDeliveryAddressToOrder(username, orderId, addressId, deliveryAddress);
        displayObjectAsJson(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping(value = "/adddeliveryaddresstodeliveryforshippingonorder/{username}")
    public ResponseEntity<Order> addDeliveryAddressToDeliveryForShippingOnOrder(@PathVariable String username, @RequestParam Long orderId, @RequestParam(required = false) Long addressId, @RequestBody DeliveryAddress deliveryAddress) {
        Order order  = orderManagementService.addDeliveryAddressToDeliveryForShippingOnOrder(username, orderId, addressId, deliveryAddress);
        displayObjectAsJson(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping(value = "/addshippinganddeliverytoorder/{username}")
    public ResponseEntity<Order> addShippingAndDeliveryToOrder(@PathVariable String username, @RequestParam Long orderId) {
        Order order  = orderManagementService.addShippingAndDeliveryToOrder(username, orderId);
        displayObjectAsJson(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping(value = "/addshippingaddresstoshippingfororder/{username}")
    public ResponseEntity<Order> addShippingAddressToShippingForOrder(@PathVariable String username, @RequestParam Long orderId, @RequestParam Long shippingId, @RequestBody ShippingAddress shippingAddress) {
        Order order  = orderManagementService.addShippingAddressToShippingForOrder(username, orderId, shippingId, shippingAddress);
        displayObjectAsJson(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping(value = "/setdeliveryandshippingasdonefororder/{username}")
    public ResponseEntity<Order> setDeliverAndShippingAsDoneForOrder(@PathVariable String username, @RequestParam Long orderId) {
        Order order  = orderManagementService.setDeliverAndShippingAsDoneForOrder(username, orderId);
        displayObjectAsJson(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping(value = "/setpaymentasdonefororder/{username}")
    public ResponseEntity<Order> setPaymentAsDoneForOrder(@PathVariable String username, @RequestParam Long orderId) {
        Order order  = orderManagementService.setPaymentAsDoneForOrder(username, orderId);
        displayObjectAsJson(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping(value = "/updateorderasdone/{username}")
    public ResponseEntity<Order> updateOrderAsDone(@PathVariable String username, @RequestParam Long orderId) {
        Order order  = orderManagementService.updateOrderAsDone(username, orderId);
        displayObjectAsJson(order);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping(value = "/viewallorders/{username}")
    public ResponseEntity<Collection<Order>> viewAllOrders(@PathVariable String username) {
        Collection<Order> orders  = orderManagementService.viewAllOrders(username);
        displayObjectAsJson(orders);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PutMapping(value = "/addshippingandreturnandreturnaddresstoorder/{username}")
    public ResponseEntity<Order> addShippingAndReturnAndReturnAddressToOrder(@PathVariable String username, @RequestParam Long orderId, @RequestParam Long addressId, @RequestBody ReturnAddress returnAddress) {
        Order order  = orderManagementService.addShippingAndReturnAndReturnAddressToOrder(username, orderId, addressId, returnAddress);
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
