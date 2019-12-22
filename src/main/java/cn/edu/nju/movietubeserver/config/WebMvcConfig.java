package cn.edu.nju.movietubeserver.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author dc
 * @date 2019/12/20 18:06
 *
 * Spring MVC 配置
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer
{

    private static final long MAX_AGE_SECS = 3600;

    @Override
    public void addCorsMappings(CorsRegistry registry)
    {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("HEAD", "OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE")
            .maxAge(MAX_AGE_SECS);
    }

    /**
     * 阿里 FastJson 作JSON MessageConverter
     */
    @Override
    public void configureMessageConverters(final List<HttpMessageConverter<?>> converters)
    {
        final FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        final FastJsonConfig config = new FastJsonConfig();
        converter.setSupportedMediaTypes(new ArrayList<MediaType>()
        {{
            add(MediaType.APPLICATION_JSON_UTF8);
            add(MediaType.APPLICATION_FORM_URLENCODED);
            add(MediaType.TEXT_HTML);
        }});
        config.setSerializerFeatures(
            // 保留空的字段
            //SerializerFeature.WriteMapNullValue,
            // String null -> ""
            SerializerFeature.WriteNullStringAsEmpty,
            // Number null -> 0
            SerializerFeature.WriteNullNumberAsZero);
        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(StandardCharsets.UTF_8);
        converters.add(converter);
    }
}