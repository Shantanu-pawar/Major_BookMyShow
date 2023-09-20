package Application.bookMyShow.Controller;

import Application.bookMyShow.DTOs.UserEntryDTO;
import Application.bookMyShow.Entity.UserEntity;
import Application.bookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public String addUser(@RequestBody UserEntryDTO userEntryDTO){
        userService.addUser(userEntryDTO);
        return "user Added successfully";
    }
}
