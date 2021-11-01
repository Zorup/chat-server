package com.zorup.chat.controller;


import com.zorup.chat.domain.OpenRoom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.zorup.chat.service.OpenRoomService;
import com.zorup.chat.dto.OpenRoomDto;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OpenRoomController {

    private final OpenRoomService openRoomService;

    @GetMapping(value="/{userId}/rooms")
    public List<OpenRoomDto> getOpenRooms(@PathVariable("userId") Long userId){
        return openRoomService.getOpenRooms(userId);
    }

    @PostMapping(value="/room")
    public OpenRoomDto addOpenRoom(@RequestBody OpenRoomDto openRoomDto){
        return openRoomService.insertOpenRoom(openRoomDto);
    }

    @DeleteMapping(value="/{userId}/room/{roomId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteOpenRoom(@PathVariable("userId") Long userId, @PathVariable("roomId") String roomId){
        openRoomService.deleteOpenRoom(userId, roomId);
    }

    @PutMapping(value="/room")
    public void UpdateOpenTime(@RequestBody OpenRoomDto openRoomDto){
        openRoomService.updateOpenTime(openRoomDto);
    }
}
