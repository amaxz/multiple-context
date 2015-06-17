package org.saneium.platform.modules;

import org.saneium.web.core.servlet.AbstractWebModuleConfiguration;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ServletContextInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Map;

/**
 * Created by mbollemeijer on 06/06/15.
 */
public class DynamicModuleRegister implements ServletContextInitializer {

    @Autowired
    private ListableBeanFactory beanFactory;

    public void onStartup(ServletContext servletContext) throws ServletException {
        Map<String, AbstractWebModuleConfiguration> beans =  beanFactory.getBeansOfType(AbstractWebModuleConfiguration.class);
        System.out.println(String.format("Found %d dynamic module configurations", beans .size()));
        for(Map.Entry<String, AbstractWebModuleConfiguration> module : beans.entrySet()) {
            module.getValue().getServletRegistrationBean().onStartup(servletContext);
        }
    }
}
