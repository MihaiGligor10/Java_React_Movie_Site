package ps2.PS2.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class MovieDTO {
    private String numeM;
    private String gen;
    private String descriere;
    private String imagePath;
}
