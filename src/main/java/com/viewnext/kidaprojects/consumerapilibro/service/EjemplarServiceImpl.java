package com.viewnext.kidaprojects.consumerapilibro.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;


import com.viewnext.kidaprojects.consumerapilibro.exception.NotFoundException;
import com.viewnext.kidaprojects.consumerapilibro.exception.WebCLientException;
import com.viewnext.kidaprojects.consumerapilibro.model.Ejemplar;

@Service
public class EjemplarServiceImpl implements EjemplarService {

	private final WebClient libroWebClient;

	public EjemplarServiceImpl(WebClient libroWebClient) {
		this.libroWebClient = libroWebClient;
	}

	@Override
	public ResponseEntity<?> mostrarEjemplares() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> mostrarEjemplaresPorTitulo(String titulo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> mostrarEjemplaresPorAutor(String autor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> mostrarEjemplarPorIsbn(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> crearEjemplar(Ejemplar ejemplar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> crearVariosEjemplares(List<Ejemplar> listaEjemplares) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> actualizarEjemplar(Ejemplar ejemplarParaActualizar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> borrarEjemplarPorIsbn(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
