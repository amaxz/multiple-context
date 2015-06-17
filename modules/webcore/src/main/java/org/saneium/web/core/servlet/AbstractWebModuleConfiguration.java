package org.saneium.web.core.servlet;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


/**
 * Created by mbollemeijer on 05/06/15.
 */
public abstract class AbstractWebModuleConfiguration {

    public ServletRegistrationBean getServletRegistrationBean() {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.setApplicationContext(getApplicationContext());

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet);
        servletRegistrationBean.setName(getServletName());
        servletRegistrationBean.addUrlMappings(getMapping());
        servletRegistrationBean.setAsyncSupported(true);

        return servletRegistrationBean;
    }

    public abstract WebApplicationContext getApplicationContext();

    protected abstract String getServletName();

    public abstract String[] getMapping();
}
