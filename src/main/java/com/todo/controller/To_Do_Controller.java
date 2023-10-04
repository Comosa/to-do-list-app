package com.todo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.lista.Lista;
import com.todo.lista.ListaActualiar;
import com.todo.lista.ListaMostrar;
import com.todo.lista.ListaRegistrar;
import com.todo.lista.ListaRepository;
import com.todo.lista.ListaVer;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/list")
public class To_Do_Controller {

	@Autowired
	private ListaRepository listaRepository;
	
	@PostMapping
	public void lista(@RequestBody ListaRegistrar listaRegistrar) {
		listaRepository.save(new Lista(listaRegistrar));
	}
	@GetMapping
	public Page<ListaVer> mostrar(Pageable pageable){
		return listaRepository.findAll(pageable).map(ListaVer :: new);
	}
	@GetMapping("/{id}")
	public ResponseEntity<ListaMostrar> estado(@PathVariable Long id) {
		Lista lista = listaRepository.getReferenceById(id);
		var mostrar = new ListaMostrar(lista.getId(),lista.getTitulo(),
				lista.getDescripcion(),lista.getFecha_creacion(),
				lista.getFecha_terminacion(),lista.getEstado(),lista.getFinalizada());
		return ResponseEntity.ok(mostrar);
	}
	@PutMapping
	@Transactional
	public void Actualiar(@RequestBody ListaActualiar actualiar) {
		Lista lista = listaRepository.getReferenceById(actualiar.id());
		lista.ActualiarLista(actualiar);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void eliminar(@PathVariable Long id) {
		Lista lista = listaRepository.getReferenceById(id);
		listaRepository.delete(lista);
	}
	
}