package file.generator.service;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import file.generator.model.User;
import file.generator.registro.Registro2;

@Service
public class GeneratorService {
	
	 @Autowired
	 private RegistroService registroService;

	 @Autowired
	 private Registro2Service registro2Service;
	 
	 StringBuilder texto = new StringBuilder();
	 
	 File file; 
	 
	 public String generateFile() {
		
			
		texto.append(registroService.popularCAB("2015", "2016"));
		texto.append(registro2Service.popularCAB("2015", "2016"));
		
		file = new File("nome do arquivo.csv");
		   
		try {
			FileUtils.writeStringToFile(file, texto.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return texto.toString();		
	}
		 	
}