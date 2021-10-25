/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Empresa;
import model.EmpresaPesada;

/**
 *
 * @author Gasbriel
 */
public class BiometriaDAO {
    
    private static final String DB_URL = "jdbc:sqlite:C:/Users/Gasbriel/Desktop/biometria/src/main/resources/dbMinisterio.db";
    
    public static final List<Empresa> listaEmpresas(){
        List<Empresa> empresas = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(DB_URL)){
            Statement stmt = conn.createStatement();
            
            var query = "SELECT *\n" +
                    "  FROM empresas;";
            
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                Empresa empresa = new Empresa();
                empresa.setCnpj(rs.getString("cnpj"));
                empresa.setCodAgro(rs.getString("cod_agro"));
                empresa.setLocalEmp(rs.getString("local_emp"));
                empresa.setPorcPol(rs.getFloat("porc_pol"));
                
                empresas.add(empresa);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(BiometriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empresas;
    }
    
    public static final List<EmpresaPesada> listaEmpresasPesado(){
        List<EmpresaPesada> empresas = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(DB_URL)){
            Statement stmt = conn.createStatement();
            
            var query = "SELECT id_p,\n" +
                    "       cnpj_p,\n" +
                    "       cod_agro,\n" +
                    "       porc_pol\n" +
                    "  FROM emp_pesada;";
            
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                EmpresaPesada empresa = new EmpresaPesada();
                empresa.setId(rs.getInt("id_p"));
                empresa.setCnpj(rs.getString("cnpj_p"));
                empresa.setCodAgro(rs.getString("cod_agro"));
                empresa.setPorcPol(rs.getFloat("porc_pol"));
                
                empresas.add(empresa);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(BiometriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empresas;
    }
}
