package com.app.handcraft.web.controller;

import com.app.handcraft.entity.Address;
import com.app.handcraft.entity.Person;
import com.app.handcraft.entity.Product;
import com.app.handcraft.entity.UserDetail;
import com.app.handcraft.service.OrderManagementService;
import com.app.handcraft.service.UserInteractionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@Slf4j
@SessionAttributes("userDetail")
public class EcomHomeController {

    @Autowired
    UserInteractionService userInteractionService;

    @Autowired
    OrderManagementService orderManagementService;

    @RequestMapping(value = "/home")
    public String indexPage(@ModelAttribute UserDetail userDetail) {
        return "home";
    }

    @RequestMapping(value = "/hlogin")
    public String loginPage(Model model) {
        model.addAttribute("userDetail", new UserDetail());
        return "hlogin";
    }

    @RequestMapping(value = "/hlogin", method = POST)
    public String processLogin(Model model, @ModelAttribute UserDetail userDetail) {
        userDetail = userInteractionService.singIn(userDetail);
        log.info("processLogin() >>>>> " + userDetail);
        model.addAttribute("userDetail", userDetail);
        return "home";
    }

    @RequestMapping(value = "/hsignup")
    public String signUpPage(Model model) {
        model.addAttribute("userDetail", new UserDetail());
        return "hsignup";
    }

    @RequestMapping(value = "/hsignup", method = POST)
    public String processSignUp(Model model, @ModelAttribute UserDetail userDetail) {
        userDetail = userInteractionService.createUserDetail(userDetail);
        log.info("processSignUp() " + userDetail);
        model.addAttribute("userDetail", userDetail);
        return "home";
    }

    @RequestMapping(value = "/hsignout")
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
        log.info("userProfilePage() " + userDetail.getEmailId());
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
        model.addAttribute("userDetail", userDetail);
        return "profile";
    }

    @RequestMapping(value = "/profileaddress")
    public String userProfileAddressPage(Model model, @ModelAttribute UserDetail userDetail) {
        //rest template call to get the person out of userDetail
        //get list of address from person
        //add all the addresses to list of string after concatenation
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        Address address = new Address();
        address.setType("Home");
        address.setAdId(1L);
        address.setAddressLineOne("address line one");
        address.setAddressLineTwo("address line two");
        Address address1 = new Address();
        address1.setType("Office");
        address1.setAdId(2L);
        address1.setAddressLineOne("address line three");
        address1.setAddressLineTwo("address line four");
        ArrayList<Address> addresses = new ArrayList<>();
        addresses.add(address);
        addresses.add(address1);
        model.addAttribute("addresses", addresses);
        return "profileaddress";
    }

    @RequestMapping(value = "/profileaddressedit")
    public String userProfileAddressEditPage(Model model, @ModelAttribute UserDetail userDetail, @RequestParam String id) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        Person person = new Person();
        //get address from person by address id
        Address address = new Address();
        address.setAddressLineOne("address line Four");
        address.setAddressLineTwo("address line Five");
        model.addAttribute("userDetail", userDetail);
        model.addAttribute("address", address);
        return "profileaddressedit";
    }

    @RequestMapping(value = "/profileaddressedit", method = POST)
    public String userProfileAddressUpdatePage(Model model, @ModelAttribute UserDetail userDetail, Address address) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        Person person = new Person();
        //get address from person by address id
        log.info("userProfileAddressUpdatePage() "+ address.getAddressLineOne());
        model.addAttribute("userDetail", userDetail);
        //need to remove
        Address address2 = new Address();
        address2.setType("Home");
        address2.setAdId(1L);
        address2.setAddressLineOne(address.getAddressLineOne());
        address2.setAddressLineTwo(address.getAddressLineTwo());
        Address address1 = new Address();
        address1.setType("Office");
        address1.setAdId(2L);
        address1.setAddressLineOne("address line three");
        address1.setAddressLineTwo("address line four");
        ArrayList<Address> addresses = new ArrayList<>();
        addresses.add(address);
        addresses.add(address1);
        model.addAttribute("addresses", addresses);
        return "profileaddress";
    }

    @RequestMapping(value = "/products")
    public String productsPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("productsPage() " + userDetail.getEmailId());
        model.addAttribute("address", "address");
        return "products";
    }

    @RequestMapping(value = "/productdetail/{name}")
    public String productDetailPage(Model model, @ModelAttribute UserDetail userDetail, @PathVariable String name) {
        log.info("productDetailPage() " + userDetail.getEmailId());
        Product product = orderManagementService.getProductByName(name);
        model.addAttribute(product);
        return "productdetail";
    }

    @RequestMapping(value = "/addtocart")
    public String addToCartPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        model.addAttribute("address", "address");
        return "cart";
    }

    @RequestMapping(value = "/cart")
    public String cartPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        model.addAttribute("address", "address");
        return "cart";
    }

    @RequestMapping(value = "/buynow")
    public String buyNowPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
//        model.addAttribute("address", "address");
        return "checkout";
    }


}
