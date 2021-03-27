package com.mydemo.applications.config;
import com.mydemo.common.OSSTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppProjectConfig {
    @ConfigurationProperties(prefix = "oss")//把yml里的oss属性值注入到OSSTemplate对象里面
    @Bean
    public OSSTemplate ossTemplate(){
        return new OSSTemplate();
    }
}
