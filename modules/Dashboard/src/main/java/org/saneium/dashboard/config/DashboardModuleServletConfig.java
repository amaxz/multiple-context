package org.saneium.dashboard.config;

import org.saneium.web.core.servlet.AbstractWebModuleConfiguration;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by mbollemeijer on 17/06/15.
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
