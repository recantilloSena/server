package com.mcp.server;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class CourseController {
    

private final CourseService courseService;

public CourseController(CourseService courseService) {
    this.courseService = courseService;
}

@PostMapping(value = "/courses", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
public List<Course> getCourse() {
    return courseService.getCourses();
}


    
}
