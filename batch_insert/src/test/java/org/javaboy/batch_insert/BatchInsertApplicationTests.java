package org.javaboy.batch_insert;

import org.javaboy.batch_insert.mapper.UserMapper;
import org.javaboy.batch_insert.model.User;
import org.javaboy.batch_insert.service.IUserService;
import org.javaboy.batch_insert.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BatchInsertApplicationTests {

    @Autowired
    UserService userService;

    /**
     * 一条一条插入
     */
    @Test
    void addUserOneByOne() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            User u = new User();
            u.setAddress("广州：" + i);
            u.setUsername("张三：" + i);
            u.setPassword("123：" + i);
            users.add(u);
        }
        userService.addUserOneByOne(users);
    }


    /**
     * mp 批量插入
     */
    @Test
    void mpBatchInsert() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            User u = new User();
            u.setAddress("广州：" + i);
            u.setUsername("张三：" + i);
            u.setPassword("123：" + i);
            users.add(u);
        }
        long startTime = System.currentTimeMillis();
        userService.saveBatch(users);
        long endTime = System.currentTimeMillis();

    }


    /**
     * 合并成一条 SQL 插入
     */
    @Test
    void addByOneSQL() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            User u = new User();
            u.setAddress("广州：" + i);
            u.setUsername("张三：" + i);
            u.setPassword("123：" + i);
            users.add(u);
        }
        userService.addByOneSQL(users);
    }

}
