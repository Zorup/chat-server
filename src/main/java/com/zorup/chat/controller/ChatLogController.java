package com.zorup.chat.controller;

import com.zorup.chat.domain.ChatLog;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.zorup.chat.service.ChatLogService;
import com.zorup.chat.dto.ChatLogDto;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ChatLogController {

    private final ChatLogService chatLogService;

    @GetMapping(value="/{roomId}/chat-logs")
    public List<ChatLogDto> getChatLogs(@PathVariable("roomId") String roomId){
        return chatLogService.getChatLogs(roomId);
    }

    @PostMapping(value="/chat-log")
    public ChatLog addChatLog(@RequestBody ChatLogDto chatLogDto){
        return chatLogService.insertChatLog(chatLogDto);
    }

}
