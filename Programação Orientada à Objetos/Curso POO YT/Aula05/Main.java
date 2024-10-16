package Aula05;

public class Main {
    public static void main(String[] args) {

        ContaBanco pessoa1 = new ContaBanco();
        pessoa1.setConta(1206);
        pessoa1.setDono("Pedro");
        pessoa1.abrirConta("CC");

        ContaBanco pessoa2 = new ContaBanco();
        pessoa2.setConta(1207);
        pessoa2.setDono("Creuza");
        pessoa2.abrirConta("CP");

        pessoa1.depositar(100);
        pessoa2.depositar(500);

        pessoa2.sacar(100);

        pessoa1.fecharConta();

        pessoa2.sacar(550);
        pessoa2.fecharConta();

        pessoa1.estadoAtual();
        pessoa2.estadoAtual();
    }
}
