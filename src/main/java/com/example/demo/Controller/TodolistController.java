package com.example.demo.Controller;

import com.example.demo.Entity.TodolistEntity;
import com.example.demo.Repository.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/tareas")
public class TodolistController {

    @Autowired
    private TodolistRepository todolistRepository;

    @GetMapping("/list")
    public String mostrarListaTareas(Model model) {
        List<TodolistEntity> tareas = todolistRepository.findAll();
        model.addAttribute("tareas", tareas);
        return "lista"; // Nombre de la vista HTML (sin .html)
    }

    @GetMapping("/crear")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("tarea", new TodolistEntity());
        return "formulario-crear"; // Vista del formulario de creación (sin .html)
    }
    @PostMapping("/crear")
    public String crearTarea(@ModelAttribute("tarea") TodolistEntity tarea) {
        // Lógica para guardar la tarea en la base de datos
        todolistRepository.save(tarea);
        return "redirect:/tareas/list"; // Redirige a la lista de tareas después de guardar
    }
    @GetMapping("/{id}/eliminar")
    public String eliminarTarea(@PathVariable Long id) {
        // Lógica para eliminar la tarea por su ID
        todolistRepository.deleteById(id);
        return "redirect:/tareas/list"; // Redirige a la lista de tareas después de eliminar
    }
    @GetMapping("/{id}/editar")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        TodolistEntity tarea = todolistRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de tarea inválido: " + id));

        model.addAttribute("tarea", tarea);
        return "formulario-edicion"; // Vista del formulario de edición (sin .html)
    }

    @PostMapping("/{id}/editar")
    public String editarTarea(@PathVariable Long id, @ModelAttribute("tarea") TodolistEntity tareaDetalles) {
        TodolistEntity tarea = todolistRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de tarea inválido: " + id));

        // Actualizar los detalles de la tarea
        tarea.setTitulo(tareaDetalles.getTitulo());
        tarea.setDescripcion(tareaDetalles.getDescripcion());
        tarea.setFecha(tareaDetalles.getFecha());

        // Guardar la tarea actualizada en la base de datos
        todolistRepository.save(tarea);
        return "redirect:/tareas/list"; // Redirige a la lista de tareas después de editar
    }
}
