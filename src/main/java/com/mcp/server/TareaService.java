package com.mcp.server;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

     @Tool(name = "get_tareas", description = "Obtener la lista de las tareas pendientes.")
     
    public List<Tarea> listarTodas() {
        return tareaRepository.findAll();
    }

    public Optional<Tarea> buscarPorId(Long id) {
        return tareaRepository.findById(id);
    }
    
    @Tool(name = "save_tarea", description = "guarda una tarea en la base de datos")
    @Transactional
    public Tarea guardar(String titulo, String fecha) {
        Tarea newTarea = new Tarea();
        newTarea.setTitulo(titulo);
        newTarea.setFecha(fecha);
        newTarea.setCompletado(false);                         
        return tareaRepository.save(newTarea);
    }

    public void eliminar(Long id) {
        tareaRepository.deleteById(id);
    }
}
