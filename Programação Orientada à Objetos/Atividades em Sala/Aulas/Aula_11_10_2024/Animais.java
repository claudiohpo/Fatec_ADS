package Aula_11_10_2024;

import java.util.Scanner;

public class Animais {
    private String nome;
    private String classe;
    private String familia;
    private int idade;
    private boolean estado;
    private int caloria;
    private int forca;


    public Animais(String nome, String classe, String familia, int idade, boolean estado, int caloria, int forca) {
        this.nome = nome;
        this.classe = classe;
        this.familia = familia;
        this.idade = idade ;
        this.estado = estado;
        this.caloria = caloria;
        this.forca = forca;
    }

    public Animais(String nome, String classe, String familia) {
        this.nome = nome;
        this.classe = classe;
        this.familia = familia;
        this.idade = 0; // Definindo a idade inicial como 0
        this.estado = true; // Animal nasce vivo
        this.caloria = 10; // Caloria inicial 10
        this.forca = 10; // Força inicial 10
    }

    public String getNome() {
        return nome;
    }

    public String getClasse() {
        return classe;
    }

    public String getFamilia() {
        return familia;
    }

    public int getIdade() {
        return idade;
    }

    public boolean isEstado() {
        return estado;
    }

    public int getCaloria() {
        return caloria;
    }

    public int getForca() {
        return forca;
    }

    public void nascer(){



        System.out.print(toString());
    }

    @Override
    public String toString() {
        return "Bichinho{" +
                "Nome: '" + nome + '\'' +
                ", Classe: '" + classe + '\'' +
                ", Família: '" + familia + '\'' +
                ", Idade: " + idade +
                ", Estado: " + estado +
                ", Caloria: " + caloria +
                ", Força: " + forca +
                '}';
    }

    public String nasceu(){
        System.out.println("O bichinho Nasceu!!!");
        return "Seu bichinho " + nome + " é da classe " + classe + " da família " + familia + ". O animal possui força de " + forca + ", caloria de " + caloria + " e " + idade + " anos.";
        //System.out.print(toString());
    }

    public String morrer(){
        forca = 0;
        estado = false;
        return "Seu bichinho morreu! :(";
    }

    public String comer(){
        if(estado && caloria < 100){
            caloria += 10;
            forca -= 2;
        }
        return "Seu bichinho comeu! Sua força atual é de " + forca + " e suas calorias valem " + caloria;
        //System.out.print(toString());
    }

    public String correr(){
        if(estado || caloria != 0){
            caloria -= 5;
            forca -= 5;
        }
        return "Seu bichinho esát correndo! Sua força atual é de " + forca + " e suas calorias valem " + caloria;
        //System.out.print(toString());
    }

    public String dormir(){
        if(estado){
            caloria -= 2;
            forca += 10;
        }
        return "Seu bichinho está dormindo! Sua força atual aumentou para " + forca + " e suas calorias aumentaram para " + caloria;
        //System.out.print(toString());
    }
}

