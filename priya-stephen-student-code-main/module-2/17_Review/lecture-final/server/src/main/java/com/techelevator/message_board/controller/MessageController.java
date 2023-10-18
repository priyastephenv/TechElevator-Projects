package com.techelevator.message_board.controller;

import com.techelevator.message_board.model.MessageDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    @RequestMapping(path = "/messages", method = RequestMethod.POST)
    public void addMessage(@RequestBody MessageDto newMessage){

    }

    @RequestMapping(path = "/messages", method = RequestMethod.GET)
    public void getMessage(@RequestParam(required = false) String from){
        // code
    }

}
