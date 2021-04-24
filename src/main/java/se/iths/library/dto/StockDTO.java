package se.iths.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockDTO {
    private Long id;
    private int quantity;
    private String barCode;
    private String title;
}
