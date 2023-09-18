package ps2.PS2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ps2.PS2.dto.LikeDTO;
import ps2.PS2.model.LikeR;
import ps2.PS2.repository.LikeRRepository;
import ps2.PS2.service.LikeRService;

@Service
public class LikeRRServiceImpl implements LikeRService {

    private final LikeRRepository likeRRepository;

    @Autowired
    public LikeRRServiceImpl(LikeRRepository likeRRepository) {
        this.likeRRepository = likeRRepository;
    }

    @Override
    public LikeR addLikeDislike(LikeDTO likeR) {
        LikeR l = new LikeR(likeR.getClient(),likeR.getMovie(),likeR.isLiker());
        return likeRRepository.save(l);
    }



}
