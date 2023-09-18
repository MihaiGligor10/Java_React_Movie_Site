package ps2.PS2.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ps2.PS2.dto.ReviewDTO;
import ps2.PS2.model.Review;

import java.util.ArrayList;
import java.util.List;

@Component
public interface ReviewService {
    Review createReview(ReviewDTO review);
    List<String> showAllReviews(int movieid);
}
