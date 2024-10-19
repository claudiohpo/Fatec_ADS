package Atividades_18_Outubro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contato {
    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Telefone: " + telefone;
    }
}

public class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(String nome, String telefone) {
        Contato contato = new Contato(nome, telefone);
        contatos.add(contato);
        System.out.println("Contato adicionado com sucesso!");
    }

    public void editarContato(String nomeAntigo, String novoNome, String novoTelefone) {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nomeAntigo)) {
                c.setNome(novoNome);
                c.setTelefone(novoTelefone);
                System.out.println("Contato editado com sucesso!");
                return;
            }
        }
        System.out.println("Contato não encontrado.");
    }

    public void removerContato(String nome) {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                contatos.remove(c);
                System.out.println("Contato removido com sucesso!");
                return;
            }
        }
        System.out.println("Contato não encontrado.");
    }

    public void buscarContatoPorNome(String nome) {
        boolean encontrado = false;
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                System.out.println(c);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Contato não encontrado.");
        }
    }

    public void buscarContatoPorTelefone(String telefone) {
        boolean encontrado = false;
        for (Contato c : contatos) {
            if (c.getTelefone().equals(telefone)) {
                System.out.println(c);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Contato não encontrado.");
        }
    }

    public void exibirTodosContatos() {
        if (contatos.isEmpty()) {
            System.out.println("A agenda está vazia.");
        } else {
            System.out.println("Contatos na Agenda:");
            for (Contato c : contatos) {
                System.out.println(c);
            }
        }
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n*** Agendinha! ***");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Editar Contato");
            System.out.println("3. Remover Contato");
            System.out.println("4. Buscar Contato por Nome");
            System.out.println("5. Buscar Contato por Telefone");
            System.out.println("6. Exibir Todos os Contatos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o telefone: ");
                    String telefone = scanner.nextLine();
                    agenda.adicionarContato(nome, telefone);
                    break;
                case 2:
                    System.out.print("Digite o nome do contato a ser editado: ");
                    String nomeAntigo = scanner.nextLine();
                    System.out.print("Digite o novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Digite o novo telefone: ");
                    String novoTelefone = scanner.nextLine();
                    agenda.editarContato(nomeAntigo, novoNome, novoTelefone);
                    break;
                case 3:
                    System.out.print("Digite o nome do contato a ser removido: ");
                    String nomeRemover = scanner.nextLine();
                    agenda.removerContato(nomeRemover);
                    break;
                case 4:
                    System.out.print("Digite o nome do contato a ser buscado: ");
                    String nomeBusca = scanner.nextLine();
                    agenda.buscarContatoPorNome(nomeBusca);
                    break;
                case 5:
                    System.out.print("Digite o telefone do contato a ser buscado: ");
                    String telefoneBusca = scanner.nextLine();
                    agenda.buscarContatoPorTelefone(telefoneBusca);
                    break;
                case 6:
                    agenda.exibirTodosContatos();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}