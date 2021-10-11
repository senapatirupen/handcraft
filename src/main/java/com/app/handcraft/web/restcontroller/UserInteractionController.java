package com.app.handcraft.web.restcontroller;

import com.app.handcraft.entity.UserDetail;
import com.app.handcraft.service.UserInteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class UserInteractionController {

//    @Autowired
//    UserInteractionService userInteractionService;
//
//    @PostMapping("/signUp")
//    public ResponseEntity<UserDetail> signUp(@RequestBody UserDetail userDetail){
//        UserDetail userDetail1 = userInteractionService.createUserDetail(userDetail);
//        if(Objects.nonNull(userDetail1.getUsId()))
//            return new ResponseEntity<>(userDetail1, HttpStatus.OK);
//        else
//            return new ResponseEntity<>(userDetail1, HttpStatus.UNPROCESSABLE_ENTITY);
//    }
//
//    @PostMapping("/signIn")
//    public ResponseEntity<UserDetail> signIn(@RequestBody UserDetail userDetail){
//        UserDetail userDetail1 = userInteractionService.singIn(userDetail);
//        return new ResponseEntity<>(userDetail1, HttpStatus.OK);
//    }
//
//    @PostMapping("/resetPassword")
//    public ResponseEntity<UserDetail> resetPassword(@RequestBody UserDetail userDetail){
//        UserDetail userDetail1 = userInteractionService.resetPassword(userDetail);
//        return new ResponseEntity<>(userDetail1, HttpStatus.OK);
//    }
}
