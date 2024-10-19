# Engenharia de Software III

* Criar diagrama de classes e codifica-las

## - Sistema

Modelar o diagrama de classes e implementa-las em Java ou C#, considerando a especificação abaixo:

* O sistema deve possibilitar a venda de produtos, tal transação deve ser iniciada a partir da tela de consulta de produtos, após a seleção de todos os produtos desejados, o usuário deve informar o endereço (cidade, estado e cep) de entrega, a forma de pagamento e se deseja incluir extensão de garantia para algum produtos.

* Antes de efetuar a transação o sistema deve calcular os seguintes impostos: COFINS e ICMS. O sistema deve validar a disponibilidade dos produtos em estoque e caso exista a disponibilidade deve-se dar baixa no estoque de cada produtos vendido.

* Deve ser feito o cálculo de comissão da venda para que tal comissão seja persistida, a comissão dos produtos com extensão de garantia é variada com base na categoria do produtos.

* Toda transação deve ser persistida com dados de auditória (usuário responsável, data e hora da transação, id do cliente, meio de pagamento e produtos);

* Um cliente mal classificado deve ter a transação não efetivada;

* Para cada produtos com extensão de garantia, 1% do valor deste serviço deve ser revertido em créditos para compras futuras;

* Deve-se realizar o cálculo do frete com base no endereço de entrega e no tipo do frete selecionado pelo usuário.