package ps2.PS2.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class ReviewDTO {
    private int client;
    private int movie;
    private String review;
}
