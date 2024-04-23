using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WinFormsApp1
{
    public class AtividadeDao : IDao<Atividade>
    {
        public void Alterar(Atividade atividade)
        {
            IDbConnection conexao = new ConexaoFactory().getConexaoMySQL();
            StringBuilder sqlUpdate = new StringBuilder();

            sqlUpdate.Append("UPDATE ")
                .Append("atividades ")
                .Append("SET ")
                .Append("atv_nome=?, atv_tema=?, atv_desc=?, atv_dtAtrib=?, atv_dtSub=?, atv_dtEnt=? ")
                .Append(atividade.Nome)
                .Append(atividade.Tema)
                .Append(atividade.Descricao)
                .Append(atividade.DataAtribuicao)
                .Append(atividade.DataSubmissao)
                .Append(atividade.DataEntrega)
                .Append("WHERE atv_id=? ")
                .Append(atividade.Id)
                .Append(";");

        }

        public Atividade? BuscarPorId(int id)
        {
            /*IDbConnection conexao = new ConexaoFactory().getConexaoMySQL();
            StringBuilder sqlInsert = new StringBuilder();
            sqlInsert.Append("SELECT ")
                     .Append("atividades ")
                     .Append("WHERE atv_id=? ")
                     .Append(id)
                     .Append(";");
            IDbCommand cmd = new MySqlCommand(sqlInsert.ToString(), (MySqlConnection)conexao);
            cmd.ExecuteNonQuery();

            MessageBox.Show("Atividade atualizada!");
            conexao.Close();*/

            throw new NotImplementedException();
        }

        public IEnumerable<Atividade> BuscarTodos()
        {
            throw new NotImplementedException();
        }

        public void Deletar(Atividade atividade)
        {
            IDbConnection conexao = new ConexaoFactory().getConexaoMySQL();
            StringBuilder sqlDelete = new StringBuilder();

            sqlDelete.Append("DELETE FROM ")
                .Append("atividades ")
                .Append("WHERE atv_nome = ?")
                .Append(atividade.Id)
                .Append(";");

            IDbCommand cmd = new MySqlCommand(sqlDelete.ToString(), (MySqlConnection)conexao);
            cmd.ExecuteNonQuery();

            MessageBox.Show("Atividade excluída!");
            conexao.Close();
        }

        public void Inserir(Atividade atividade)
        {
            IDbConnection conexao = new ConexaoFactory().getConexaoMySQL();
            StringBuilder sqlInsert = new StringBuilder();

            sqlInsert.Append("INSERT INTO ")
                     .Append("atividades ")
                     .Append("(atv_nome, atv_tema, atv_desc, atv_dtAtrib, atv_dtSub, atv_dtEnt, atv_usu_id) ")
                     .Append("VALUES (")
                     .Append("'" + atividade.Nome + "', ")
                     .Append("'" + atividade.Tema + "', ")
                     .Append("'" + atividade.Descricao + "', ")
                     .Append("'" + atividade.DataAtribuicao + "', ")
                     .Append("'" + atividade.DataSubmissao + "', ")
                     .Append("'" + atividade.DataEntrega + "', ")
                     .Append("'"+atividade.Usuario.Id+"'")
                     .Append(");");

            IDbCommand cmd = new MySqlCommand(sqlInsert.ToString(), (MySqlConnection)conexao);
            cmd.ExecuteNonQuery();

            MessageBox.Show("Atividade Cadastrada!");
            conexao.Close();
        }
        
    }
}
