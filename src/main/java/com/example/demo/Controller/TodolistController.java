package com.example.demo.Controller;

import com.example.demo.Entity.TodolistEntity;
import com.example.demo.Repository.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TodolistController {
    @Autowired
    private TodolistRepository todolistRepository;
    @GetMapping("")
    public List<TodolistEntity> mostrarTarea(){
        return todolistRepository.findAll();
    }
    @PostMapping("")
    public TodolistEntity crearTarea(@RequestBody TodolistEntity todolistEntity){
        return todolistRepository.save(todolistEntity);
    }
    @PutMapping("/{id}")
    public TodolistEntity actualizarTarea(@RequestBody TodolistEntity todolistEntity){
        return todolistRepository.save(todolistEntity);

    }
    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Long id){
        todolistRepository.deleteById(id);
    }
}
