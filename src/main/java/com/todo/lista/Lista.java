package com.todo.lista;

import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
//import lombok.Setter;

@Table(name = "to_do")
@Entity(name = "Lista")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Lista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descripcion;
	private String Fecha_creacion;
	private String Fecha_terminacion;
	private String finalizada;
	private String estado;
	

	public Lista(ListaRegistrar listaRegistrar) {
		Date dia = new Date(); 
		
		this.titulo = listaRegistrar.titulo();
		this.descripcion = listaRegistrar.descripcion();
		this.Fecha_creacion =  new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(dia);
		this.Fecha_terminacion = listaRegistrar.fecha_estimada_de_terminacion();
	}
	public Lista() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFecha_creacion() {
		return Fecha_creacion;
	}
	public void setFecha_creacion(String fecha_creacion) {
		Fecha_creacion = fecha_creacion;
	}
	public String getFecha_terminacion() {
		return Fecha_terminacion;
	}
	public void setFecha_terminacion(String fecha_terminacion) {
		Fecha_terminacion = fecha_terminacion;
	}
	public String getFinalizada() {
		return finalizada;
	}
	public void setFinalizada(String finalizada) {
		this.finalizada = finalizada;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public void ActualiarLista(ListaActualiar actualiar) {
		if(actualiar.finalizada()!=null) {
			this.finalizada = actualiar.finalizada();
		}
		if (actualiar.estado()!=null) {
			this.estado = actualiar.estado();
		}
	}
}
