package com.msbills.repositories;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msbills.models.dto.UserDto;
import com.msbills.security.feign.FeignInterceptor;


@FeignClient(name= "users-service",url = "http://localhost:8087", configuration = FeignInterceptor.class)
public interface FeignUsersRepository {

    @RequestMapping(method = RequestMethod.GET,value = "/users/find/{username}")
    public List <UserDto> findByUsername(@PathVariable String username);
}
