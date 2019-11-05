package cn.com.hatech.app.business.config.oauth;

import feign.RequestInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.security.oauth2.client.feign.OAuth2FeignRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * @Copyright (C), 2018,北京同创永益科技发展有限公司
 * @ProjectName: hatech
 * @Package: cn.com.hatech.app.business.config.oauth
 * @ClassName: OautheClientConfig
 * @Author: Xincan
 * @Description: ${description}
 * @Date: 2019/4/19 13:49
 * @Version: 1.0
 */
@Configuration
@EnableConfigurationProperties
@EnableOAuth2Client
public class Oauth2ClientConfig {

}
