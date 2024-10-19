package Atividades_18_Outubro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class Feriado {
    private String nome;
    private LocalDate data;

    public Feriado(String nome, LocalDate data) {
        this.nome = nome;
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    public String getNome() {
        return nome;
    }
}

class Calendario {
    private List<Feriado> feriados;

    public Calendario() {
        feriados = new ArrayList<>();
        feriados.add(new Feriado("Ano Novo", LocalDate.of(2024, 1, 1)));
        feriados.add(new Feriado("Carnaval", LocalDate.of(2024, 2, 13)));
        feriados.add(new Feriado("Páscoa", LocalDate.of(2024, 3, 31)));
        feriados.add(new Feriado("Dia do Trabalho", LocalDate.of(2024, 5, 1)));
        feriados.add(new Feriado("Independência do Brasil", LocalDate.of(2024, 9, 7)));
        feriados.add(new Feriado("Natal", LocalDate.of(2024, 12, 25)));
    }

    public void exibirCalendarioMes(int ano, int mes) {
        LocalDate primeiroDia = LocalDate.of(ano, mes, 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("Calendário de %s %d%n", primeiroDia.getMonth(), ano);
        System.out.println("Dom Seg Ter Qua Qui Sex Sab");
        for (int i = 1; i < primeiroDia.getDayOfWeek().getValue(); i++) {
            System.out.print("    ");
        }
        for (int dia = 1; dia <= primeiroDia.lengthOfMonth(); dia++) {
            System.out.printf("%2d ", dia);
            if ((dia + primeiroDia.getDayOfWeek().getValue() - 1) % 7 == 6) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public boolean verificarFeriado(LocalDate data) {
        for (Feriado feriado : feriados) {
            if (feriado.getData().isEqual(data)) {
                return true;
            }
        }
        return false;
    }

    public long calcularDiferencaDias(LocalDate data1, LocalDate data2) {
        return Math.abs(data1.toEpochDay() - data2.toEpochDay());
    }

    public static void main(String[] args) {
        Calendario calendario = new Calendario();
        calendario.exibirCalendarioMes(2024, 1);
        LocalDate dataTeste = LocalDate.of(2024, 1, 1);
        System.out.println("É feriado: " + calendario.verificarFeriado(dataTeste));
        LocalDate data1 = LocalDate.of(2024, 1, 1);
        LocalDate data2 = LocalDate.of(2024, 5, 31);
        System.out.println("Diferença de dias: " + calendario.calcularDiferencaDias(data1, data2));
    }
}