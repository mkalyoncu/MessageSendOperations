package com.prisync.service;

import com.prisync.Main;
import com.prisync.user.User;
import com.prisync.user.UserId;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    public List<String> readUsernamesFromFile() {
        List<String> usernames = new ArrayList<String>();
        try (InputStream inputStream = getClass().getResourceAsStream("/files/1000.usernames.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            usernames = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usernames;
    }

    public List<User> getUsers() {
        List<String> usernames = readUsernamesFromFile();
        List<User> users = new ArrayList<>();
        int userIdValue = 0;

        for (String username : usernames) {
            UserId user_id = new UserId();
            user_id.setHash(createHashId(username));
            user_id.setUser_id(++userIdValue);

            User user = new User();
            user.setName(username);
            user.setUser_id(user_id);

            users.add(user);
        }
        return users;
    }

    public String createHashId(String username) {
        String md5Hex = DigestUtils.md5Hex(username).toUpperCase();
        return md5Hex;
    }
}
