package ps2.PS2.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ps2.PS2.dto.ReviewDTO;
import ps2.PS2.model.Review;
import ps2.PS2.repository.ReviewRepository;
import ps2.PS2.service.ReviewService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public Review createReview(ReviewDTO review) {
        Review r = new Review(review.getClient(),review.getMovie(),review.getReview());
        return reviewRepository.save(r);
    }

    @Override
    public List<String> showAllReviews(int m) {
        if(reviewRepository.findAllByMovie(m)==null)
        {
            List<String> nop=new ArrayList<>();
            nop.add("");
            return nop;
        }else
        {
            List<Review> r=reviewRepository.findAllByMovie(m);
            List<String> reviews = new ArrayList<>();
            for(int i=0;i<r.size();i++)
            {
                reviews.add(r.get(i).getReview() + "\n\n");
            }
            return reviews;
        }
    }
}
