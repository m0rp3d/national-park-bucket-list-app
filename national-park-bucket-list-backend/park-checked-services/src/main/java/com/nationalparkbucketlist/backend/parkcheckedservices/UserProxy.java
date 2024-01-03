package com.nationalparkbucketlist.backend.parkcheckedservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="user", url="localhost:8000")
@FeignClient(name="user", url="localhost:8000")
public interface UserProxy {

    // proxy is used to call another service from this service
    @GetMapping("/getuserid/{userName}/and/{password}")
    public Long getIdByUserNameAndPassword(@PathVariable String userName, @PathVariable String password);
}
