package com.example.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

import com.example.service.GLService;
import com.example.service.GLServiceImpl;

@Configuration
@ConfigurationProperties(prefix = "gl")
public class GLAutoConfiguration {

	private boolean featureEnabled;
	private String someProperty;

	public boolean isFeatureEnabled() {
		return featureEnabled;
	}

	public void setFeatureEnabled(boolean featureEnabled) {
		this.featureEnabled = featureEnabled;
		System.out.println(this.featureEnabled);
	}

	public String getSomeProperty() {
		return someProperty;
	}

	public void setSomeProperty(String someProperty) {
		this.someProperty = someProperty;
	}

	@Bean
	public GLService glService() {
		return new GLServiceImpl();
	}

}
