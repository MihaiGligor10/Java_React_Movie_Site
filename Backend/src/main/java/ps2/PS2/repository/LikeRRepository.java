package ps2.PS2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ps2.PS2.model.LikeR;

@Repository
public interface LikeRRepository extends JpaRepository<LikeR,Long> {

}
