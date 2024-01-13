package co.pragra.learning.guestbookserviceaug2023.services;

import co.pragra.learning.guestbookserviceaug2023.entities.Address;
import co.pragra.learning.guestbookserviceaug2023.entities.Guest;
import co.pragra.learning.guestbookserviceaug2023.entities.Review;
import co.pragra.learning.guestbookserviceaug2023.repositories.AddressRepo;
import co.pragra.learning.guestbookserviceaug2023.repositories.GuestRepo;
import co.pragra.learning.guestbookserviceaug2023.repositories.ReviewRepo;
import lombok.Data;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class GuestBookService {

    private final GuestRepo repo;
    private final AddressRepo addressRepo;
    private final ReviewRepo reviewRepo;

    public Guest addOrUpdateGuest(Guest guest){
//        Address address = addressRepo.save(guest.getAddress());
//        guest.setAddress(address);
        return repo.save(guest);
    }

    public List<Guest> getAllGuests(){
        return repo.findAll();
    }

    public Optional<Guest> getGuestById(Integer id){

        return repo.findById(id);

    }

    public Optional<Guest> getGuestByFirstName(String firstName){
        return repo.findGuestsByFirstName(firstName);
    }

    public Optional<Guest> deleteGuestById(Integer id){
        Optional<Guest> guestById = repo.findById(id);
        if(guestById.isPresent()){
            repo.deleteById(id);
            return guestById;
        }
        return Optional.empty();
    }

    public Optional<Guest> updateGuest(Guest guest){
        Optional<Guest> guestById = repo.findById(guest.getGuestId());
        if(guestById.isPresent()){
            return Optional.of(addOrUpdateGuest(guest));
        }
        return Optional.empty();
    }


}
