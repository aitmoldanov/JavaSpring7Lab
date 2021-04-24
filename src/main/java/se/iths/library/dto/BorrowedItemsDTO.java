package se.iths.library.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BorrowedItemsDTO {
    private Long id;
    private String title;
    private String barCode;
    private String creationDate;
    private String dueDate;

    public BorrowedItemsDTO(String title, String barCode, String creationDate, String dueDate) {
        this.title = title;
        this.barCode = barCode;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
    }

    public BorrowedItemsDTO(Long id, String title, String barCode, String creationDate, String dueDate) {
        this.id = id;
        this.title = title;
        this.barCode = barCode;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
    }
}
