package ps2.PS2.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString

public class LikeDTO {
    private int client;
    private int movie;
    private boolean liker;
}
