package org.itstep.java.web.mavendiplomtest.controllers;

//import java.sql.PreparedStatement;
import java.util.List;
//import java.util.Map;
//import javax.servlet.http.HttpServletRequest;
import org.itstep.java.web.mavendiplomtest.model.User;
import org.itstep.java.web.mavendiplomtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/user")
@SessionAttributes({"current","thisUser"})
//@SessionAttributes("message")
public class UserController {
    @Autowired
    UserService userService;
//    @RequestMapping(value = "/start", method = RequestMethod.GET)
//    public String Start(ModelMap model) { 
//       
//        return "index";
//    }
    
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String user(
            UsernamePasswordAuthenticationToken currentUser,
            @RequestParam(value = "id",required = true, defaultValue = "1")
            Integer id,
            Model model) {
        
        User u = (User)currentUser.getPrincipal();
        User uId = userService.findByName(u.getName());
        model.addAttribute("thisUser", uId);
        
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("current", (User) currentUser.getPrincipal());
        
        return "user";
    }
       
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String userDelete(
            @PathVariable(value = "id")
            Integer id,
            ModelMap model) {
        userService.deleteUser(id);
        
        return "redirect:/user/show";
    }
    
    @RequestMapping(value = "/editUser/{id}", method = RequestMethod.GET)
    public String userEdit(
            @PathVariable(value = "id")
            Integer id,
            ModelMap model) {
        User u = userService.find(id);
        model.addAttribute("user", u);
        
        return "editUser";
    }
    
    @RequestMapping(value = "/userEditSave", method = RequestMethod.GET)
    public String userEditSave(
            @RequestParam(value = "id") Integer id,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "email") String email, 
            @RequestParam(value = "password") String password,
            @RequestParam(value = "isAdmin", required = false, defaultValue = "false") boolean isAdmin, 
            Model model) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("password", password);
        model.addAttribute("isAdmin", isAdmin);
         User u = new User(name, email, password, isAdmin);
         u.setId(id);
         userService.edit(u);
        //userService.save(u);
        return "redirect:/user/show";
    }
    
    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(Model model){
        return "addUser";
    }
    
    @RequestMapping(value = "/userSave", method = RequestMethod.GET)
    public String userSave(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "email") String email, 
            @RequestParam(value = "password") String password,
            @RequestParam(value = "isAdmin", required = false, defaultValue = "false") boolean isAdmin, 
            Model model){
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("password", password);       
        model.addAttribute("isAdmin", isAdmin);
        User u = new User(name, email, password, isAdmin);
        userService.save(u);
        
        return "redirect:/user/show";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        
        return "login";
    }
    
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationUser(Model model){
        return "registration";
    }
        
}
