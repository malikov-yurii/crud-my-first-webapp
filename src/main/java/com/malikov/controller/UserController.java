package com.malikov.controller;
import com.malikov.model.User;
import com.malikov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private UserService userService;

    @Autowired(required = true)
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String listUsers(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", this.userService.listUsers());

        return "users";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
        this.userService.removeUser(id);
        return "redirect:/users";
    }

    @RequestMapping("edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers());

        return "users";
    }

    @RequestMapping("userdata/{id}")
    public String userData(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        return "userdata";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser (@ModelAttribute("user") User user){
        if (user.getId() == 0){
            this.userService.addUser(user);
        } else {
            this.userService.updateUser(user);
        }
        return "redirect:/users";
    }

//   !! it is not finished method, because I dont know how correctly attach it to form???
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchUser(@ModelAttribute("user") User user) {
//        model.addAttribute("user", this.userService.getUserByName(user.getName()));
        return "userdata";
    }

}
