package com.works.days2.controllers;

import com.works.days2.props.User;
import com.works.days2.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    UserService service = new UserService();

    @GetMapping("/")
    public String home(Model model) {


        model.addAttribute("users", service.getLs());
        return "home"; //Return ifadesindeki home ile html ismi aynı olmalıdır.
    }

    @GetMapping("/userDelete/{uid}")
    public String userDelete(@PathVariable int uid, Model model){

        model.addAttribute("users", service.deleteUser(uid));
        return "redirect:/";
    }


}
