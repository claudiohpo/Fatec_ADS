package Aula_01_11_2024;

//import br.com.meubuscadordecep.dominio.Endereco;
//import br.com.meubuscadordecep.viacep.ServicoDeCep;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.print("Informe seu CEP: ");
        String cep = new Scanner(System.in).nextLine();
        Endereco endereco = ServicoDeCep.buscaEnderecoPelo(cep);

        System.out.println("Logradouro: " + endereco.getLogradouro());
        System.out.println("Bairro: " + endereco.getBairro());
        System.out.println("Localidade: " + endereco.getLocalidade());
    }

}