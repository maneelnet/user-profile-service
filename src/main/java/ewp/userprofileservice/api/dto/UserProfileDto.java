package ewp.userprofileservice.api.dto;

import ewp.userprofileservice.entity.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDto {

    private String id;

    @NotBlank
    @Size(min = 2, max = 128)
    private String firstName;

    @NotBlank
    @Size(min = 2, max = 128)
    private String lastName;

    @NotBlank
    @Size(min = 2, max = 36)
    private String email;

    @NotBlank
    @Size(min = 2, max = 36)
    private String phone;

    @NotBlank
    @Size(min = 2, max = 128)
    private String telegramId;

    public UserProfileDto(UserProfile userProfile) {
        this.id = userProfile.getId();
        this.firstName = userProfile.getFirst_name();
        this.lastName = userProfile.getLast_name();
        this.email = userProfile.getEmail();
        this.phone = userProfile.getPhone();
        this.telegramId = userProfile.getTelegramId();
    }
}
