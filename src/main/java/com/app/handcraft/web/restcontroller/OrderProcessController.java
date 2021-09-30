package com.app.handcraft.web.restcontroller;

import com.app.handcraft.service.GenericEcomService;
import com.app.handcraft.web.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class OrderProcessController {
    @Autowired
    GenericEcomService genericEcomService;

    @RequestMapping(value="/order/view/{id}", method= RequestMethod.GET)
    public ResponseEntity<Order> viewOrder(@PathVariable Long id){
       Optional<com.app.handcraft.entity.Order> orderOptional = genericEcomService.findOrderById(id);
       if(orderOptional.isPresent()){
           
       }
       Order orderModel = new Order();
       return new ResponseEntity<>(orderModel, HttpStatus.OK);
    }
}
