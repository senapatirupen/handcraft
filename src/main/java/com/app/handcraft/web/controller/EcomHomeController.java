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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @RequestMapping(value = "/reset")
    public String resetPasswordPage(Model model) {
        model.addAttribute("userDetail", new UserDetail());
        return "reset";
    }

    @RequestMapping(value = "/reset", method = POST)
    public String processResetPasswordPage(Model model, @ModelAttribute UserDetail userDetail) {
        UserDetail userDetail1 = userInteractionService.resetPassword(userDetail);
        log.info("processResetPasswordPage() " + userDetail1);
        model.addAttribute("userDetail", userDetail1);
        return "index";
    }

    @RequestMapping(value = "/retrieve")
    public String retrieveMailPage(Model model) {
        model.addAttribute("userDetail", new UserDetail());
        return "retrieve";
    }

    @RequestMapping(value = "/retrieve", method = POST)
    public String processRetrieveMailPage(Model model, @ModelAttribute UserDetail userDetail) {
        userDetail = userInteractionService.findUserDetailByPhoneNumber(userDetail.getPhoneNumber());
        log.info("processResetPasswordPage() " + userDetail);
        model.addAttribute("userDetail", userDetail);
        return "retrieve";
    }

    /*@RequestMapping(value = "/signOut")
    public String signOutPage(Model model) {
        model.addAttribute("userDetail", new UserDetail());
        return "index";
    }

    @RequestMapping(value = "/headerwithuser")
    public String userPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        return "headerwithuser";
    }*/

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
        log.info("userProfileAddressPage() " + userDetail.getEmailId());
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
                .addressLineTwo("address line two").landmark("landmark")
                .state("state").country("country").zipcode("000000")
                .type("Home").build();
    }

    @RequestMapping(value = "/profileaddressadd")
    public String userProfileAddressAddPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userProfileAddressAddPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        model.addAttribute("address", new Address());
        return "profileaddressadd";
    }

    @RequestMapping(value = "/profileaddressadd", method = POST)
    public String userProfileAddressAddPage(Model model, @ModelAttribute UserDetail userDetail, Address address) {
        log.info("userProfileAddressAddPage() " + userDetail.getEmailId());
        userInteractionService.createAddress(userDetail.getUsername(), address);
        model.addAttribute("userDetail", userDetail);
        return "redirect:profileaddress";
    }

    @RequestMapping(value = "/profileaddressedit")
    public String userProfileAddressEditPage(Model model, @ModelAttribute UserDetail userDetail, @RequestParam String id) {
        log.info("userProfileAddressEditPage() " + userDetail.getEmailId());
        Address address = userInteractionService.findAddress(userDetail.getUsername(), id);
        model.addAttribute("userDetail", userDetail);
        model.addAttribute("address", address);
        return "profileaddressedit";
    }

    @RequestMapping(value = "/profileaddressedit", method = POST)
    public String userProfileAddressUpdatePage(Model model, @ModelAttribute UserDetail userDetail, Address address) {
        log.info("userProfileAddressUpdatePage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        userInteractionService.updateAddress(userDetail.getUsername(), address);
        model.addAttribute("address", address);
        return "redirect:profileaddress";
    }

    @RequestMapping(value = "/profileaddressremove")
    public String userProfileAddressRemovePage(Model model, @ModelAttribute UserDetail userDetail, @RequestParam String id) {
        log.info("userProfileAddressRemovePage() " + userDetail.getEmailId());
        userInteractionService.removeAddress(userDetail.getUsername(), Long.parseLong(id));
        model.addAttribute("userDetail", userDetail);
        Set<Address> addresses = userInteractionService.allAddresses(userDetail.getUsername());
        if (!CollectionUtils.isEmpty(addresses)) {
            model.addAttribute("addresses", addresses);
        } else {
            addresses.add(defaultAddress());
        }
        model.addAttribute("addresses", addresses);
        return "redirect:profileaddress";
    }

    @RequestMapping(value = "/profileclosedorders")
    public String profileClosedOrdersPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("profileClosedOrdersPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        Collection<Order> orders = orderManagementService.findOrdersByUserWithStatusClosed(userDetail.getUsername());
        model.addAttribute("orders", orders);
        return "profileclosedorders";
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

    @RequestMapping(value = "/cottonworkproductdetail")
    public String cottonWorkProductDetailPage(Model model, @ModelAttribute UserDetail userDetail, @RequestParam(value = "name", required = false) String name) {
        log.info("cottonWorkProductDetailPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
//        Product product = orderManagementService.getProductByName(name);
        Product product = new Product();
        product.setName("p1");
        product.setModel("p1");
        model.addAttribute(product);
        return "cottonworkproductdetail";
    }

    @RequestMapping(value = "/addtocart")
    public String addToCartPage(Model model, @ModelAttribute UserDetail userDetail, Product product, RedirectAttributes redirectAttributes) {
        log.info("addToCartPage() " + userDetail.getEmailId());
        orderManagementService.addProductToCartByNameForUserName(userDetail.getUsername(), product.getName());
        model.addAttribute("userDetail", userDetail);
        redirectAttributes.addFlashAttribute("message", "Item successfully added to cart");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        return "redirect:products";
    }

    @RequestMapping(value = "/cart")
    public String cartPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("cartPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        Cart cart = orderManagementService.getCartByUserName(userDetail.getUsername());
        Set<Product> products = null;
        if (!CollectionUtils.isEmpty(cart.getProductNames())) {
            products = orderManagementService.findProductByNames(cart.getProductNames()).get();
        } else {
            Order order = orderManagementService.getOnlyOneOrderHavingStatusNewByUserName(userDetail.getUsername());
            if (!Objects.isNull(order) && !CollectionUtils.isEmpty(order.getProducts())) {
                products = orderManagementService.getOnlyOneOrderHavingStatusNewByUserName(userDetail.getUsername()).getProducts();
            }
        }
        if (Objects.isNull(products))
            products = new HashSet<>();
        model.addAttribute("products", products);
        return "cart";
    }

    @RequestMapping(value = "/removeproductfromcart")
    public String cartPage(Model model, @ModelAttribute UserDetail userDetail, @RequestParam(value = "name", required = false) String name) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        Cart cart = orderManagementService.getCartByUserName(userDetail.getUsername());
        orderManagementService.removeProductFromCartByNameForUserName(userDetail.getUsername(), name, cart.getCaId());
        Set<Product> products = orderManagementService.findProductByNames(cart.getProductNames()).get();
        model.addAttribute("products", products);
        return "redirect:cart";
    }

    @RequestMapping(value = "/placeorder")
    public String placeOrderPage(Model model, @ModelAttribute UserDetail userDetail, @RequestParam(value = "name", required = false) String name) {
        log.info("placeOrderPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        Cart cart = orderManagementService.getCartByUserName(userDetail.getUsername());
        Order order = null;
        Set<Product> products = null;
        try {
            order = orderManagementService.createOrderByTransferProductFromCartToOrderByUserName(userDetail.getUsername(), "NEW");
            products = orderManagementService.findProductByNames(order.getProductNames()).get();
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
        if (Objects.isNull(order) || Objects.isNull(products)) {
            products = new HashSet<>();
        }
        model.addAttribute("addresslist", addresslist);
        model.addAttribute("address", new Address());
        model.addAttribute("products", products);
        return "order";
    }

    @RequestMapping(value = "/adddeliveryaddress")
    public String addDeliveryAddressPage(Model model, @ModelAttribute UserDetail userDetail, Address address) {
        log.info("addDeliveryAddressPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        Order order = orderManagementService.addBillingAddressToOrder(userDetail.getUsername(), address);
        Set<Product> products = orderManagementService.findProductByNames(order.getProductNames()).get();
        model.addAttribute("order", order);
        model.addAttribute("products", products);
        if (!Objects.isNull(order.getBillingAddress()))
            model.addAttribute("address", order.getBillingAddress());
        else
            model.addAttribute("address", defaultAddress());
        return "ordersummary";
    }

    @RequestMapping(value = "/orders")
    public String profileOrdersPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("profileOrdersPage() " + userDetail.getEmailId());
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
        log.info("buyNowPage() " + userDetail.getEmailId());
//        model.addAttribute("address", "address");
        return "checkout";
    }

    @RequestMapping(value = "/aboutus")
    public String aboutUsPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("aboutUsPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        return "aboutus";
    }

    @RequestMapping(value = "/contactus")
    public String contactUsPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("contactUsPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        return "contactus";
    }

    @RequestMapping(value = "/privacypolicy")
    public String privacyPolicyPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("privacyPolicyPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        return "privacypolicy";
    }

    @RequestMapping(value = "/termsofuse")
    public String termsOfUsePage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("termsOfUsePage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        return "termsofuse";
    }

    @RequestMapping(value = "/cottonworkproductsone")
    public String cottonWorkProductsOnePage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("cottonWorkProductsOnePage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        return "cottonworkproductsone";
    }

    @RequestMapping(value = "/cottonworkproductstwo")
    public String cottonWorkProductsTwoPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("cottonWorkProductsTwoPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        return "cottonworkproductstwo";
    }

    @RequestMapping(value = "/cottonworkproductsthree")
    public String cottonWorkProductsThreePage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("cottonWorkProductsThreePage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        return "cottonworkproductsthree";
    }

    @RequestMapping(value = "/cottonworkproductsfour")
    public String cottonWorkProductsFourPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("cottonWorkProductsFourPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        return "cottonworkproductsfour";
    }


}
