package com.zorup.chat.domain;

import com.zorup.chat.common.entity.TimeEntity;
import com.zorup.chat.dto.ChatLogDto;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data   // for equal, hashcode
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)  // Entity 필수
@AllArgsConstructor
@Entity
@Table(name = "chat_log")
@Builder(builderMethodName = "ChatLogBuilder")
public class ChatLog extends TimeEntity implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_no")
    private Long logNo;

    @Column(name = "room_id")
    private String roomId;

    @Column
    private Long sender;

    @Column
    private String message;

    public static ChatLogBuilder builder(ChatLogDto chatLogDto){  // ChatLog.builder(chatLogDto) 로 사용 가능
        return ChatLogBuilder()
                .logNo(chatLogDto.getLogNo())
                .roomId(chatLogDto.getRoomId())
                .sender(chatLogDto.getSender())
                .message(chatLogDto.getMessage());
    }

}
