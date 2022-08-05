package ro.msg.learning.shop.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String emailAddress;
}
