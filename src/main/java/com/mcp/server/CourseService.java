package com.mcp.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private static final Logger log = LoggerFactory.getLogger(CourseService.class);
    private List<Course> courses = new ArrayList<>();

    @Tool(name = "get_courses", description = "Obtener la lista de Cursos")
    public List<Course> getCourses() {
        return courses;
    }

    @Tool(name = "get_course", description = "Obtener un Curso por titulo")
    public Course getCourse(String title) {
        return courses.stream().filter(course -> course.title().equals(title)).findFirst().orElse(null);
    }

    @PostConstruct
    public void init() {
        courses.addAll(List.of(
                new Course("01","Capacitación en Marketing Digital.", "https://youtu.be/31KTdfRH6nY"),
                new Course("01","Motivación para Vendedores de Seguros","https://youtu.be/UgX5lgv4uVM"),
                new Course("03","Programación en Java para Eventos", "https://youtu.be/31KTdfRH6nY"),
                new Course("02","Inteligencia Artificial","https://youtu.be/UgX5lgv4uVM"),
                new Course("02","Modelos de IA.", "https://youtu.be/31KTdfRH6nY"),
                new Course("03","Programación en Java con bases de Datos","https://youtu.be/UgX5lgv4uVM"),
                new Course("05","SQL y datos", "https://youtu.be/31KTdfRH6nY"),
                new Course("05","CRM y uso para clientes","https://youtu.be/UgX5lgv4uVM"),
                new Course("05","Integración de Dio-Cards y ventas.", "https://youtu.be/31KTdfRH6nY"),
                new Course("05","El valor humano de las ventas.","https://youtu.be/UgX5lgv4uVM")
                       ));
    }

}
