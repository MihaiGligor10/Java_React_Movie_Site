package ps2.PS2.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ps2.PS2.dto.LikeDTO;
import ps2.PS2.model.LikeR;

@Component
public interface LikeRService {
    LikeR addLikeDislike(LikeDTO likeR);
}
