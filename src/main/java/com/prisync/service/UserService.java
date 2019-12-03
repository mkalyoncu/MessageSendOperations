package com.prisync.service;

import com.prisync.user.User;
import com.prisync.user.UserId;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public List<String> readUsernamesFromFile() {
        List<String> usernames = new ArrayList<String>();

        String filePath = "./src/main/resources/files/1000.usernames.txt";
        File file = new File(filePath);
        Path path = file.toPath();

        try {
            usernames = Files.readAllLines(path);
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
