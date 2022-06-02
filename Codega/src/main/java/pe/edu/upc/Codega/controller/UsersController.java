package pe.edu.upc.Codega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.upc.Codega.business.crud.UsersService;
import pe.edu.upc.Codega.model.entity.Users;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping        //	/students
    public String listUsers(Model model) {

        try {
            List<Users> users = usersService.getAll();
            model.addAttribute("users", users);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "users/list-users";
    }
}
