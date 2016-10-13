package org.saneium.dashboard.config;

import org.saneium.web.core.servlet.AbstractWebModuleConfiguration;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Class description
 * @author mbollemeijer
 * Created on 2016-10-13.
 */
@Component
public class DashboardModuleServletConfig extends AbstractWebModuleConfiguration {

    @Override
    public WebApplicationContext getApplicationContext() {
        AnnotationConfigEmbeddedWebApplicationContext webApplicationContext = new AnnotationConfigEmbeddedWebApplicationContext();
        webApplicationContext.register(DashboardConfig.class);
        webApplicationContext.scan("org.saneium.dashboard");

        return webApplicationContext;
    }

    @Override
    protected String getServletName() {
        return "dashboardModuleServletConfig";
    }

    @Override
    public String[] getMapping() {
        return new String[]{"/dashboard", "/dashboard/*"};
    }
}
