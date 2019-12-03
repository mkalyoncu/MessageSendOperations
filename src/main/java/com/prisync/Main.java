package com.prisync;

import com.prisync.service.ProducerService;
import com.prisync.service.UserService;
import com.prisync.user.User;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class Main {

    public Main() throws IOException, TimeoutException {
        ProducerService producerService = new ProducerService();
        UserService userService = new UserService();
        List<User> users = userService.getUsers();
        producerService.publishMessages(users);
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        new Main();
    }
}
