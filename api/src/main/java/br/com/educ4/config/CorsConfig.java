//package br.com.educ4.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.cors.reactive.CorsWebFilter;
//import org.springframework.web.filter.CorsFilter;
//
//import static java.util.Collections.singletonList;
//import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;
//
//@Configuration
//@RequiredArgsConstructor
//public class CorsConfig {
//
//    @Bean
//    public FilterRegistrationBean<CorsWebFilter> corsFilterRegistrationBean() {
//
//        var config = new CorsConfiguration();
//        config.setAllowCredentials(true);
//
//        config.setAllowedMethods(singletonList("*"));
//        config.setAllowedHeaders(singletonList("*"));
//        config.addAllowedOriginPattern("*");
//
//        var source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", config);
//
//        var bean = new FilterRegistrationBean<CorsFilter>();
//        bean.setFilter(new CorsFilter(source));
//        bean.setOrder(HIGHEST_PRECEDENCE);
//
//        return bean;
//    }
//
//}
