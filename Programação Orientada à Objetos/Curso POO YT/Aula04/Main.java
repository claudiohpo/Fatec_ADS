package Aula04;

public class Main {
    public static void main(String[] args) {

        //Caneta c1 = new Caneta();
        Caneta c1 = new Caneta("Pilot","Amarela", 0.8f); //Utilizando método construtor
        //c1.setModelo("Bic"); //Utilizado o método de acesso
        //c1.modelo = "BIC"; //Acessou diretamente o atributo (Variavel tem que estar pública)

        //c1.setPonta(0.5f);
        //c1.ponta = 0.5f;

        c1.status();
       // System.out.println("Tenho uma cante " + c1.getModelo() + " de ponta " + c1.getPonta()); //getModelo e getPonta protegem o acesso, as chamadas passam pelo getter
    }
}

