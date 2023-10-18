package com.techelevator.message_board.dao;

import com.techelevator.message_board.model.Message;

import java.util.List;

public interface MessageDao {

    // Message data from controller/postman
    //    private String to;
    //    private String from;
    //    private String message;

    /*
     * TODO: Still working on filling this out...
     */
    Message addNewMessage(Message messageToAdd);

    List<Message> getAllMessagesByUsername(String username);

    List<Message> getSentMessagesByUsername(String toUsername);

    List<Message> getReceivedMessagesByUsername(String fromUsername);

}
