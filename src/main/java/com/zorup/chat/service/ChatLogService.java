package com.zorup.chat.service;

import com.zorup.chat.domain.ChatLog;
import com.zorup.chat.dto.ChatLogDto;
import com.zorup.chat.repository.ChatLogRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatLogService {

    private final ChatLogRepo chatLogRepo;

    public List<ChatLogDto> EntitiesToDtos(List<ChatLog> chatLogs){

        List<ChatLogDto> result = new ArrayList<>();
        for(ChatLog c : chatLogs){
            ChatLogDto dto = ChatLogDto.builder(c).build();
            result.add(dto);
        }
        return result;
    }

    public List<ChatLogDto> getChatLogs(String roomId){

        List<ChatLog> chatLogs = chatLogRepo.findByRoomIdOrderByLogNo(roomId);

        List<ChatLogDto> result = null;
        if(!chatLogs.isEmpty()){
            result = EntitiesToDtos(chatLogs);
        }

        return result;
    }

    public ChatLog insertChatLog(ChatLogDto chatLogDto){

        ChatLog chatLog = ChatLog.builder(chatLogDto).build();
        return chatLogRepo.save(chatLog);
    }
}
