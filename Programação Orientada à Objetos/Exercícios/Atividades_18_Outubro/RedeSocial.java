package Atividades_18_Outubro;

import java.util.ArrayList;
import java.util.List;

class Usuario {
    private String nome;
    private List<Usuario> amigos;
    private List<Post> posts;

    public Usuario(String nome) {
        this.nome = nome;
        this.amigos = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarAmigo(Usuario amigo) {
        amigos.add(amigo);
        amigo.amigos.add(this);
    }

    public void publicarPost(String mensagem) {
        Post post = new Post(this, mensagem);
        posts.add(post);
    }

    public void comentarPost(Post post, String comentario) {
        post.adicionarComentario(new Comentario(this, comentario));
    }

    public List<Post> getPosts() {
        return posts;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    public void exibirInformacoes() {
        System.out.println("Usuário: " + nome);
        System.out.println("Amigos: " + amigos.size());
        System.out.println("Posts:");
        for (Post post : posts) {
            System.out.println(" - " + post.getMensagem());
        }
    }
}

class Post {
    private Usuario autor;
    private String mensagem;
    private List<Comentario> comentarios;

    public Post(Usuario autor, String mensagem) {
        this.autor = autor;
        this.mensagem = mensagem;
        this.comentarios = new ArrayList<>();
    }

    public String getMensagem() {
        return mensagem;
    }

    public void adicionarComentario(Comentario comentario) {
        comentarios.add(comentario);
    }
}

class Comentario {
    private Usuario autor;
    private String mensagem;

    public Comentario(Usuario autor, String mensagem) {
        this.autor = autor;
        this.mensagem = mensagem;
    }
}

public class RedeSocial {
    private List<Usuario> usuarios;

    public RedeSocial() {
        this.usuarios = new ArrayList<>();
    }

    public void adicionarUsuario(String nome) {
        usuarios.add(new Usuario(nome));
    }

    public Usuario buscarUsuario(String nome) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nome)) {
                return usuario;
            }
        }
        return null;
    }

    public void exibirUsuarios() {
        for (Usuario usuario : usuarios) {
            usuario.exibirInformacoes();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RedeSocial redeSocial = new RedeSocial();
        redeSocial.adicionarUsuario("Alice");
        redeSocial.adicionarUsuario("Bob");
        redeSocial.adicionarUsuario("Charlie");

        Usuario alice = redeSocial.buscarUsuario("Alice");
        Usuario bob = redeSocial.buscarUsuario("Bob");
        Usuario charlie = redeSocial.buscarUsuario("Charlie");

        alice.adicionarAmigo(bob);
        alice.publicarPost("Olá, estou na rede social!");
        bob.publicarPost("Oi, Alice!");
        charlie.publicarPost("Oi, pessoal!");

        alice.comentarPost(bob.getPosts().get(0), "Que legal, Bob!");

        redeSocial.exibirUsuarios();
    }
}