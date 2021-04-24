package se.iths.library.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    private String fullName;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @NotEmpty
    private String birthDate;
    private String address;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id")  //ID is not nullabe @JoinColumn(name = "user_id", nullable = false)
    private Login login;

    @JsonBackReference
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ItemLending> itemLendingSet;



    public User(@NotEmpty String fullName, @NotEmpty String birthDate, String address) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.address = address;
    }

    public User(@NotEmpty String fullName, @NotEmpty String birthDate, String address, Login login) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.address = address;
        this.login = login;
    }
}
