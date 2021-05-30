package com.zorup.chat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ChatControllerTest {

    private final SimpMessagingTemplate template;

    @Autowired
    public ChatControllerTest(SimpMessagingTemplate template) { this.template = template; }

    @MessageMapping("/send-test")
    public void linktest(String message){
        log.info("receive: " + message);
        template.convertAndSend("/topic/receive-test/" + 1, message);
    }

}
