package Polimorfismo;

import java.util.Scanner;

public class Veiculos {
    private String modelo;
    private double preco;

    public Veiculos() {
        this("Nenhum", 0.0);
    }

    public Veiculos(String modelo, double preco) {
        this.modelo = modelo;
        this.preco = preco;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return "Veículo: ";
    }

    public String getDetalhes() {
        return "Modelo: " + getModelo() + "\n";
    }

    public void printDados() {
        System.out.printf("%s\n%sPreço: R$ %.2f\n", getTipo(), getDetalhes(), preco);
    }

    public void inserirDados() {
        Scanner in = new Scanner(System.in);
        System.out.printf("\nInforme o modelo: ");
        String modelo = in.nextLine();
        System.out.printf("\nInforme o preço: ");
        double preco = in.nextDouble();
        setModelo(modelo);
        setPreco(preco);
    }
}