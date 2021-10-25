/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Gasbriel
 */
@Getter @Setter
@NoArgsConstructor
public class Empresa {
    private String cnpj;
    private String localEmp;
    private String codAgro;
    private float porcPol;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getLocalEmp() {
        return localEmp;
    }

    public void setLocalEmp(String localEmp) {
        this.localEmp = localEmp;
    }

    public String getCodAgro() {
        return codAgro;
    }

    public void setCodAgro(String codAgro) {
        this.codAgro = codAgro;
    }

    public String getPorcPol() {
        return ""+porcPol;
    }

    public void setPorcPol(float porcPol) {
        this.porcPol = porcPol;
    }

}
