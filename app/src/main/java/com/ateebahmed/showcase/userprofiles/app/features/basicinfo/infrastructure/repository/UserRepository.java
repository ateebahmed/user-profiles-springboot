package com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.repository;

import com.ateebahmed.showcase.userprofiles.app.features.basicinfo.infrastructure.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {}
