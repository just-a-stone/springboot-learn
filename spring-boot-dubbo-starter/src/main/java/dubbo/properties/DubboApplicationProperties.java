package dubbo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by lupf on 2017/2/28.
 */
@Data
@ConfigurationProperties(prefix = "dubbo.application")
public class DubboApplicationProperties {

    private String name = "sample";

    private String logger = "slf4j";
}
