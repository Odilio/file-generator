package file.generator.service;
import java.sql.Connection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import file.generator.model.User;
import file.generator.registro.Registro;
import file.generator.repositorio.UserRepository;

@Service
public class RegistroService {
	
	 @Autowired
	 private UserRepository userRepository;

	 public Registro cab = new Registro();
	 public Connection conn;
	 int estabe = 5;
	 StringBuilder texto = new StringBuilder();
	
	 public String popularCAB(String data, String dataFinal) {
		List<User> users = userRepository.findAll();
		for (User user : users) {
			cab.VersaoLeiaute = 1;
			cab.SistemaOrigem = "Registro tipo 1";
			cab.DataGeracao = new Date();
			cab.Empresa = estabe;
			cab.DataInicialLancamentos = data.replaceAll("-", "");
			cab.DataFinalLancamentos = dataFinal.replaceAll("-", "");
			cab.Comentario = user.getName() + " - " + user.getEmail(); 
			cab.AliquotasEspecificas = false;
			texto.append(cab.toString() + "\n");
		}
		
		return texto.toString();		
	}
		 	
}