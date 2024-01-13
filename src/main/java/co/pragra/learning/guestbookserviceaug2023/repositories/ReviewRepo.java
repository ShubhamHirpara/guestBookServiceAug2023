package co.pragra.learning.guestbookserviceaug2023.repositories;

import co.pragra.learning.guestbookserviceaug2023.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {
}
