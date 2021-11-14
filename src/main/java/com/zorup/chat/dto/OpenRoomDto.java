package com.zorup.chat.dto;

import lombok.*;
import com.zorup.chat.domain.OpenRoom;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "OpenRoomDtoBuilder")
public class OpenRoomDto {

    private Long userId;
    private String roomId;
    private String roomName;
    private String createdDate;
    private String modifiedDate;
    private String senderName;
    public static OpenRoomDtoBuilder builder(OpenRoom openRoom){

        return OpenRoomDtoBuilder()
                .userId(openRoom.getOpenRoomID().getUserId())
                .roomId(openRoom.getOpenRoomID().getRoomId())
                .roomName(openRoom.getRoomName())
                .createdDate(openRoom.getCreatedDate())
                .modifiedDate(openRoom.getModifiedDate());
    }

}
