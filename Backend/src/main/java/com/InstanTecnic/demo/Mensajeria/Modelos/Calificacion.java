package com.InstanTecnic.demo.Mensajeria.Modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Calificacion")
public class Calificacion{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_calificacion")
    private long id;

    @Column(name="id_tecnico")
    private long tecnico;

    @Column(name="id_consulta")
    private long consulta;

    @Column(name="calificacion")
    private long calificacion;

    public Calificacion(){

    }

    public Calificacion(long id, long tecnico, long consulta, long calificacion) {
        this.id = id;
        this.tecnico = tecnico;
        this.consulta = consulta;
        this.calificacion = calificacion;
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

    public long getConsulta() {
        return this.consulta;
    }

    public void setConsulta(long consulta) {
        this.consulta = consulta;
    }

    public long getCalificacion() {
        return this.calificacion;
    }

    public void setCalificacion(long calificacion) {
        this.calificacion = calificacion;
    }
}
