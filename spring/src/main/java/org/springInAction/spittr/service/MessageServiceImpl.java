package org.springInAction.spittr.service;

import org.springInAction.spittr.model.Message;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 16.03.2016.
 */
@Service
public class MessageServiceImpl implements IMessageService {

    private static List<Message> messages=new ArrayList<Message>();
    static {
        messages.add(new Message(1L, "Hello"));
        messages.add(new Message(2L, "Goodbye"));
    }
    public List<Message> getAllMessages() {

        return messages;
    }
}
