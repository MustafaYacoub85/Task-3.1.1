package com.example.Task_311.controller;

import com.example.Task_311.model.User;
import com.example.Task_311.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor

public class UsersController {
    public final UserService userService;





    @GetMapping
    public String getUser() {
        return "catalog/edit";
    }

    @GetMapping("edit/{userId}")
    public String getUserEditPage(@PathVariable("userId") Integer id, Model model) {
        var user = userService.findUser(id);
        User presentUser = null;
        if (user.isPresent()) {
            presentUser = user.get();
        } else {
            throw new NoSuchElementException("User is not found");
        }
        model.addAttribute("user", presentUser);

        return "/catalog/edit";

    }

    @PostMapping("update/{userId}")
    public String updateUser(User presentUser, @PathVariable Integer userId) {
        userService.updateUser(presentUser);
        return "redirect:/catalog/list";
    }



    @GetMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Integer id) {
        this.userService.deleteUser(id);
        return "redirect:/catalog/list";

    }

}
