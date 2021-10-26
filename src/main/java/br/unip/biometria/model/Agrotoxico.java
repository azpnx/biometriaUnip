/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unip.biometria.model;

/**
 *
 * @author Gasbriel
 */
public class Agrotoxico {
    private Integer codigo;
    private String marca;
    private String modelo;
    private float taxaPol;

    public String getCodigo() {
        return "" + codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTaxaPol() {
        return "" + taxaPol;
    }

    public void setTaxaPol(float taxaPol) {
        this.taxaPol = taxaPol;
    }
    
}