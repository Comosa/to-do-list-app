package com.todo.lista;

public record ListaVer( Long id,String titulo,String descripcion, String fecha_creacion,
		String fecha_estimada_de_terminacion,String finalizada,String estado) {
	
	public ListaVer(Lista lista) {
		this(lista.getId(),lista.getTitulo(),lista.getDescripcion(),lista.getFecha_creacion(),
				lista.getFecha_terminacion(),lista.getFinalizada(),lista.getEstado());
	}
	
}
