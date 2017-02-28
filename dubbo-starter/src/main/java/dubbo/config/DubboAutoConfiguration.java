package dubbo.config;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
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
	public ApplicationConfig applicationConfig() {
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName(dubboApplicationProperties.getName());
		applicationConfig.setLogger(dubboApplicationProperties.getLogger());
		log.debug("[DubboAutoConfiguration] {}", applicationConfig);
		return applicationConfig;
	}

	@Bean
	public RegistryConfig registryConfig() {
		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setAddress(dubboRegistryProperties.getAddress());
		registryConfig.setProtocol(dubboRegistryProperties.getProtocol());
		registryConfig.setRegister(dubboRegistryProperties.isRegistry());
		registryConfig.setSubscribe(dubboRegistryProperties.isSubscribe());
		log.debug("[DubboAutoConfiguration] {}", registryConfig);
		return registryConfig;
	}

	@Bean
	public ProtocolConfig protocolConfig() {
		ProtocolConfig protocolConfig = new ProtocolConfig();
		protocolConfig.setName(dubboProtocolProperties.getName());
		protocolConfig.setPort(dubboProtocolProperties.getPort());
		protocolConfig.setAccesslog(dubboProtocolProperties.getAccessLog());
		log.debug("[DubboAutoConfiguration] {}", protocolConfig);
		return protocolConfig;
	}

	@Bean
	public ProviderConfig providerConfig(ApplicationConfig applicationConfig, ProtocolConfig protocolConfig, RegistryConfig registryConfig) {
		ProviderConfig providerConfig = new ProviderConfig();
		providerConfig.setTimeout(dubboProviderProperties.getTimeout());
		providerConfig.setRetries(dubboProviderProperties.getRetries());
		providerConfig.setDelay(dubboProviderProperties.getDelay());
		providerConfig.setApplication(applicationConfig);
		providerConfig.setProtocol(protocolConfig);
		providerConfig.setRegistry(registryConfig);
		return providerConfig;
	}
}
