package org.generation.com.lojagame.repository;

import java.util.List;

import org.generation.com.lojagame.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
		public List<Categoria> findAllByPlataformaContainingIgnoreCase(String plataforma);
	
}
