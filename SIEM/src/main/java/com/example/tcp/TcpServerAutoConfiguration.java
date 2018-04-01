package com.example.tcp;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(TcpServerProperties.class)
@ConditionalOnProperty(prefix = "javatcp.tcp-server", name = { "port", "autoStart" })
public class TcpServerAutoConfiguration {

	@Bean
	TcpServerAutoStarterApplicationListener tcpServerAutoStarterApplicationListener() {
		return new TcpServerAutoStarterApplicationListener();
	}

	@Bean
	TcpControllerBeanPostProcessor tcpControllerBeanPostProcessor() {
		return new TcpControllerBeanPostProcessor();
	}

	@Bean
	Server server() {
		return new TcpServer();
	}
}
