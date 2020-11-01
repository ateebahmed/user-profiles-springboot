package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.api;

import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.request.UserDTO;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public final class UserApi {

    private final UserService service;

    UserApi(UserService service) {
        this.service = service;
    }

    @PostMapping
    UserDTO addUser(@RequestBody UserDTO user) {
        return service.createUser(user);
    }
}
