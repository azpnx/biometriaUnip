/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import com.machinezoo.sourceafis.FingerprintImage;
import com.machinezoo.sourceafis.FingerprintImageOptions;
import com.machinezoo.sourceafis.FingerprintMatcher;
import com.machinezoo.sourceafis.FingerprintTemplate;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

/**
 *
 * @author Gasbriel
 */
public class LoginProvider {
    
    public Boolean verificaBiometriaDiretor(String path) throws IOException{
        FingerprintTemplate prova = new FingerprintTemplate(
	new FingerprintImage(
		Files.readAllBytes(Paths.get("./src/main/java/img/bio_diretor.png")),
		new FingerprintImageOptions()
			.dpi(500)));
        
        FingerprintTemplate candidato = new FingerprintTemplate(
	new FingerprintImage(
		Files.readAllBytes(Paths.get(path)),
		new FingerprintImageOptions()
			.dpi(500)));
        
        double pontuacao = new FingerprintMatcher(prova)
	.match(candidato);
        boolean combina = pontuacao >= 40;
        JOptionPane.showMessageDialog(null, "Diretor entrou!");
        return combina;
    }
    
    public Boolean verificaBiometriaMinistro(String path) throws IOException{
        FingerprintTemplate prova = new FingerprintTemplate(
	new FingerprintImage(
		Files.readAllBytes(Paths.get("./src/main/java/img/bio_ministro.jpg")),
		new FingerprintImageOptions()
			.dpi(500)));
        
        FingerprintTemplate candidato = new FingerprintTemplate(
	new FingerprintImage(
		Files.readAllBytes(Paths.get(path)),
		new FingerprintImageOptions()
			.dpi(500)));
        
        double pontuacao = new FingerprintMatcher(prova)
	.match(candidato);
        boolean combina = pontuacao >= 40;
        JOptionPane.showMessageDialog(null, "Ministro entrou!");
        return combina;
    }
    
    public NivelAcessoEnum retornaTipoAcesso(String path) throws IOException{
        
        if(verificaBiometriaDiretor(path)){
            return NivelAcessoEnum.DIRETOR;
        }else if(verificaBiometriaMinistro(path))
        {
            return NivelAcessoEnum.MINISTRO;
        }else{
            return NivelAcessoEnum.LIVRE;
        }
    }
    
}
