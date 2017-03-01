package dubbo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by lupf on 2017/2/28.
 */
@Data
@ConfigurationProperties(prefix = "dubbo.provider")
public class DubboProviderProperties {

    //毫秒
    private int timeout = 1000;

    private int retries = 0;

    // -1表示不延迟暴露
    private int delay = -1;
}
