package com.app.handcraft.web.controller;

import com.app.handcraft.entity.Address;
import com.app.handcraft.entity.Product;
import com.app.handcraft.entity.UserDetail;
import com.app.handcraft.entity.inventory.AdminProduct;
import com.app.handcraft.service.InventoryService;
import com.app.handcraft.service.OrderManagementService;
import com.app.handcraft.service.UserInteractionService;
import com.app.handcraft.web.model.Search;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@Slf4j
@SessionAttributes("userDetail")
public class InventoryController {

    @Autowired
    UserInteractionService userInteractionService;

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

    private String printUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName(); //get logged in username
    }

    @RequestMapping(value = "/product")
    public String productPage(Model model, @ModelAttribute UserDetail userDetail, AdminProduct adminProduct) {
        model.addAttribute("userDetail", userDetail);
        model.addAttribute("search", new Search());
        model.addAttribute("adminProduct", getDefaultProduct(adminProduct));
        return "product";
    }

    private AdminProduct getDefaultProduct(AdminProduct adminProduct) {
        if (Objects.isNull(adminProduct) || StringUtils.isBlank(adminProduct.getName()))
            return AdminProduct.builder().name("sample product").model("sample model").productStatus("good").build();
        else
            return adminProduct;
    }

    @RequestMapping(value = "/productadd")
    public String productAddPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userProfileEditPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        model.addAttribute("adminProduct", new AdminProduct());
        return "productadd";
    }

    @RequestMapping(value = "/productadd", method = POST)
    public String processProductAddPage(Model model, @ModelAttribute UserDetail userDetail, AdminProduct adminProduct) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        inventoryService.save(adminProduct);
        model.addAttribute("userDetail", userDetail);
        model.addAttribute("adminProduct", adminProduct);
        return "redirect:product";
    }

    @RequestMapping(value = "/productedit")
    public String productEditPage(Model model, @ModelAttribute UserDetail userDetail, @RequestParam(value = "name", required = false) String name) {
        log.info("userProfileEditPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        AdminProduct adminProduct = inventoryService.findByName(name);
        model.addAttribute("adminProduct", adminProduct);
        return "productedit";
    }

    @RequestMapping(value = "/productedit", method = POST)
    public String processProductEditPage(ModelMap model, @ModelAttribute UserDetail userDetail, AdminProduct adminProduct) {
        log.info("userProfileUpdatePage() " + userDetail.getEmailId());
        inventoryService.save(adminProduct);
        model.addAttribute("userDetail", userDetail);
        model.addAttribute("search", new Search());
        model.addAttribute("adminProduct", adminProduct);
        return "productsearch";
    }

    @RequestMapping(value = "/productsearch")
    public String productSearchPage(Model model, @ModelAttribute UserDetail userDetail, AdminProduct adminProduct, Search search) {
        log.info("userProfileEditPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        model.addAttribute("search", new Search());
        if (Objects.isNull(search) || StringUtils.isBlank(search.getTxt()))
            model.addAttribute("search", new Search());
        else
            model.addAttribute("search", search);
        if (Objects.isNull(adminProduct) || StringUtils.isBlank(adminProduct.getName()))
            model.addAttribute("adminProduct", new AdminProduct());
        else
            model.addAttribute("adminProduct", adminProduct);
        return "productsearch";
    }

    @RequestMapping(value = "/productsearch", method = POST)
    public String processProductSearchPage(Model model, @ModelAttribute UserDetail userDetail, Search search) {
        log.info("userProfileEditPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        AdminProduct adminProduct = inventoryService.findByName(search.getTxt());
        model.addAttribute("adminProduct", adminProduct);
        return "productsearch";
    }

    @RequestMapping(value = "/productlist")
    public String productListPage(Model model, @ModelAttribute UserDetail userDetail) {
        log.info("userProfileEditPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        List<AdminProduct> adminProducts = inventoryService.findAll();
        model.addAttribute("adminProducts", adminProducts);
        return "productlist";
    }

    @RequestMapping(value = "/productremove")
    public String productRemovePage(Model model, @ModelAttribute UserDetail userDetail, @RequestParam(value = "id", required = false) String id) {
        log.info("userProfileEditPage() " + userDetail.getEmailId());
        model.addAttribute("userDetail", userDetail);
        inventoryService.remove(Long.parseLong(id));
        return "redirect:productlist";
    }
}
