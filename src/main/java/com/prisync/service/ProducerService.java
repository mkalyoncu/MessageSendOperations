package com.prisync.service;

import com.google.gson.Gson;
import com.prisync.environment.EndPoint;
import com.prisync.user.User;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class ProducerService extends EndPoint {

    public ProducerService() throws IOException, TimeoutException {
        super();
    }
    public void publishMessages(List<User> users) throws IOException, TimeoutException {
        Gson gson = new Gson();
        String message;
        for (User user : users) {
            message = gson.toJson(user);
            channel.basicPublish(rmqExchangeName, rmqRoutingKey, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(message);
        }
        close();
    }

}
