package dubbo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by lupf on 2017/2/28.
 */
@Data
@ConfigurationProperties(prefix = "dubbo.protocol")
public class DubboProtocolProperties {

    private String name = "dubbo";

    private int port = 20880;

    private String accessLog = "true";
}
