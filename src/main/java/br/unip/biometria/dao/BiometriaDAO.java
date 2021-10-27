package br.unip.biometria.dao;

import br.unip.biometria.model.Agrotoxico;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.unip.biometria.model.Empresa;
import br.unip.biometria.model.EmpresaLeve;
import br.unip.biometria.model.EmpresaMargem;
import br.unip.biometria.model.EmpresaPesada;

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
                empresa.setNome(rs.getString("nome"));
                
                empresas.add(empresa);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(BiometriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empresas;
    }
    
    public static final List<EmpresaLeve> listaEmpresasLeve(){
        List<EmpresaLeve> empresas = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(DB_URL)){
            Statement stmt = conn.createStatement();
            
            var query = "SELECT id,\n" +
                        "       cnpj,\n" +
                        "       cod_agro,\n" +
                        "       porc_pol,\n" +
                        "       fk_empresas_cnpj\n" +
                        "  FROM emp_leve;";
            
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                EmpresaLeve empresa = new EmpresaLeve();
                empresa.setId(rs.getInt("id"));
                empresa.setCnpj(rs.getString("cnpj"));
                empresa.setCodAgro(rs.getString("cod_agro"));
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
            
            var query = "SELECT cod_agro,\n" +
                        "       id,\n" +
                        "       cnpj,\n" +
                        "       porc_pol,\n" +
                        "       fk_empresas_cnpj\n" +
                        "  FROM emp_pesado;";
            
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                EmpresaPesada empresa = new EmpresaPesada();
                empresa.setId(rs.getInt("id"));
                empresa.setCnpj(rs.getString("cnpj"));
                empresa.setCodAgro(rs.getString("cod_agro"));
                empresa.setPorcPol(rs.getFloat("porc_pol"));
                
                empresas.add(empresa);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(BiometriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empresas;
    }
    
    public static final List<EmpresaMargem> listaEmpresasMargem(){
        List<EmpresaMargem> empresas = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(DB_URL)){
            Statement stmt = conn.createStatement();
            
            var query = "SELECT cod_agro,\n" +
                        "       id,\n" +
                        "       cnpj,\n" +
                        "       porc_pol\n" +
                        "  FROM emp_margem;";
            
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                EmpresaMargem empresa = new EmpresaMargem();
                empresa.setId(rs.getInt("id"));
                empresa.setCnpj(rs.getString("cnpj"));
                empresa.setCodAgro(rs.getString("cod_agro"));
                empresa.setPorcPol(rs.getFloat("porc_pol"));
                
                empresas.add(empresa);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(BiometriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empresas;
    }
    
    public static final List<Agrotoxico> listaAgrotoxicosLegais(){
        List<Agrotoxico> agrotoxicos = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(DB_URL)){
            Statement stmt = conn.createStatement();
            
            var query = "SELECT cod,\n" +
                        "       marca,\n" +
                        "       modelo,\n" +
                        "       taxa_pol\n" +
                        "  FROM agro_legais;";
            
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
               Agrotoxico agrotoxico = new Agrotoxico();
               agrotoxico.setCodigo(rs.getInt("cod"));
               agrotoxico.setMarca(rs.getString("marca"));
               agrotoxico.setModelo(rs.getString("modelo"));
               agrotoxico.setTaxaPol(rs.getFloat("taxa_pol"));
                
                agrotoxicos.add(agrotoxico);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(BiometriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return agrotoxicos;
    }
    
    public static final List<Agrotoxico> listaAgrotoxicosIlegais(){
        List<Agrotoxico> agrotoxicos = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(DB_URL)){
            Statement stmt = conn.createStatement();
            
            var query = "SELECT marca,\n" +
                        "       cod,\n" +
                        "       taxa_pol,\n" +
                        "       modelo\n" +
                        "  FROM agro_ilegais;";
            
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
               Agrotoxico agrotoxico = new Agrotoxico();
               agrotoxico.setCodigo(rs.getInt("cod"));
               agrotoxico.setMarca(rs.getString("marca"));
               agrotoxico.setModelo(rs.getString("modelo"));
               agrotoxico.setTaxaPol(rs.getFloat("taxa_pol"));
                
                agrotoxicos.add(agrotoxico);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(BiometriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return agrotoxicos;
    }
}
