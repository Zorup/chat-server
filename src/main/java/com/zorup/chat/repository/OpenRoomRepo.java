package com.zorup.chat.repository;

import com.zorup.chat.domain.OpenRoom;
import com.zorup.chat.domain.OpenRoomID;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpenRoomRepo extends JpaRepository<OpenRoom, OpenRoomID> {

    List<OpenRoom> findByOpenRoomIDUserIdOrderByModifiedDateDesc(Long userId);
    OpenRoom findByOpenRoomIDUserIdAndOpenRoomIDRoomId(Long userId, String roomId);
    void deleteByOpenRoomIDRoomIdAndOpenRoomIDUserId(String roomId, Long userId);

}
