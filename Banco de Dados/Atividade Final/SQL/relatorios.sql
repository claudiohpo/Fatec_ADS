select	c.cli_nome_completo,
        count(o.opr_id) as qtd_idas,
    	sum(o.opr_valor_total) as montante,
    	avg(o.opr_qtd_pecas) as media_pecas
from trapolimpo.operacao o
inner join trapolimpo.cliente c    on c.cli_id = o.opr_cli_id
group by c.cli_id;

select	count(o.opr_id) as volume_operacao_ultimo_mes,
		sum(o.opr_qtd_pecas) as volume_pecas_ultimo_mes,
		sum(o.opr_valor_total) as montante_ultimo_mes
from trapolimpo.operacao o
where o.opr_dt_entrega like '%-10-%';

select  
    count(o.opr_id) AS volume_operacao_ultimo_mes,
    sum(o.opr_qtd_pecas) AS volume_pecas_ultimo_mes,
    sum(o.opr_valor_total) AS montante_ultimo_mes
from trapolimpo.operacao o
where o.opr_dt_entrega 
	between DATE_FORMAT(NOW() - interval 1 month, '%Y-%m-01') 
		and LAST_DAY(NOW() - interval 1 month);