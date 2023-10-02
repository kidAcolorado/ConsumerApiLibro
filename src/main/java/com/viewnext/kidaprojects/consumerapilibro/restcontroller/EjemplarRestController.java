package com.viewnext.kidaprojects.consumerapilibro.restcontroller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.viewnext.kidaprojects.consumerapilibro.model.Ejemplar;
import com.viewnext.kidaprojects.consumerapilibro.service.EjemplarService;

@RestController
public class EjemplarRestController {

	private final EjemplarService service;

	public EjemplarRestController(EjemplarService service) {
		this.service = service;
	}

	@GetMapping(value = "ejemplar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> mostrarEjemplares() {
		ResponseEntity<?> response = service.mostrarEjemplares();

		if (response.getStatusCode() == HttpStatus.OK) {
			return ResponseEntity.ok(response);

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR");
		}

	}

	@GetMapping(value = "ejemplar/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> mostrarEjemplarPorIsbn(@PathVariable("isbn") String isbn) {
		ResponseEntity<?> response = service.mostrarEjemplarPorIsbn(isbn);

		if (response.getStatusCode() == HttpStatus.OK) {
			return ResponseEntity.ok(response);

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR");
		}

	}

	@GetMapping(value = "ejemplar/titulo/{titulo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> mostrarEjemplarPorTitulo(@PathVariable("titulo") String titulo) {
		ResponseEntity<?> response = service.mostrarEjemplaresPorTitulo(titulo);

		if (response.getStatusCode() == HttpStatus.OK) {
			return ResponseEntity.ok(response);

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR");
		}
	}

	@GetMapping(value = "ejemplar/autor/{autor}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> mostrarEjemplarPorAutor(@PathVariable("autor") String autor) {
		ResponseEntity<?> response = service.mostrarEjemplaresPorAutor(autor);

		if (response.getStatusCode() == HttpStatus.OK) {
			return ResponseEntity.ok(response);

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR");
		}
	}
	
	@PostMapping(value = "ejemplar", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createEjemplar(@RequestBody Ejemplar ejemplar) {
		ResponseEntity<?> response = service.crearEjemplar(ejemplar);

		if (response.getStatusCode() == HttpStatus.OK) {
			return ResponseEntity.ok(response);

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ERROR");
		}
	}
}