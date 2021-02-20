package file.generator;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class StarterApplication {

		  public static void main(String[] args) {
		    	new SpringApplicationBuilder(StarterApplication.class)
		        .profiles("dev")
		        .run(args);
		    }
	}

