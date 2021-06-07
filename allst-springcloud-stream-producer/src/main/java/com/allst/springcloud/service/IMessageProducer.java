package com.allst.springcloud.service;

/**
 * @author June
 * @since 2021年04月
 */
public interface IMessageProducer {
    void sendMessage(String content);
}
