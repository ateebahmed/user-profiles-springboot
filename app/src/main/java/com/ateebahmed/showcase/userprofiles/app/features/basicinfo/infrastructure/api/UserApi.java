package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.api;

import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.request.UserDTO;
import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
final class UserApi {

    private final UserService service;

    UserApi(UserService service) {
        this.service = service;
    }

    @GetMapping("/ping") String ping() { return "alive"; }

    @PostMapping @ResponseStatus(HttpStatus.CREATED) UserDTO addUser(@RequestBody UserDTO user) {
        return service.createUser(user);
    }

    @GetMapping("/{id}") @ResponseStatus(HttpStatus.FOUND) UserDTO getUserBy(@PathVariable long id) {
        return service.getUserBy(id);
    }
}
