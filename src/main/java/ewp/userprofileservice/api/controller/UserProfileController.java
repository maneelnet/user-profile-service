package ewp.userprofileservice.api.controller;

import ewp.userprofileservice.api.dto.UserProfileDto;
import ewp.userprofileservice.service.UserProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/user-profile")
@AllArgsConstructor
@Api(value = "user-profile", tags = {"userprofile"})
public class UserProfileController {

    private final UserProfileService userProfileService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Получить userprofile по id", response = UserProfileDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 404, message = "Сущность не найдена"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<UserProfileDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(userProfileService.findById(id));
    }

    @GetMapping("/find-by-telegram-id/{telegramId}")
    @ApiOperation(value = "Получить userprofile по telegramId", response = UserProfileDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Успешный ответ"),
            @ApiResponse(code = 404, message = "Сущность не найдена"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервиса")
    })
    public ResponseEntity<UserProfileDto> getByTelegramId(@PathVariable String telegramId) {
        return ResponseEntity.ok(userProfileService.findByTelegramId(telegramId));
    }
}
