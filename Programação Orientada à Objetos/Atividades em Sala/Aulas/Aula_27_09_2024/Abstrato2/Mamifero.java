package Aula_27_09_2024.Abstrato2;

public abstract class Mamifero extends Animal {

    public abstract String mamar();

    @Override

    public String mover() {

        return "Saindo do lugar";

    }

}
