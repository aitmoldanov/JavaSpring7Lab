package se.iths.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import se.iths.library.models.Roles;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDTO {
    private Long userId;
    private Long loginId;
    private boolean active;
    private String fullName;
    private String email;
    private String password;
    private Roles roles;
    private String birthDate;
    private String address;

    public UserInfoDTO(boolean active, String fullName, String email, String password, Roles roles, String birthDate, String address, Long userId, Long loginId) {
        this.active = active;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.birthDate = birthDate;
        this.address = address;
        this.userId = userId;
        this.loginId = loginId;
    }



}
