package com.zorup.chat.repository;


import com.zorup.chat.domain.ChatLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatLogRepo extends JpaRepository<ChatLog, Long> {

    List<ChatLog> findByRoomIdOrderByLogNo(String roomId);
}
