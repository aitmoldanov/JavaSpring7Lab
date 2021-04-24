package se.iths.library.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;
    @NotEmpty
    private String fullName;
    @NotEmpty
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private String birthDate;

    //@JsonIgnore
    @JsonBackReference
    @ManyToMany(mappedBy = "authors", cascade = { CascadeType.ALL })
    public Set<Item> items = new HashSet<>();

    public Author(String fullName, String birthDate) {
        this.fullName = fullName;
        this.birthDate = birthDate;
    }
}
