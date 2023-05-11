package ewp.userprofileservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "user-profile")
@Data
public class TaskTrackerProperties {
    private Integer pageDefaultSize;
    private Integer pageMaxSize;
}