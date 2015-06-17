package org.saneium.core.web.config;

import org.saneium.web.core.servlet.AbstractWebModuleConfiguration;
import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by mbollemeijer on 05/06/15.
 */

@Component
public class CoreModuleServletConfig extends AbstractWebModuleConfiguration {

    private static final String  BASE_PACKAGE = "org.saneium.core.web";

    @Override
    public WebApplicationContext getApplicationContext() {
        AnnotationConfigEmbeddedWebApplicationContext webApplicationContext = new AnnotationConfigEmbeddedWebApplicationContext();
        webApplicationContext.scan(BASE_PACKAGE);
        webApplicationContext.register(CoreConfig.class);

        return webApplicationContext;
    }

    @Override
    protected String getServletName() {
        return "coreServlet";
    }

    @Override
    public String[] getMapping() {
        return new String[]{"/core", "/core/*"};
    }
}
