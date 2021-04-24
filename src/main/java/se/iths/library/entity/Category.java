package se.iths.library.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import se.iths.library.models.Categories;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Categories categories;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "item_id")
    private Item item;

    public Category(Categories categories) {
        this.categories = categories;
    }

    public Category(Categories categories, Item item) {
        this.categories = categories;
        this.item = item;
    }


}
