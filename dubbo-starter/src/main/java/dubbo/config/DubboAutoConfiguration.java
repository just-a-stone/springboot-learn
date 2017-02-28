package dubbo.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.alibaba.dubbo.rpc.Exporter;
import dubbo.properties.DubboApplicationProperties;
import dubbo.properties.DubboProtocolProperties;
import dubbo.properties.DubboProviderProperties;
import dubbo.properties.DubboRegistryProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lupf on 2017/2/28.
 */
@Slf4j
@Configuration
@ConditionalOnClass(Exporter.class)
@EnableConfigurationProperties({
        DubboRegistryProperties.class,
        DubboProtocolProperties.class,
        DubboApplicationProperties.class,
        DubboProviderProperties.class
})
public class DubboAutoConfiguration {

    @Autowired
    private DubboApplicationProperties dubboApplicationProperties;

    @Autowired
    private DubboProtocolProperties dubboProtocolProperties;

    @Autowired
    private DubboProviderProperties dubboProviderProperties;

    @Autowired
    private DubboRegistryProperties dubboRegistryProperties;

    @Bean
    public static AnnotationBean annotationBean(@Value("${dubbo.annotation.package}") String packageName) {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage(packageName);
        log.debug("[DubboAutoConfiguration] {}", packageName);
        return annotationBean;
    }

    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(dubboApplicationProperties.getName());
        //TODO
        return applicationConfig;
    }
}
