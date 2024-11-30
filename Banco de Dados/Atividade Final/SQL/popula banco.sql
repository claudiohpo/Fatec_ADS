LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/CSV_TABELA_ENDERECO.csv'
INTO TABLE trapolimpo.endereco
FIELDS TERMINATED BY ',' -- Delimitador de campos
ENCLOSED BY '"' -- Caso haja aspas ao redor dos campos (não obrigatório)
LINES TERMINATED BY '\r\n' -- Quebra de linha padrão Windows
IGNORE 1 ROWS -- Ignorar o cabeçalho
(end_id, end_bairro, end_cidade, end_cep);

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/CSV_TABELA_CLIENTE.csv'
INTO TABLE trapolimpo.cliente
FIELDS TERMINATED BY ',' -- Delimitador de campos (vírgula)
ENCLOSED BY '"' -- Valores podem estar entre aspas duplas
LINES TERMINATED BY '\r\n' -- Quebra de linha padrão Windows
IGNORE 1 ROWS -- Ignorar o cabeçalho
(cli_id, cli_nome_completo, cli_numero_whatsapp, cli_end_id);

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/CSV_TABELA_OPERACO.csv'
INTO TABLE trapolimpo.operacao
FIELDS TERMINATED BY ',' -- Delimitador de campos
ENCLOSED BY '"' -- Se houver valores entre aspas, considere isso (não obrigatório no seu caso)
LINES TERMINATED BY '\r\n' -- Quebra de linha padrão Windows
IGNORE 1 ROWS -- Ignora o cabeçalho
(opr_cli_id, opr_id, opr_dt_entrada, opr_dt_entrega, opr_qtd_pecas, opr_valor_total);




