package com.malikov.controller;
import com.malikov.model.User;
import com.malikov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value="/user-get-name-form")
    public ModelAndView getUserNameForm() {
        return new ModelAndView("user-name-form", "user-entity", new User());
    }

    @RequestMapping(value="/process-user")
    public ModelAndView processPerson(@ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView();
        User user1 = this.userService.getUserByName(user.getName());
        modelAndView.setViewName("user-result-page");
        modelAndView.addObject("user1", user1);
        return modelAndView;
    }
}
