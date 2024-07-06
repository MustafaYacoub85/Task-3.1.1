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
@RequestMapping("/catalog")
public class UserController {
    public final UserService userService;


    @GetMapping(value = "list") //список юзеров
    public String getUserList(Model model) {
        model.addAttribute("users", this.userService.getAllUser());
        return "catalog/list";
    }

    @GetMapping("creat") // возврашаем страницу с формой нового товара
    public String getNewUser() {
        return "catalog/new_list";
    }

    @PostMapping("creat") // обработка формы возврата товара
    public String creatUser(NewUserPayload payload) {
        User user = this.userService.creatUser(payload.age(), payload.email(), payload.firstName(), payload.lastName());
        return "redirect:/catalog/list";
    }


}
