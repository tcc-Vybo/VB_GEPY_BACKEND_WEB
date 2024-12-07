package gepy.vybo.tcc.VB_GEPY_BACKEND_WEB.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedOrigins("http://localhost:8081", "http://localhost:3000", "http://localhost:5173/", "https://vybogepyfrontendweb.vercel.app/", "https://vb-gepy-frontend-web.vercel.app/")
                .allowedHeaders("*");
    }
}
