package Application.bookMyShow.Repository;

import Application.bookMyShow.Entity.TheaterEntity;
import Application.bookMyShow.Entity.TheaterSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterSeatRepository extends JpaRepository<TheaterSeatEntity, Integer> {
}
