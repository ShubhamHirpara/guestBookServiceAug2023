package co.pragra.learning.guestbookserviceaug2023.repositories;

import co.pragra.learning.guestbookserviceaug2023.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuestRepo extends JpaRepository<Guest, Integer> {
    Optional<Guest> findGuestsByFirstName(String firstName);

}
