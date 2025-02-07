package org.example.repository;

import org.example.model.Tarefa;

import java.util.List;
import java.util.Optional;

public interface TarefaRepository {
    Tarefa save(Tarefa tarefa);
    Optional<Tarefa> findById(Long id);
    List<Tarefa> findAll();
    boolean deleteById(Long id);
    Tarefa update(Long id,Tarefa tarefa);
}
