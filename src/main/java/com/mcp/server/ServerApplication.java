package com.mcp.server;

import java.util.List;

import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Bean
	public List<ToolCallback> serverTools(CourseService courseService, TareaService tareaService) {
		return List.of(ToolCallbacks.from(courseService, tareaService));
	}

}
