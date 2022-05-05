package br.com.jlgregorio.crud.config;

import br.com.jlgregorio.crud.serialization.converter.YamlJackson2HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    //..creates a media type to Yaml
    private static final MediaType MEDIA_TYPE_YAML = MediaType.valueOf("application/x-yaml");

    //..creates an interceptor to http requests
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.add(new YamlJackson2HttpMessageConverter());
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer){

        configurer.favorParameter(true)
                .ignoreAcceptHeader(false)
                .parameterName("mediaType")
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("yaml", MEDIA_TYPE_YAML);
    }


}
