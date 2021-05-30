package com.zorup.chat.domain;

import com.zorup.chat.common.entity.TimeEntity;
import com.zorup.chat.dto.OpenRoomDto;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

// 유저 화면에 리스팅될 채팅방 리스트 테이블
@Data   // for equal, hashcode
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)  // Entity 필수
@AllArgsConstructor
@Entity
@Table(name = "open_room")
@Builder(builderMethodName = "OpenRoomBuilder")
public class OpenRoom extends TimeEntity implements Serializable {

    @EmbeddedId // 복합 private key
    private OpenRoomID openRoomID;

    @Column(name = "room_name")
    private String roomName;


    public void updateModifiedDate(String modifiedDate){
        this.setModifiedDate(modifiedDate);
    }


    public static OpenRoomBuilder builder(OpenRoomDto openRoomDto){

        OpenRoomID orID = new OpenRoomID();
        orID.setUserId(openRoomDto.getUserId());
        orID.setRoomId(openRoomDto.getRoomId());

        return OpenRoomBuilder()
                .openRoomID(orID)
                .roomName(openRoomDto.getRoomName());
    }

}
