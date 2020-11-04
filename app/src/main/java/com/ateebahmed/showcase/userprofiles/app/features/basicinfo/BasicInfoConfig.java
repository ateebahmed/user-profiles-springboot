package com.ateebahmed.showcase.userprofiles.app.features.basicinfo;

import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.model.AddUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BasicInfoConfig {

    @Bean AddUser addUser() {
        return new AddUser();
    }
}
