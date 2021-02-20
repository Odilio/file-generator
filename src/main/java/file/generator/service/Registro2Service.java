package file.generator.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import file.generator.model.User;
import file.generator.registro.Registro2;
import file.generator.repositorio.UserRepository;

@Service
public class Registro2Service {
	
	 @Autowired
	 private UserRepository userRepository;

	 public Registro2 cab = new Registro2();
	 
	 StringBuilder texto = new StringBuilder();
	 
	 public String popularCAB(String data, String dataFinal) {
		List<User> users = userRepository.findAll();
		for (User user : users) {
			cab.VersaoLeiaute = 1;
			cab.SistemaOrigem = "Registro tipo 2";
			cab.DataGeracao = user.getName();
			cab.Empresa = user.getEmail();
			
			texto.append(cab.toString() + "\n");
		}
	
		return texto.toString();		
	}
		 	
}