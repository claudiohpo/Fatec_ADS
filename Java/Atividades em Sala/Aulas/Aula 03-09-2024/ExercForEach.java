package Aula0309;
//Programa ForEach modificado para que seja impresso os números ímpares da matriz
public class ExercForEach{
    public static void main(String[] arg)
    {
        {
            int[] pontos = { 200, 101, 102, 95, 106, 160 };
            int h_pontos = maximum(pontos);
            System.out.println("A melhor pontuação é " + h_pontos);
        }
    }
    public static int maximum(int[] numbers)
    {
        int pontMax = numbers[0];
 
        for (int num : numbers)
        {
        	if(num % 2 != 0) {
            	System.out.println("O número " + num + " é ímpar");
            }
        	
        	if (num > pontMax)
            {
                pontMax = num;
                
            }
        }
    return pontMax;
    }
}