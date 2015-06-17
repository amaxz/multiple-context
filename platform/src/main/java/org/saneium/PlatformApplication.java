package org.saneium;

import org.saneium.platform.modules.DynamicModuleRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;


@Configuration
@ComponentScan(excludeFilters = {@ComponentScan.Filter(value = Controller.class, type = FilterType.ANNOTATION)})
@AutoConfigureAfter(DynamicModuleRegister.class)
@EnableAutoConfiguration
public class PlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class[] {DynamicModuleRegister.class, PlatformApplication.class}, args);
    }
}
