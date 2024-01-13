package co.pragra.learning.guestbookserviceaug2023.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String login;
    private Integer id;
    private String avatar_url;
}
