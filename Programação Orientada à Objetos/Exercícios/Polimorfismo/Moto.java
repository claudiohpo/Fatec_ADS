package Polimorfismo;

import java.util.Scanner;

public class Moto extends Veiculos {
    private int ano;

    public Moto() {
        this("", 0.0, 0);
    }

    public Moto(String modelo, double preco, int ano) {
        super(modelo, preco);
        setAno(ano);
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = (ano >= 0) ? ano : 0;
    }

    @Override
    public String getTipo() {
        return "*** Moto *** ";
    }

    @Override
    public String getDetalhes() {
        return super.getDetalhes() + "Ano: " + getAno() + "\n";
    }

    @Override
    public void inserirDados() {
        super.inserirDados();
        Scanner in = new Scanner(System.in);
        System.out.printf("\nInforme o ano do veículo: ");
        int ano = in.nextInt();
        setAno(ano);
    }

    @Override
    public double getPreco() {
        double preco = super.getPreco();
        if (getAno() >= 2008) {
            return preco * 1.10;
        }
        return preco;
    }
}