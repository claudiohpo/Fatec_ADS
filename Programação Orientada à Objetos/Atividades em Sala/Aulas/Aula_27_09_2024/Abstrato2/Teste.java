package Aula_27_09_2024.Abstrato2;


public class Teste {

    public static void main(String[] args) {

        Mamifero a = new Cachorro();

        System.out.println(a.mover());

        System.out.println(a.mamar());

        System.out.println(a.respirar());

        //System.out.println((a.Piar));

    }

}

