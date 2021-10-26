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
public class EmpresaLeve extends Empresa{
    private Integer id;

    public String getId() {
        return ""+id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
