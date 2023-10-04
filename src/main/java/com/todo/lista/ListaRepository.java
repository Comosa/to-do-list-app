package com.todo.lista;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaRepository extends JpaRepository<Lista,Long>{

	Lista getReferenceByEstado(Object object);

}
