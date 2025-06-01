package com.photopedia.config;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

public class DotenvLoader implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        Dotenv dotenv = Dotenv.load();

        Map<String, Object> props = new HashMap<>();
        for (DotenvEntry entry : dotenv.entries()) {
            props.put(entry.getKey(), entry.getValue());
        }

        ConfigurableEnvironment environment = event.getEnvironment();
        environment.getPropertySources().addFirst(new MapPropertySource("dotenv", props));
    }
}
