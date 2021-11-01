package com.zorup.chat.service;

import com.zorup.chat.dto.OpenRoomDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.zorup.chat.repository.OpenRoomRepo;
import com.zorup.chat.domain.OpenRoom;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class OpenRoomService {

    private final OpenRoomRepo openRoomRepo;

    private List<OpenRoomDto> EntitiesToDtos(List<OpenRoom> openRooms){

        List<OpenRoomDto> result = new ArrayList<>();
        for(OpenRoom o : openRooms){
            OpenRoomDto dto = OpenRoomDto.builder(o).build();
            result.add(dto);
        }
        return result;
    }

    @Transactional(readOnly = true)
    public List<OpenRoomDto> getOpenRooms(Long userId){

        List<OpenRoom> openRooms = openRoomRepo.findByOpenRoomIDUserIdOrderByModifiedDateDesc(userId);

        List<OpenRoomDto> result = null;
        if(!openRooms.isEmpty()){
            result = EntitiesToDtos(openRooms);
        }

        return result;
    }

    public OpenRoomDto insertOpenRoom(OpenRoomDto openRoomDto){
        OpenRoom openRoom = OpenRoom.builder(openRoomDto).build();
        return OpenRoomDto.builder(openRoomRepo.save(openRoom)).build();
    }

    public void deleteOpenRoom(Long userId, String roomId){
        openRoomRepo.deleteByOpenRoomIDRoomIdAndOpenRoomIDUserId(roomId, userId);
    }

    public void updateOpenTime(OpenRoomDto openRoomDto){

        // 해당하는 방정보 가져와서
        Long userId = openRoomDto.getUserId();
        String roomId = openRoomDto.getRoomId();
        OpenRoom openRoom = openRoomRepo.findByOpenRoomIDUserIdAndOpenRoomIDRoomId(userId, roomId);

        // 수정시간 (최근 사용시간) 만 바꾸고 save
        String modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        openRoom.updateModifiedDate(modifiedDate);

        openRoomRepo.save(openRoom);
    }

}
