package com.litbo.hospital.security.controller;

import com.litbo.hospital.common.utils.poi.User;
import com.litbo.hospital.result.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @GetMapping("/testR")
    public R test(){
        User user = new User();
        user.setId(1);
        user.setAddr("henan");
        user.setAge(11);
        user.setUsername("zs");
        User user1 = new User();
        user1.setId(2);
        user1.setAddr("henan1");
        user1.setAge(10);
        user1.setUsername("zs");
        User user2 = new User();
        user2.setId(3);
        user2.setAddr("henan2");
        user2.setAge(11);
        user2.setUsername("zs");
        User user3 = new User();
        user3.setId(1);
        user3.setAddr("henan");
        user3.setAge(11);
        user3.setUsername("zs");

        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return R.ok(list);
    }

}
