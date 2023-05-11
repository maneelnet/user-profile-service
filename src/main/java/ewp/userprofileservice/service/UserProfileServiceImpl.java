package ewp.userprofileservice.service;

import ewp.userprofileservice.api.dto.UserProfileDto;
import ewp.userprofileservice.repository.UserProfileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    @Override
    public UserProfileDto findById(String id) {
        return new UserProfileDto(userProfileRepository.findById(id).get());
    }

    @Override
    public UserProfileDto findByTelegramId(String telegramId) {
        return new UserProfileDto(userProfileRepository.getByTelegramId(telegramId));
    }
}
