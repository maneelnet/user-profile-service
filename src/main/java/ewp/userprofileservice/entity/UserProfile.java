package ewp.userprofileservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user_profile")
public class UserProfile {

    @Id
    private String id;

    @NotNull
    private String first_name;

    @NotNull
    private String last_name;

    private String email;

    private String phone;

    private String telegramId;
}
