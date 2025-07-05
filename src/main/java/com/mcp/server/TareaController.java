package com.mcp.server;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TareaController {

private final TareaService tareaService;

public TareaController(TareaService tareaService) {
    this.tareaService = tareaService;
}    
    
@PostMapping(value = "/tareas", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
public List<Tarea> getTareas() {
    return tareaService.listarTodas();
}

@PostMapping(value = "/tareas/save", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
public Tarea saveTareas(@RequestBody Tarea tarea) {   

    return tareaService.guardar(tarea.getTitulo(), tarea.getFecha());
}

}
