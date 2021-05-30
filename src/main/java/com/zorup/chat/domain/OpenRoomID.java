package com.zorup.chat.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data   // for equal, hashcode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class OpenRoomID implements Serializable {
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "room_id")
    private String roomId;
}
