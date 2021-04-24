package se.iths.library.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String barCode;
    @NotEmpty
    private String title;
    private String description;


    @JsonManagedReference
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "items_authors", joinColumns = @JoinColumn(name = "item_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ItemLending> itemLendingSet;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Stock> stockSet;

    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Category> categorySet;

    public Item(@NotEmpty String barCode, @NotEmpty String title, String description) {
        this.barCode = barCode;
        this.title = title;
        this.description = description;
    }





}
