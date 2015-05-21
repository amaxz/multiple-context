package org.saneium.core.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;

/**
 * Created by mbollemeijer on 19/05/15.
 */
@WebListener
@Configuration
public class CoreConfig implements WebApplicationInitializer, EmbeddedServletContainerCustomizer{

    @Autowired
    private ApplicationContext applicationContext;

    @Bean(name = "coreConfigServlet")
    public ServletRegistrationBean coreConfigServletDinges() {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();

        AnnotationConfigEmbeddedWebApplicationContext applicationContext = new AnnotationConfigEmbeddedWebApplicationContext();
        applicationContext.register(
                PropertyPlaceholderAutoConfiguration.class,
                EmbeddedServletContainerAutoConfiguration.class,
                DispatcherServletAutoConfiguration.class);
        dispatcherServlet.setApplicationContext(applicationContext);

        applicationContext.setParent(this.applicationContext);
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet, "/core/*");
        servletRegistrationBean.setName("core");
        return servletRegistrationBean;
    }


    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("test");
        coreConfigServletDinges();
    }

    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setContextPath("/core");
    }
}
