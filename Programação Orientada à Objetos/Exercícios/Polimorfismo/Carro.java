package Polimorfismo;

import java.util.Scanner;

public class Carro extends Veiculos {
    private int km;

    public Carro() {
        this("", 0.0, 0);
    }

    public Carro(String modelo, double preco, int km) {
        super(modelo, preco);
        setKm(km);
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = (km >= 0) ? km : 0;
    }

    @Override
    public String getTipo() {
        return "*** Carro *** ";
    }

    @Override
    public String getDetalhes() {
        return super.getDetalhes() + "Km: " + getKm() + "\n";
    }

    @Override
    public void inserirDados() {
        super.inserirDados();
        Scanner in = new Scanner(System.in);
        System.out.printf("\nInforme a quilometragem: ");
        int km = in.nextInt();
        setKm(km);
    }

    @Override
    public double getPreco() {
        double precoOriginal = super.getPreco();
        if (getKm() > 100000) {
            return precoOriginal * 0.92;
        }
        return precoOriginal;
    }
}