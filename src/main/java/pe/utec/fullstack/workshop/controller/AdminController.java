package pe.utec.fullstack.workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.utec.fullstack.workshop.controller.request.CreateUserRequest;
import pe.utec.fullstack.workshop.domain.UserService;
import pe.utec.fullstack.workshop.domain.business.User;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapping mapper;

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(
            @RequestBody CreateUserRequest request
    ) {
        return this.userService.createUser(
                this.mapper.convert(request)
        );
    }
}
