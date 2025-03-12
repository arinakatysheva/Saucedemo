package dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@AllArgsConstructor
@Builder
public class Customer {
    private String firstName;
    private String lastName;
    private String zipCode;
}