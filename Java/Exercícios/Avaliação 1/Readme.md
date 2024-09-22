# Linguagem de Programação - JAVA

* Tarefa de nota 1 do SEMESTRE

## - Imposto de Renda

CRIAR UM PROGRAMA QUE VAI CALCULAR O QUANTO UM TRABALHADOR VAI PAGAR DE IMPOSTO DE RENDA, BASEADO EM SEU SALARIO, E NA TABELA DE ALIQUOTAS QUE VARIAM DE ACORDO COM O RENDIMENTO MENSAL DA PESSOA.
- 1º. Passo o programa vai mostrar qual faixa
* Faixa 1: Até R$ 2.259: isento.
* Faixa 2: De 2.259,01 até 2.826,66: 7,5%
* Faixa 3: De 2.826,67 até 3.751,06: 15%
* Faixa 4: De 3.751,07 até 4.664,68: 22,5%
* Faixa 5: Acima de R$ 4.664,68: 27,5%

- 2o. passo o programa vai CALCULAR o imposto devido, sem as amortizações de INSS.

Ex. uma pessoa recebe 2500 por mês.
Ela esta na faixa 2 ,  7,5% de IR.  7,5%* (2500,00 -2112,01)
7,5% 387,99 = 29,10.
Ex2. Uma pessoa recebe 3000 por mês
Ela está na faixa 3.
Calculo é faixa 2 + faixa3
Faixa 2 = (3000-2112)*7,5% = 66,6
Faixa 3 = (3000-2826,66)*15% = 26,00
TOTAL A PAGAR = 66,6 + 26,00 = 92,60

- Ao final de cada interação, o programa deverá exibir o nome da pessoa, o salario, a faixa de imposto, e o imposto a pagar.