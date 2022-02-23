package org.generation.com.lojagame.controller;

import org.generation.com.lojagame.model.Categoria;
import org.generation.com.lojagame.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loja")
@CrossOrigin("*")
public class CategoriaController
{
    @Autowired
    private CategoriaRepository repository;

    @GetMapping
    public ResponseEntity<List<Categoria>> findAllCategoria()
    {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findByIdCategoria(@PathVariable long id)
    {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/descricao/{descricao}")
    public ResponseEntity<List<Categoria>> findByDescricaoCategoria(@PathVariable String descricao)
    {
        return ResponseEntity.ok(repository.findAllByPlataformaContainingIgnoreCase(descricao));
    }

    @PostMapping
    public ResponseEntity<Categoria> postCategoria(@RequestBody Categoria categoria)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
    }

    @PutMapping
    public ResponseEntity<Categoria> putCategoria(@RequestBody Categoria categoria)
    {
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
    }

    @DeleteMapping("/{id}")
    public void deleteCategoria(@PathVariable long id)
    {
        repository.deleteById(id);
    }


}
