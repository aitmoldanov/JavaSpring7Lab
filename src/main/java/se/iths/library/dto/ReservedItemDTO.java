package se.iths.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservedItemDTO {
    private Long id;
    private String barCode;
    private String title;
    private String fullName;
}
