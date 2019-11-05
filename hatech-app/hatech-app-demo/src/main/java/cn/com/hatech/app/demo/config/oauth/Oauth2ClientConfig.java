package cn.com.hatech.app.demo.config.oauth;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
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
 * @Package: cn.com.hatech.app.demo.config.oauth
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

//    @Bean
//    @ConfigurationProperties(prefix = "security.oauth2.client")
//    public ClientCredentialsResourceDetails clientCredentialsResourceDetails(){
//        ClientCredentialsResourceDetails clientCredentialsResourceDetails = new ClientCredentialsResourceDetails();
//        System.out.println("----------------------------------Oauth2ClientConfig--------------------------------------------------------");
//        System.out.println("access_token_uri: " + clientCredentialsResourceDetails.getAccessTokenUri());
//        System.out.println("client_id: " + clientCredentialsResourceDetails.getClientId());
//        System.out.println("client_secret: " + clientCredentialsResourceDetails.getClientSecret());
//        System.out.println("grant_type: " + clientCredentialsResourceDetails.getGrantType());
//        System.out.println("scope: " + clientCredentialsResourceDetails.getScope());
//        System.out.println("----------------------------------Oauth2ClientConfig--------------------------------------------------------");
//        return clientCredentialsResourceDetails;
//    }
//
//    @Bean
//    public RequestInterceptor oauth2FeignRequestInterceptor(){
//        DefaultOAuth2ClientContext defaultOAuth2ClientContext = new DefaultOAuth2ClientContext();
//        System.out.println("----------------------------------Oauth2ClientConfig--------------------------------------------------------");
//        System.out.println("access_token: " + defaultOAuth2ClientContext.getAccessToken());
//        System.out.println("----------------------------------Oauth2ClientConfig--------------------------------------------------------");
//        return new OAuth2FeignRequestInterceptor(defaultOAuth2ClientContext, clientCredentialsResourceDetails());
//    }
//
//    @Bean
//    public OAuth2RestTemplate clientCredentialsRestTemplate() {
//        return new OAuth2RestTemplate(clientCredentialsResourceDetails());
//    }

}
