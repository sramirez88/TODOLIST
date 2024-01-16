package com.example.demo.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "todolist")
public class TodolistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    private LocalDate fecha;

    public TodolistEntity(){

    }

    public TodolistEntity(String titulo, String descripcion, LocalDate fecha) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }
    public Long getId() { return id; }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
