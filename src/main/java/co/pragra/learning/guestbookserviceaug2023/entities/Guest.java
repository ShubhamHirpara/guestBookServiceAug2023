package co.pragra.learning.guestbookserviceaug2023.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer guestId;
    private String firstName;
    private String lastName;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "addressId")
    private Address address;
    //safe delete
    @Builder.Default
    private boolean active = true;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews;
    /*
    * CRUD Operations:
    * FETCH
    * Read ->
    * CASCADE
    * Create
    * Update
    * Delete
    * */

    @Transient
    @Builder.Default
    private Instant createDateTime = Instant.now();
}


