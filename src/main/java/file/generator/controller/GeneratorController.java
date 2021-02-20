package file.generator.controller;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import file.generator.service.GeneratorService;


/**
 * A Spring {@link RestController} used to showcase the modeling of a REST controller for CRUD operations
 *
 * @author Odilio Noronha Filho
 */
@RestController
@RequestMapping(
        path = "/generator"
)

public class GeneratorController {

	@Autowired
	GeneratorService service;
	
    /**
     * @return string!
     */
    @GetMapping()
    public String generate() {
        return service.generateFile();
    }

    @GetMapping("/index")
    public String index(Locale locale) {
        return "";
    }
   
  
}