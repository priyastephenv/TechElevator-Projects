package com.techelevator.message_board.dao;

import com.techelevator.message_board.model.Message;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcMessageDao implements MessageDao{

    JdbcTemplate template;

    public JdbcMessageDao(JdbcTemplate template){
        this.template = template;
    }

    @Override
    public Message addNewMessage(Message messageToAdd) {
        return null;
    }

    @Override
    public List<Message> getAllMessagesByUsername(String username) {
        return null;
    }

    @Override
    public List<Message> getSentMessagesByUsername(String toUsername) {
        return null;
    }

    @Override
    public List<Message> getReceivedMessagesByUsername(String fromUsername) {
        return null;
    }
}
