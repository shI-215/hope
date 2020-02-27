package com.example.hope;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Oji
 * @Date: 2020/02/27/15:26
 * @Description: 读取本地（服务器）图片显示在页面
 */
@Configuration
public class SourceConfiguration extends WebMvcConfigurationSupport {
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/file/**").addResourceLocations("file:E://Hope/images/");
        super.addResourceHandlers(registry);
    }
}
