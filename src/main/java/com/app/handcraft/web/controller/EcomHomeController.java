package com.app.handcraft.web.controller;

import com.app.handcraft.entity.*;
import com.app.handcraft.entity.inventory.AdminProduct;
import com.app.handcraft.service.InventoryService;
import com.app.handcraft.service.OrderManagementService;
import com.app.handcraft.service.UserInteractionService;
import com.app.handcraft.util.AddressFormatter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@Slf4j
@SessionAttributes("userDetail")
public class EcomHomeController {

    @Autowired
    UserInteractionService userInteractionService;

    @Autowired
    OrderManagementService orderManagementService;

    @Autowired
    InventoryService inventoryService;

    @ModelAttribute("userDetail")
    public UserDetail userDetail() {
        String username = printUser();
        if (StringUtils.isNotBlank(username)) {
            UserDetail userDetail = userInteractionService.getAccount(username);
            return userDetail;
        } else {
            return new UserDetail();
        }
    }

    @RequestMapping(value = "/")
    public String indexPage(Model model, @ModelAttribute UserDetail userDetail) {
        model.addAttribute("userDetail", userDetail);
        return "index";
    }

    private String printUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName(); //get logged in username
    }

//    @RequestMapping(value = "/login")
//    public String loginPage(Model model) {
//        model.addAttribute("userDetail", new UserDetail());
//        return "login";
//    }
//
//    @RequestMapping(value = "/login", method = POST)
//    public String processLogin(Model model, @ModelAttribute UserDetail userDetail) {
//        userDetail = userInteractionService.singIn(userDetail);
//        log.info("processLogin() >>>>> " + userDetail);
//        model.addAttribute("userDetail", userDetail);
//        return "index";
//    }

    @RequestMapping(value = "/signup")
    public String signUpPage(Model model) {
        model.addAttribute("userDetail", new UserDetail());
        return "signup";
    }

    @RequestMapping(value = "/signup", method = POST)
    public String processSignUp(Model model, @ModelAttribute UserDetail userDetail) {
        userDetail = userInteractionService.createUserDetail(userDetail);
        log.info("processSignUp() " + userDetail);
        model.addAttribute("userDetail", userDetail);
        return "index";
    }

    @RequestMapping(value = "/signOut")
    public String signOutPage(Model model) {
        model.addAttribute("userDetail", new UserDetail());
        return "index";
    }

    @RequestMapping(value = "/headerwithuser")
    public String userPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        return "headerwithuser";
    }

    @RequestMapping(value = "/profile")
    public String userProfilePage(Model model, @ModelAttribute UserDetail userDetail) {
        String username = printUser();
        log.info("userProfilePage() " + userDetail.getEmailId() + " : with username " + username);
        model.addAttribute("userDetail", userDetail);
        return "profile";
    }

    @RequestMapping(value = "/profileedit")
    public String userProfileEditPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userProfileEditPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        return "profileedit";
    }

    @RequestMapping(value = "/profileupdate", method = POST)
    public String userProfileUpdatePage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        userInteractionService.updateUserDetail(userDetail);
        model.addAttribute("userDetail", userDetail);
        return "profile";
    }

    @RequestMapping(value = "/profileaddress")
    public String userProfileAddressPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        Set<Address> addresses = userInteractionService.allAddresses(userDetail.getUsername());
        if (!CollectionUtils.isEmpty(addresses)) {
            model.addAttribute("addresses", addresses);
        } else {
            addresses.add(defaultAddress());
        }
        model.addAttribute("addresses", addresses);
        return "profileaddress";
    }

    private Address defaultAddress() {
        return Address.builder().addressLineOne("address line one")
                .addressLineTwo("address line two").landmark("near temple")
                .state("orissa").country("India").zipcode("752012")
                .type("Home").build();
    }

    @RequestMapping(value = "/profileaddressadd")
    public String userProfileAddressAddPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        model.addAttribute("address", new Address());
        return "profileaddressadd";
    }

    @RequestMapping(value = "/profileaddressadd", method = POST)
    public String processUserProfileAddressAddPage(Model model, @ModelAttribute UserDetail userDetail, Address address) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        userInteractionService.createAddress(userDetail.getUsername(), address);
        model.addAttribute("userDetail", userDetail);
        return "redirect:profileaddress";
    }

    @RequestMapping(value = "/profileaddressedit")
    public String userProfileAddressEditPage(Model model, @ModelAttribute UserDetail userDetail, @RequestParam String id) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        Address address = userInteractionService.findAddress(userDetail.getUsername(), id);
        model.addAttribute("userDetail", userDetail);
        model.addAttribute("address", address);
        return "profileaddressedit";
    }

    @RequestMapping(value = "/profileaddressedit", method = POST)
    public String userProfileAddressUpdatePage(Model model, @ModelAttribute UserDetail userDetail, Address address) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        userInteractionService.updateAddress(userDetail.getUsername(), address);
        model.addAttribute("address", address);
        return "redirect:profileaddress";
    }

    @RequestMapping(value = "/products")
    public String productsPage(Model model, @ModelAttribute UserDetail userDetail,
                               @RequestParam("page") Optional<Integer> page,
                               @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<AdminProduct> productsPage = inventoryService.findPaginated(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("productsPage", productsPage);
        int totalPages = productsPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        log.info("productsPage() " + userDetail.getEmailId());
//        orderManagementService.productSave();
        model.addAttribute("userDetail", userDetail);
        return "products";
    }

    @RequestMapping(value = "/productdetail")
    public String productDetailPage(Model model, @ModelAttribute UserDetail userDetail, @RequestParam(value = "name", required = false) String name) {
        log.info("productDetailPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        Product product = orderManagementService.getProductByName(name);
        model.addAttribute(product);
        return "productdetail";
    }

    @RequestMapping(value = "/addtocart")
    public String addToCartPage(Model model, @ModelAttribute UserDetail userDetail, Product product) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        orderManagementService.addProductToCartByNameForUserName(userDetail.getUsername(), product.getName());
        model.addAttribute("userDetail", userDetail);
        return "redirect:products";
    }

    @RequestMapping(value = "/cart")
    public String cartPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        Cart cart = orderManagementService.getCartByUserName(userDetail.getUsername());
        Collection<Product> products = null;
        if (!CollectionUtils.isEmpty(cart.getProducts())) {
            products = (List<Product>) cart.getProducts();
        } else {
            Order order = orderManagementService.getOnlyOneOrderHavingStatusNewByUserName(userDetail.getUsername());
            if (!Objects.isNull(order) && !CollectionUtils.isEmpty(order.getProducts())) {
                products = orderManagementService.getOnlyOneOrderHavingStatusNewByUserName(userDetail.getUsername()).getProducts();
            }
        }
        if (Objects.isNull(products))
            products = new ArrayList<>();
        model.addAttribute("products", products);
        return "cart";
    }

    @RequestMapping(value = "/placeorder")
    public String placeOrderPage(Model model, @ModelAttribute UserDetail userDetail, @RequestParam(value = "name", required = false) String name) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        Cart cart = orderManagementService.getCartByUserName(userDetail.getUsername());
        Order order = null;
        try {
            order = orderManagementService.createOrderByTransferProductFromCartToOrderByUserName(userDetail.getUsername(), "NEW");
        } catch (NoSuchElementException e) {
            log.info("Order Not Found");
        }
        Set<Address> addresses = userInteractionService.allAddresses(userDetail.getUsername());
        if (!CollectionUtils.isEmpty(addresses)) {
            model.addAttribute("addresses", addresses);
        } else {
            addresses.add(defaultAddress());
        }
        List<String> addresslist = new ArrayList<>();
        for (Address address : addresses) {
            addresslist.add(AddressFormatter.addressFormat(address));
        }
        if (Objects.isNull(order)) {
            order = Order.builder().products(new ArrayList<>()).build();
        }
        model.addAttribute("addresslist", addresslist);
        model.addAttribute("address", new Address());
        model.addAttribute("products", order.getProducts());
        return "order";
    }

    @RequestMapping(value = "/adddeliveryaddress")
    public String addDeliveryAddressPage(Model model, @ModelAttribute UserDetail userDetail, Address address) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        Order order = orderManagementService.addBillingAddressToOrder(userDetail.getUsername(), address);
        Collection<Product> products = order.getProducts();
        model.addAttribute("order", order);
        model.addAttribute("products", products);
        if (!Objects.isNull(order.getBillingAddress()))
            model.addAttribute("address", order.getBillingAddress());
        else
            model.addAttribute("address", defaultAddress());
        return "ordersummary";
    }

    @RequestMapping(value = "/removeproductfromcart")
    public String cartPage(Model model, @ModelAttribute UserDetail userDetail, @RequestParam(value = "name", required = false) String name) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        Cart cart = orderManagementService.getCartByUserName(userDetail.getUsername());
        orderManagementService.removeProductFromCartByNameForUserName(userDetail.getUsername(), name, cart.getCaId());
        Set<Product> products = (Set<Product>) cart.getProducts();
        model.addAttribute("products", products);
        return "redirect:cart";
    }

    @RequestMapping(value = "/orders")
    public String profileOrdersPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        Collection<Order> orders = orderManagementService.findOrdersByUserWithStatusSummary(userDetail.getUsername());
        model.addAttribute("orders", orders);
        return "profileorders";
    }

/*    @RequestMapping(value = "/ordersummary")
    public String orderSummaryPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        Collection<Order> orders = orderManagementService.getOrderByUserName(userDetail.getUsername());
        Order order = orders.stream().findAny().get();
        Collection<Product> products = order.getProducts();
        model.addAttribute("products", products);
        model.addAttribute("address", Address.builder().addressLineOne("new add").state("ok").type("nice").build());
        return "ordersummary";
    }*/

    @RequestMapping(value = "/buynow")
    public String buyNowPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
//        model.addAttribute("address", "address");
        return "checkout";
    }


}
