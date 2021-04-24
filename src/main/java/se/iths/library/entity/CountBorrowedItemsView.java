package se.iths.library.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "view") //VIEW
public class CountBorrowedItemsView implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "item_id")
    private Long id;
    @Column(name = "bar_code")
    private String isbn;
    private String title;
    @Column(name = "quantity")
    private int borrowedItemQuantity;

    public CountBorrowedItemsView(String isbn, String title, int borrowedItemQuantity) {
        this.isbn = isbn;
        this.title = title;
        this.borrowedItemQuantity = borrowedItemQuantity;
    }
}
