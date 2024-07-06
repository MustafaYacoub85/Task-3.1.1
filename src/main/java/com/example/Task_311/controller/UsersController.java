package com.example.Task_311.controller;

import com.example.Task_311.controller.payload.NewUserPayload;
import com.example.Task_311.controller.payload.UpdateUserPayload;
import com.example.Task_311.model.User;
import com.example.Task_311.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/catalog/{userId}")
public class UsersController {
    public final UserService userService;



@ModelAttribute("userId")
public User user(@PathVariable("userId") int userId){
    return this.userService.findUser(userId).orElseThrow();
}


    @GetMapping
    public String getUser(){
        return "catalog/edit";
    }

//    @GetMapping("edit")
//    public String getUserEditPage(){
//        return "catalog/list";
//
//    }

    @PostMapping("edit")
    public String updateUser(@ModelAttribute("userId") User user, UpdateUserPayload payload){
            this.userService.updateUser(user.getId(),payload.age(),payload.firstName(),payload.lastName(),payload.email());
         return  "redirect:catalog/list";
    }

    @PostMapping("delete")
    public String deleteProduct(@ModelAttribute("userId") User user){
    this.userService.deleteUser(user.getId());
    return "redirect:/catalog/list";


    }

//    @GetMapping("catalog/list/{userId}")
////    public String getUser(@PathVariable("userId") int userId, Model model) {
////        model.addAttribute("user", this.userService.findUser(userId).orElseThrow());
////        return "catalog/edit";
////    }
////
////    @GetMapping("{userId:\\d+}")
////    public String getUserEditPage(@PathVariable("userId") int userId, Model model) {
////        model.addAttribute("user", this.userService.findUser(userId).orElseThrow());
////        return "catalog/edit";
////    }
////
////
////    @PostMapping("edit/{UserId}")
////    public String updateUser(@ModelAttribute("user") User user, UpdateUserPayload payload) {
////        this.userService.updateUser(user.getId(), payload.age(), payload.firstName(),payload.lastName(),payload.email());
////        return "redirect:catalog/list";
////    }
}
