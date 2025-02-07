package org.example.controller;

import org.example.enums.Prioridade;
import org.example.enums.Status;
import org.example.model.Tarefa;
import org.example.service.TarefaService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.Optional;
import java.util.Scanner;

public class TarrefaController {
    private static final TarefaService tarefaService = new TarefaService();


    public static void executar() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Criar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Exibir tarefa");
            System.out.println("4. Excluir Tarefa");
            System.out.println("5. Atualizar Tarefa");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    criarTarefa(scanner);
                    break;
                case 2:
                    listarTarefas();
                    break;
                case 3:
                    exibirTarefa(scanner);
                    break;
                case 4:
                    excluirTarefa(scanner);
                    break;
                case 5:
                    atualizarTarefa(scanner);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 6);
    }

    private static void criarTarefa(Scanner scanner) {
        System.out.println("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Data de Vencimento (DD-MM-AAAA): ");
        String dataVencimentoStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dataVencimento = LocalDate.parse(dataVencimentoStr, formatter);
        System.out.print("Status (PENDENTE, EM_ANDAMENTO, CONCLUIDA): ");
        Status status = Status.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Prioridade (BAIXA, MEDIA, ALTA): ");
        Prioridade prioridade = Prioridade.valueOf(scanner.nextLine().toUpperCase());

        Tarefa tarefa = new Tarefa(null, titulo, descricao, dataVencimento, status, prioridade);
        tarefaService.save(tarefa);
        System.out.println("Tarefa criada com sucesso.");
    }

    private static void listarTarefas() {
        tarefaService.findAll().forEach(tarefa -> System.out.println(tarefa));

    }

    private static void exibirTarefa(Scanner scanner) {
        System.out.print("Id da terefa que deseja exibir: ");
        Long id = scanner.nextLong();
        Optional<Tarefa> tarefaOptional = tarefaService.findById(id);
        tarefaOptional.ifPresent(tarefa -> System.out.println(tarefa));
    }


    private static void excluirTarefa(Scanner scanner) {
        System.out.print("ID da tarefa a ser excluída: ");
        Long id = scanner.nextLong();
        if (tarefaService.deleteById(id)) {
            System.out.println("Tarefa excluída com sucesso.");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

    private static void atualizarTarefa(Scanner scanner) {
        System.out.print("ID da Tarefa a ser atualizada: ");
        Long id = Long.parseLong(scanner.nextLine());
        Tarefa tarefaExistente = tarefaService.findById(id).orElse(null);
        if (tarefaExistente != null) {
            boolean continuar = true;
            while (continuar) {
                System.out.println("\nEscolha o atributo a ser atualizado:");
                System.out.println("[1] Título");
                System.out.println("[2] Descrição");
                System.out.println("[3] Status");
                System.out.println("[4] Prioridade");
                System.out.println("[5] Data de Vencimento");
                System.out.println("[6] Finalizar Edição");
                System.out.print("Opção: ");
                int opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        System.out.print("Novo Título: ");
                        String titulo = scanner.nextLine();
                        tarefaExistente.setTitulo(titulo);
                        break;
                    case 2:
                        System.out.print("Nova Descrição: ");
                        String descricao = scanner.nextLine();
                        tarefaExistente.setDescricao(descricao);
                        break;
                    case 3:
                        System.out.print("Novo Status (PENDENTE, EM_ANDAMENTO, CONCLUIDA): ");
                        Status status = Status.valueOf(scanner.nextLine().toUpperCase());
                        tarefaExistente.setStatusDeConclusao(status);
                        break;
                    case 4:
                        System.out.print("Nova Prioridade (BAIXA, MEDIA, ALTA): ");
                        Prioridade prioridade = Prioridade.valueOf(scanner.nextLine().toUpperCase());
                        tarefaExistente.setPrioridade(prioridade);
                        break;
                    case 5:
                        System.out.print("Nova Data de Vencimento (DD-MM-AAAA): ");
                        String dataVencimentoStr = scanner.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        LocalDate dataVencimento = LocalDate.parse(dataVencimentoStr, formatter);
                        tarefaExistente.setDataDeVencimento(dataVencimento);
                        break;
                    case 6:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
            tarefaService.update(id, tarefaExistente);
            System.out.println("Tarefa atualizada com sucesso.");
        } else {
            System.out.println("Tarefa não encontrada.");
        }
    }

}
