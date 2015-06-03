package org.saneium;

import org.saneium.core.web.config.CoreConfig;
import org.saneium.dashboard.config.DashboardConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@EnableAutoConfiguration
public class PlatformApplication   {

    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean coreDispatcherServlet() {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        AnnotationConfigEmbeddedWebApplicationContext applicationContext = new AnnotationConfigEmbeddedWebApplicationContext();
        applicationContext.register(CoreConfig.class);
        applicationContext.scan("org.saneium.core.web");
        dispatcherServlet.setApplicationContext(applicationContext);


        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/core/*");
        servletRegistrationBean.setName("core");
        servletRegistrationBean.addUrlMappings("/core");
        servletRegistrationBean.setAsyncSupported(true);

        return servletRegistrationBean;
    }

    @Bean
    public ServletRegistrationBean dashBoardDispatcherServlet() {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();

        AnnotationConfigEmbeddedWebApplicationContext applicationContext = new AnnotationConfigEmbeddedWebApplicationContext();
        applicationContext.register(DashboardConfig.class);
        applicationContext.scan("org.saneium.dashboard");
        dispatcherServlet.setApplicationContext(applicationContext);

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/admin/*");
        servletRegistrationBean.setName("admin");
        servletRegistrationBean.addUrlMappings("/admin");
        servletRegistrationBean.setAsyncSupported(true);
        return servletRegistrationBean;
    }
}
