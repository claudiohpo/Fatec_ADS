package Tamagotchi;

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
        this.idade = idade;
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

    @Override
    public String toString() {
        return "Classe: " + classe + "  |  Família: " + familia +
                "\nNome: " + nome + "  |  Idade: " + idade +
                "\nCaloria: " + caloria + "  |  Força: " + forca + "  |  Estado: " +
                (estado ? "Vivo" : "Morto");
    }

    public String nasceu() {
        return "Seu bichinho " + nome + " é da classe " +
                classe + " da família " + familia +
                ". \nO animal possui força de " + forca +
                ", caloria de " + caloria + " e " + idade +
                " anos.";
    }

    public boolean isVivo() {
        return estado;
    }

    public String morrer() {
        forca = 0;
        estado = false;
//        String estadoAtual = toString();
//        System.out.println();
//        System.out.println(estadoAtual);
//        //System.exit(0);
        return "Seu bichinho morreu! :(\n"; // Poderia retornar uma mensagem, se necessário
    }

    public String comer() {
        if (!estado) {
            return morrer();
        }

        if (caloria < 100) {
            caloria += 10;
            forca -= 2;
            if (forca <= 0) {
                forca = 0;
                return morrer();
            }
        } else {
            return nome + " está cheio! Não pode comer mais no momento!";
        }
        return "Seu bichinho comeu! \nSua força atual é de " + forca + " e suas calorias valem " + caloria;
    }

    public String correr() {
        if (!estado) {
            return morrer();
        }
        if (caloria > 0) {
            caloria -= 5;
            forca -= 5;
            if (forca <= 0) {
                forca = 0;
                return morrer();
            }
        } else {
            return nome + " está exausto! Não pode correr mais no momento!";
        }
        return "Seu bichinho está correndo! \nSua força atual é de " + forca + " e suas calorias valem " + caloria;
    }

    public String dormir() {
        if (!estado) {
            return morrer();
        } else {
            if (forca >= 100) {
                forca = 100;
                return "Seu bichinho já está com a força no máximo!";
            } else {
                caloria -= 2;
                forca += 10;
                if (caloria < 0) {
                    caloria = 0;
                }
            }
        }
        return "Seu bichinho está dormindo! \nSua força atual é de " + forca + " e suas calorias valem " + caloria;
    }

    public String status() {
        return toString();
    }
}
