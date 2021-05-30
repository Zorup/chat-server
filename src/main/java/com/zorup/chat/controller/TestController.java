package com.zorup.chat.controller;

import com.zorup.chat.domain.ChatLog;
import com.zorup.chat.domain.OpenRoom;
import com.zorup.chat.domain.OpenRoomID;
import com.zorup.chat.dto.ChatLogDto;
import com.zorup.chat.dto.OpenRoomDto;
import com.zorup.chat.repository.ChatLogRepo;
import com.zorup.chat.repository.OpenRoomRepo;
import com.zorup.chat.service.ChatLogService;
import com.zorup.chat.service.OpenRoomService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.util.List;

@Slf4j
@RestController
public class TestController {

    @Autowired
    OpenRoomRepo openRoomRepo;
    @Autowired
    ChatLogRepo chatLogRepo;
    @Autowired
    OpenRoomService openRoomService;
    @Autowired
    ChatLogService chatLogService;


    @GetMapping("/")
    public String test(){


//        OpenRoomDto openRoomDto = new OpenRoomDto(1L, "1-2", "1");
//        OpenRoom openRoom = OpenRoom.builder(openRoomDto).build();
//        openRoomRepo.save(openRoom);
//
//        OpenRoomDto openRoomDto2 = new OpenRoomDto(1L, "1-3", "3");
//        openRoom = OpenRoom.builder(openRoomDto2).build();
//        openRoomRepo.save(openRoom);
//
//
//        OpenRoomDto openRoomDto3 = new OpenRoomDto(1L, "1-4", "4");
//        openRoom = OpenRoom.builder(openRoomDto3).build();
//        openRoomRepo.save(openRoom);

//        OpenRoomDto openRoomDto = new OpenRoomDto(3L, "1-3", "1");
//        openRoomService.insertOpenRoom(openRoomDto);

//        OpenRoomDto openRoomDto = new OpenRoomDto(3L, "1-3", null, null, null);
//        openRoomService.updateOpenTime(openRoomDto);


//        List<OpenRoom> ol = openRoomRepo.findAll();
        List<OpenRoomDto> ol = openRoomService.getOpenRooms(3L);

        for(OpenRoomDto oo: ol){
            log.info("userid: " + oo.getUserId());
            log.info("roomid: " + oo.getRoomId());
            log.info("roomname: " + oo.getRoomName());
            log.info("cd: " + oo.getCreatedDate());
            log.info("ud: " + oo.getModifiedDate());
        }

//        ChatLogDto chatLogDto = new ChatLogDto(null, "1-3", 3L);
//        ChatLog chatLog = ChatLog.builder(chatLogDto).build();
//        chatLogRepo.save(chatLog);

//        ChatLogDto chatLogDto = new ChatLogDto(null, "3-4", 3L);
//        chatLogService.insertChatLog(chatLogDto);

//        List<ChatLog> cl = chatLogRepo.findAll();
        List<ChatLogDto> cl = chatLogService.getChatLogs("3-4");
        for(ChatLogDto cc: cl){
            log.info("logno: " + cc.getLogNo());
            log.info("roomid: " + cc.getRoomId());
            log.info("sender: " + cc.getSender());
            log.info("cd: " + cc.getCreatedDate());
            log.info("ud: " + cc.getModifiedDate());
        }


        return "work!";
    }

}


