package se.iths.library.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ItemLending {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @JsonFormat(pattern = "yyyy-mm-dd", shape = JsonFormat.Shape.STRING)
    private String creationDate;
    @NotEmpty
    @JsonFormat(pattern = "yyyy-mm-dd", shape = JsonFormat.Shape.STRING)
    private String dueDate;
    private boolean isConfirmed;
    private boolean isReturned;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;


    public ItemLending(@NotEmpty String creationDate, @NotEmpty String dueDate, boolean isConfirmed, boolean isReturned) {
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.isConfirmed = isConfirmed;
        this.isReturned = isReturned;
    }

    public ItemLending(@NotEmpty String creationDate, @NotEmpty String dueDate, boolean isConfirmed, boolean isReturned, User user, Item item) {
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.isConfirmed = isConfirmed;
        this.isReturned = isReturned;
        this.user = user;
        this.item = item;
    }

}
