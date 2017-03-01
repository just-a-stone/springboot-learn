package dubbo.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by lupf on 2017/2/28.
 */
@Data
@ConfigurationProperties(prefix = "dubbo.registry")
public class DubboRegistryProperties {

    private String protocol="zookeeper";

    private String address="127.0.0.1:2181";

    private boolean registry=true;

    private boolean subscribe=true;
}
