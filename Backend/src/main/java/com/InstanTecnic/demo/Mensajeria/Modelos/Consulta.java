package com.InstanTecnic.demo.Mensajeria.Modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Consulta")
public class Consulta{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_consulta")
    private long id;

    @Column(name="id_tecnico")
    private long tecnico;

    @Column(name="id_cliente")
    private long cliente;

    @Column(name="titulo")
    private String titulo;

    @Column(name="descripcion")
    private String descripcion;

    @Column(name="categoria")
    private String categoria;

    @Column(name="aceptada")
    private String aceptada = "NO";

    public Consulta(){

    }

    public Consulta(long id, long tecnico, long cliente, String titulo, String descripcion, String categoria, String aceptada) {
        this.id = id;
        this.tecnico = tecnico;
        this.cliente = cliente;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.aceptada = aceptada;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTecnico() {
        return this.tecnico;
    }

    public void setTecnico(long tecnico) {
        this.tecnico = tecnico;
    }

    public long getCliente() {
        return this.cliente;
    }

    public void setCliente(long cliente) {
        this.cliente = cliente;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAceptada() {
        return this.aceptada;
    }

    public void setAceptada(String aceptada){
        this.aceptada = aceptada;
    }
}
