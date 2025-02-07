package org.example.service;

import org.example.model.Tarefa;
import org.example.repository.TarefaRepository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class TarefaService implements TarefaRepository {
    private Map<Long, Tarefa> tarefas = new HashMap<>();
    private AtomicLong idGenerator = new AtomicLong(1);


    @Override
    public Tarefa save(Tarefa tarefa) {
        if (tarefa.getId() == null) {
            tarefa.setId(idGenerator.getAndIncrement());
        }
        tarefas.put(tarefa.getId(), tarefa);
        return tarefa;
    }

    @Override
    public Optional<Tarefa> findById(Long id) {
        return Optional.ofNullable(tarefas.get(id));
    }


    @Override
    public List<Tarefa> findAll() {
        return new ArrayList<>(tarefas.values());
    }

    @Override
    public boolean deleteById(Long id) {
        return tarefas.remove(id) != null;
    }

    @Override
    public Tarefa update(Long id, Tarefa tarefaAtualizada) {
        Tarefa tarefaExistente = tarefas.get(id);
        if (tarefaExistente != null) {
            if (tarefaAtualizada.getTitulo() != null) {
                tarefaExistente.setTitulo(tarefaAtualizada.getTitulo());
            }
            if (tarefaAtualizada.getDescricao() != null) {
                tarefaExistente.setDescricao(tarefaAtualizada.getDescricao());
            }
            if (tarefaAtualizada.getStatusDeConclusao() != null) {
                tarefaExistente.setStatusDeConclusao(tarefaAtualizada.getStatusDeConclusao());
            }
            if (tarefaAtualizada.getPrioridade() != null) {
                tarefaExistente.setPrioridade(tarefaAtualizada.getPrioridade());
            }
            if (tarefaAtualizada.getDataDeVencimento() != null) {
                tarefaExistente.setDataDeVencimento(tarefaAtualizada.getDataDeVencimento());
            }
            return tarefaExistente;
        } else {
            return null; // Tarefa não encontrada
        }
    }
}
