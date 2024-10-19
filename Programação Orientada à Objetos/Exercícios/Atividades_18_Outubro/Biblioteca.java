package Atividades_18_Outubro;

import java.util.ArrayList;
import java.util.List;

class Livro {
    private String titulo;
    private String autor;
    private boolean disponivel;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

class Biblioteca {
    private List<Livro> livros;

    public Biblioteca() {
        this.livros = new ArrayList<>();
    }

    public void cadastrarLivro(String titulo, String autor) {
        livros.add(new Livro(titulo, autor));
    }

    public void emprestarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo) && livro.isDisponivel()) {
                livro.setDisponivel(false);
                System.out.println("Empréstimo realizado: " + titulo);
                return;
            }
        }
        System.out.println("Livro não disponível: " + titulo);
    }

    public void devolverLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo) && !livro.isDisponivel()) {
                livro.setDisponivel(true);
                System.out.println("Devolução realizada: " + titulo);
                return;
            }
        }
        System.out.println("Livro não encontrado ou já está disponível: " + titulo);
    }

    public boolean verificarDisponibilidade(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro.isDisponivel();
            }
        }
        return false;
    }

    public void exibirLivros() {
        for (Livro livro : livros) {
            System.out.printf("Título: %s, Autor: %s, Disponível: %s%n", livro.getTitulo(), livro.getAutor(), livro.isDisponivel() ? "Sim" : "Não");
        }
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.cadastrarLivro("Dom Casmurro", "Machado de Assis");
        biblioteca.cadastrarLivro("1984", "George Orwell");
        biblioteca.cadastrarLivro("O Senhor dos Anéis", "J.R.R. Tolkien");

        biblioteca.exibirLivros();
        biblioteca.emprestarLivro("1984");
        biblioteca.emprestarLivro("Dom Casmurro");
        biblioteca.devolverLivro("1984");
        biblioteca.emprestarLivro("1984");

        System.out.println("Disponibilidade de 'O Senhor dos Anéis': " + (biblioteca.verificarDisponibilidade("O Senhor dos Anéis") ? "Disponível" : "Indisponível"));
        biblioteca.exibirLivros();
    }
}