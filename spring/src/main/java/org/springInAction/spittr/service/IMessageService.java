package org.springInAction.spittr.service;

import org.springInAction.spittr.model.Message;

import java.util.List;

/**
 * Created by alex on 16.03.2016.
 */
public interface IMessageService {

    public List<Message> getAllMessages();
}
