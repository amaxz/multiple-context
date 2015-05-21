//package org.saneium.core.web;
//
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
//import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
//import org.springframework.boot.autoconfigure.web.ServerProperties;
//import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.DispatcherServlet;
//
//import javax.servlet.Servlet;
//
///**
// * Created by mbollemeijer on 20/05/15.
// */
//
//@Configuration
//@ConditionalOnClass({ Servlet.class, DispatcherServlet.class })
//@ConditionalOnWebApplication
//@AutoConfigureAfter({ CoreConfig.class, PropertyPlaceholderAutoConfiguration.class,
//        EmbeddedServletContainerAutoConfiguration.class, WebMvcAutoConfiguration.class,
//        ServerProperties.class })
//public class Config2 {
//}
