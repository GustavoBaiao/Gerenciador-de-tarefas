# Gerenciador de tarefas
Este projeto é um sistema de gerenciamento de tarefas desenvolvido em Java, permitindo a criação, leitura, atualização e exclusão de tarefas por meio de uma interface de linha de comando.

Funcionalidades principais:

    Criar Tarefa: Adicionar uma nova tarefa com título, descrição, data de vencimento, status e prioridade.
    Listar Tarefas: Exibir todas as tarefas cadastradas.
    Exibir Tarefa: Visualizar detalhes de uma tarefa específica.
    Excluir Tarefa: Remover uma tarefa existente.
    Atualizar Tarefa: Modificar informações de uma tarefa existente.

Estrutura do projeto:

    Model: Contém a classe Tarefa, representando a entidade de tarefa com atributos como id, título, descrição, data de vencimento, status e prioridade.
    Enums: Define os enumeradores Status e Prioridade para os status e prioridades das tarefas.
    Repository: Interface TarefaRepository que define os métodos para operações CRUD (Create, Read, Update, Delete) em tarefas.
    Service: Implementação da interface TarefaRepository na classe TarefaService, utilizando um HashMap para armazenar as tarefas em memória.
    Controller: Classe TarrefaController que gerencia a interação com o usuário por meio de um menu de opções no console.
    Main: Classe TarefaApp que inicia a aplicação chamando o método executar do controlador.

Como executar:

    Compile o projeto utilizando um ambiente de desenvolvimento Java.
    Execute a classe TarefaApp.
    Interaja com o menu de opções para gerenciar as tarefas.

Exemplo de uso:

Ao iniciar a aplicação, o usuário verá um menu com as seguintes opções:
Menu:
1. Criar Tarefa
2. Listar Tarefas
3. Exibir tarefa
4. Excluir Tarefa
5. Atualizar Tarefa
6. Sair
Escolha uma opção: 


O usuário pode selecionar a opção desejada digitando o número correspondente.

Observações:

    Este projeto utiliza a enumeração Status para definir o status da tarefa (PENDENTE, EM_ANDAMENTO, CONCLUIDA) e Prioridade para definir a prioridade da tarefa (BAIXA, MEDIA, ALTA).
    As tarefas são armazenadas em memória e não são persistidas após o término da execução da aplicação.