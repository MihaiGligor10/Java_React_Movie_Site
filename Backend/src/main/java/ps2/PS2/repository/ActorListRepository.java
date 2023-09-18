package ps2.PS2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ps2.PS2.model.ActorList;

@Repository
public interface ActorListRepository extends JpaRepository<ActorList,Long> {

}
