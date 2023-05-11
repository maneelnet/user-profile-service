package ewp.userprofileservice.service;

import ewp.userprofileservice.api.dto.UserProfileDto;

/**
 * Сервис для работы с профилями пользователя
 */
public interface UserProfileService {
    /**
     * Метод ищет элемент по id пришедшему из урла от клиента
     */
    UserProfileDto findById(String id);

    /**
     * Метод ищет элемент по telegramId пришедшему из урла от клиента
     */
    UserProfileDto findByTelegramId(String telegramId);
}
