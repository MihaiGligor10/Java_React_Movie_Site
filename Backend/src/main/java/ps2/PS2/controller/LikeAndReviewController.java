package ps2.PS2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ps2.PS2.dto.LikeDTO;
import ps2.PS2.dto.ReviewDTO;
import ps2.PS2.service.LikeRService;
import ps2.PS2.service.ReviewService;

@RestController
public class LikeAndReviewController {
    private final LikeRService likeRService;
    private final ReviewService reviewService;

    public LikeAndReviewController(LikeRService likeRService, ReviewService reviewService) {
        this.likeRService = likeRService;
        this.reviewService = reviewService;
    }

    @RequestMapping("/likeMovie")
    @PostMapping
    public ResponseEntity likeMovie(@RequestBody LikeDTO likeDTO){
        System.out.println(likeDTO + " pentru like/dislike");
        return ResponseEntity.status(HttpStatus.OK).body(likeRService.addLikeDislike(likeDTO));

    }

    @RequestMapping("/reviewMovie")
    @PostMapping
    public ResponseEntity reviewMovie(@RequestBody ReviewDTO DTO){
        System.out.println(DTO + " pentru review");
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.createReview(DTO));

    }

    @RequestMapping("/getAllReviewsForMovie")
    @PostMapping
    public ResponseEntity getAllReviewsForMovie(@RequestBody int m){
        System.out.println(m + " pentru review");
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.showAllReviews(m));

    }

}
