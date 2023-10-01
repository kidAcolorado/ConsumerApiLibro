package com.viewnext.kidaprojects.consumerapilibro.restcontroller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.viewnext.kidaprojects.consumerapilibro.service.EjemplarServiceImpl;

@RestController
public class EjemplarRestController {

	
	private final EjemplarServiceImpl service;
	
	public EjemplarRestController(EjemplarServiceImpl service) {
		this.service = service;
	}
	
	
	
	@GetMapping(value = "ejemplares", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> mostrarEjemplares() {
        
        return service.mostrarEjemplares();
    }
	
	@GetMapping(value = "ejemplar/{isbn}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> mostrarEjemplarPorIsbn(@PathVariable("isbn") String isbn) {
		ResponseEntity<?> response = service.mostrarEjemplarPorIsbn(isbn);
	    
	    if (response.getStatusCode() == HttpStatus.OK) {
	        return ResponseEntity.ok(response);
	        
	        
	    } else  {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR");
	    }
	    
	    
    }
	
	@GetMapping(value = "ejemplar/titulo/{titulo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> mostrarEjemplarPorTitulo(@PathVariable("titulo") String titulo) {
        
        return service.mostrarEjemplaresPorTitulo(titulo);
    }
	
	@GetMapping(value = "ejemplar/autor/{autor}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> mostrarEjemplarPorAutor(@PathVariable("autor") String autor) {
        
        return service.mostrarEjemplaresPorAutor(autor);
    }
	
	
	
}