package se.iths.library.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import se.iths.library.models.Roles;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String password;
    private boolean active;
    @Enumerated(EnumType.STRING)
    private Roles roles;

    //@JsonIgnore
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "login")
    private User user;

    public Login(@NotEmpty String email, @NotEmpty String password, Roles roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Login(@NotEmpty String email, boolean active, Roles roles) {
        this.email = email;
        this.active = active;
        this.roles = roles;
    }

    public Login(@NotEmpty String email, @NotEmpty String password, boolean active, Roles roles) {
        this.email = email;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }



    public Login(@NotEmpty String password) {
        this.password = password;
    }


}
