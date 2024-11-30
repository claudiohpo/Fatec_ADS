CREATE DATABASE TrapoLimpo;
USE TrapoLimpo;

CREATE TABLE endereco (
    end_id INT AUTO_INCREMENT NOT NULL, -- AUTO_INCREMENT para gerar IDs automaticamente
    end_bairro VARCHAR(50) NOT NULL, -- Nome do bairro
    end_cidade VARCHAR(50) NOT NULL, -- Nome da cidade
    end_cep VARCHAR(9) NOT NULL, -- CEP (formato: XXXXX-XXX)
    PRIMARY KEY (end_id) -- Definição da chave primária
);

CREATE TABLE cliente (
    cli_id INT AUTO_INCREMENT NOT NULL, -- AUTO_INCREMENT para gerar IDs automaticamente
    cli_nome_completo VARCHAR(100) NOT NULL, -- Nome completo do cliente
    cli_numero_whatsapp VARCHAR(15) NOT NULL, -- Número de WhatsApp no formato internacional
    cli_end_id INT NOT NULL, -- Chave estrangeira para a tabela endereco
    PRIMARY KEY (cli_id), -- Definição da chave primária
    FOREIGN KEY (cli_end_id) REFERENCES endereco (end_id) -- Restrição de chave estrangeira
);


CREATE TABLE operacao (
    opr_id INT AUTO_INCREMENT NOT NULL, -- AUTO_INCREMENT para gerar IDs automaticamente
    opr_dt_entrada DATE NOT NULL, -- Data de entrada da operação
    opr_dt_entrega DATE DEFAULT NULL, -- Data de entrega da operação, opcional (NULL)
    opr_qtd_pecas INT NOT NULL, -- Quantidade de peças na operação
    opr_valor_total DECIMAL(7,2) NOT NULL, -- Valor total da operação (7 dígitos, 2 decimais)
    opr_cli_id INT NOT NULL, -- Chave estrangeira para a tabela cliente
    PRIMARY KEY (opr_id), -- Definição da chave primária
    FOREIGN KEY (opr_cli_id) REFERENCES cliente (cli_id) -- Restrição de chave estrangeira
);