package com.zorup.chat.controller;

import com.zorup.chat.dto.ChatLogDto;
import com.zorup.chat.service.ChatLogService;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate template;
    private final ChatLogService chatLogService;


    /**
     *  "/topic/상대아이디" 를 구독중인 상대에게 메시지를 전송
     *  메시지 속에는 전송자의 아이디, 방이름이 들어있어야 함
     */
    @MessageMapping("/send/{otherId}")
    public void call(ChatLogDto chatLogDto, @DestinationVariable("otherId") Long otherId){
        //chatLogService.insertChatLog(chatLogDto);
        template.convertAndSend("/topic/" + otherId, chatLogDto);
    }


}
