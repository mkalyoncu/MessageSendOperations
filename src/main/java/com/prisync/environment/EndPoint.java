package com.prisync.environment;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

public abstract class EndPoint {

    protected Channel channel;
    protected Connection connection;
    protected String rmqQueueName;
    protected String rmqExchangeName;
    protected String rmqExchangeType;
    protected String rmqRoutingKey;

    public EndPoint() throws IOException, TimeoutException {
        boolean durable = true;

        Properties properties = new PropertiesReader().getProperty();

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(properties.getProperty("rabbitmq_ip"));
        factory.setPassword(properties.getProperty("rabbitmq_password"));
        factory.setUsername(properties.getProperty("rabbitmq_username"));

        rmqQueueName = properties.getProperty("rabbitmq_queue_name");
        rmqExchangeName = properties.getProperty("rabbitmq_exchange_name");
        rmqExchangeType = properties.getProperty("rabbitmq_exchange_type");
        rmqRoutingKey = properties.getProperty("rabbitmq_routing_key");

        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.exchangeDeclare(rmqExchangeName, rmqExchangeType);
        channel.queueBind(rmqQueueName, rmqExchangeName, rmqRoutingKey);
        channel.queueDeclare(rmqQueueName, durable, false, false, null);
    }

    public void close() throws IOException, TimeoutException {
        if(connection.isOpen()){
            this.connection.close();
        }
        if(channel.isOpen()){
            this.channel.close();
        }
    }
}