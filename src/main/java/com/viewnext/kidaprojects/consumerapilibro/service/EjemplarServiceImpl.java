package com.viewnext.kidaprojects.consumerapilibro.service;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.viewnext.kidaprojects.consumerapilibro.model.Ejemplar;

@Service
public class EjemplarServiceImpl implements EjemplarService {

	private final WebClient libroWebClient;

	public EjemplarServiceImpl(WebClient libroWebClient) {
		this.libroWebClient = libroWebClient;
	}

	@Override
	public ResponseEntity<?> mostrarEjemplares() {
		
		try {
			ResponseEntity<List<Ejemplar>> response = libroWebClient.get()
					.uri("/libros")
			        .accept(MediaType.APPLICATION_JSON)
			        .retrieve()
			        .toEntityList(Ejemplar.class)
			        .block();
			
			
				return ResponseEntity.ok(response);
		
		} catch (WebClientResponseException  e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("LIBRO_NOT_FOUND");
            } else  {
                
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR");
            }
		}
		
		
		
	}

	@Override
	public ResponseEntity<?> mostrarEjemplaresPorTitulo(String titulo) {
		try {
			ResponseEntity<List<Ejemplar>> response = libroWebClient.get()
					.uri("/libros/titulo/{titulo}", titulo)
			        .accept(MediaType.APPLICATION_JSON)
			        .retrieve()
			        .toEntityList(Ejemplar.class)
			        .block();
			
			
			
			return ResponseEntity.ok(response);
		} catch (WebClientResponseException  e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("LIBRO_NOT_FOUND");
            } else  {
                
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR");
            }
		}
		
		

	}

	@Override
	public ResponseEntity<?> mostrarEjemplaresPorAutor(String autor) {
		try {
			ResponseEntity<List<Ejemplar>> response = libroWebClient.get()
					.uri("/libros/autor/{autor}", autor)
			        .accept(MediaType.APPLICATION_JSON)
			        .retrieve()
			        .toEntityList(Ejemplar.class)
			        .block();
			
			
			
			return ResponseEntity.ok(response);
		} catch (WebClientResponseException  e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("LIBRO_NOT_FOUND");
            } else  {
                
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR");
            }
		}
		
	}

	@Override
	public ResponseEntity<?> mostrarEjemplarPorIsbn(String isbn) {
		try {
			ResponseEntity<Ejemplar> response = libroWebClient.get()
					.uri("/libro/{isbn}", isbn)
			        .accept(MediaType.APPLICATION_JSON)
			        .retrieve()
			        .toEntity(Ejemplar.class)
			        .block();
			
			
			
			return ResponseEntity.ok(response);
		} catch (WebClientResponseException  e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("LIBRO_NOT_FOUND");
            } else  {
                
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR");
            }
		}
	}

	@Override
	public ResponseEntity<?> crearEjemplar(Ejemplar ejemplarParaCrear) {
		try {
			ResponseEntity<Ejemplar> response = libroWebClient.post()
					.uri("/libro")
			        .accept(MediaType.APPLICATION_JSON)
			        .body(ejemplarParaCrear, Ejemplar.class)
			        .retrieve()
			        .toEntity(Ejemplar.class)
			        .block();
			
			String isbn = response.getBody().getIsbn();
			URI location = URI.create("http://localhost:8080/libro/" + isbn);
			
			return ResponseEntity.created(location).build();
		} catch (WebClientResponseException  e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("LIBRO_NOT_FOUND");
            } else  {
                
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR");
            }
		}
	}

	@Override
	public ResponseEntity<?> crearVariosEjemplares(List<Ejemplar> listaEjemplares) {
		try {
			libroWebClient.post()
					.uri("/libros")
			        .accept(MediaType.APPLICATION_JSON)
			        .body(listaEjemplares, Ejemplar.class)
			        .retrieve()
			        .toEntityList(Ejemplar.class)
			        .block();
			
			URI location = URI.create("http://localhost:8080/libros"); //No sé si hay que devolver esta o la de ejemplar/{isbn}
			
			return ResponseEntity.created(location).build();
		} catch (WebClientResponseException  e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("LIBRO_NOT_FOUND");
            } else  {
                
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR");
            }
		}
	}

	@Override
	public ResponseEntity<?> actualizarEjemplar(Ejemplar ejemplarParaActualizar) {
		try {
			ResponseEntity<Ejemplar> response = libroWebClient.put()
					.uri("/libro")
			        .accept(MediaType.APPLICATION_JSON)
			        .body(ejemplarParaActualizar, Ejemplar.class)
			        .retrieve()
			        .toEntity(Ejemplar.class)
			        .block();
			
			
			return ResponseEntity.ok(response);
		} catch (WebClientResponseException  e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("LIBRO_NOT_FOUND");
            } else  {
                
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR");
            }
		}
	}

	@Override
	public ResponseEntity<?> borrarEjemplarPorIsbn(String isbn) {
		try {
			libroWebClient.delete()
					.uri("/libro/{isbn}", isbn)
					.retrieve()
					.toBodilessEntity()
					.block();
			
			return ResponseEntity.noContent().build();
		} catch (WebClientResponseException  e) {
			if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("LIBRO_NOT_FOUND");
            } else  {
                
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ERROR");
            }
		}
	}
	

	
}
