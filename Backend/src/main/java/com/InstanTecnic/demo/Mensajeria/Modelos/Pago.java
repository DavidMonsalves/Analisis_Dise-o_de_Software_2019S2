package com.InstanTecnic.demo.Mensajeria.Modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pago")
public class Pago{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_pago")
    private long id;

    @Column(name="id_consulta")
    private long consulta;

    @Column(name="tarjeta")
    private String tarjeta;

    @Column(name="monto")
    private String monto = "$10000";

    public Pago(){

    }

    public Pago(long id, long consulta, String tarjeta, String monto) {
        this.id = id;
        this.consulta = consulta;
        this.tarjeta = tarjeta;
        this.monto = monto;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getConsulta() {
        return this.consulta;
    }

    public void setConsulta(long consulta) {
        this.consulta = consulta;
    }

    public String getTarjeta() {
        return this.tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getMonto() {
        return this.monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }
}
