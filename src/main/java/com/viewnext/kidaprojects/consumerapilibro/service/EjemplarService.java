package com.viewnext.kidaprojects.consumerapilibro.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.viewnext.kidaprojects.consumerapilibro.model.Ejemplar;

public interface EjemplarService {

	public ResponseEntity<?> mostrarEjemplares();
	
	public ResponseEntity<?> mostrarEjemplaresPorTitulo(String titulo);
	
	public ResponseEntity<?> mostrarEjemplaresPorAutor(String autor);
	
	public ResponseEntity<?> mostrarEjemplarPorIsbn(String isbn);
	
	public ResponseEntity<?> crearEjemplar(Ejemplar ejemplar);
	
	public ResponseEntity<?> crearVariosEjemplares(List<Ejemplar> listaEjemplares);
	
	public ResponseEntity<?> actualizarEjemplar (Ejemplar ejemplarParaActualizar);
	
	public ResponseEntity<?> borrarEjemplarPorIsbn(String isbn);
	
	
}
