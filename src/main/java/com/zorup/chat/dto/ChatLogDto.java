package com.zorup.chat.dto;

import com.zorup.chat.domain.ChatLog;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderMethodName = "ChatLogDtoBuilder")
public class ChatLogDto implements Serializable {

    private Long logNo;
    private String roomId;
    private Long sender;
    private String message;
    private String createdDate;
    private String modifiedDate;

    public static ChatLogDtoBuilder builder(ChatLog chatLog){
        return ChatLogDtoBuilder()
                .logNo(chatLog.getLogNo())
                .roomId(chatLog.getRoomId())
                .sender(chatLog.getSender())
                .message(chatLog.getMessage())
                .createdDate(chatLog.getCreatedDate())
                .modifiedDate(chatLog.getModifiedDate());
    }
}
