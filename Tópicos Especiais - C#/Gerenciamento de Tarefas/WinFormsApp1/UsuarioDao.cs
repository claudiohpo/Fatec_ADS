using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WinFormsApp1
{
    internal class UsuarioDao : IDao<Usuario>
    {

        public void Alterar(Usuario obj)
        {
            throw new NotImplementedException();
        }

        public Usuario? BuscarPorId(int id)
        {
            throw new NotImplementedException();
        }

        public IEnumerable<Usuario> BuscarTodos()
        {
            throw new NotImplementedException();
        }

        public void Deletar(Usuario obj)
        {
            throw new NotImplementedException();
        }

        public void Inserir(Usuario usuario)
        {
            MySqlConnection conexao = new ConexaoFactory().getConexaoMySQL();
            StringBuilder sqlInsert = new StringBuilder();

            sqlInsert.Append("INSERT INTO ")
                .Append("usuarios ")
                .Append("(usu_nome, usu_cpf, usu_dtNasc, usu_telefone, usu_email, usu_senha) ")
                .Append("VALUES (")
                .Append("'" +usuario.Nome + "', ")
                .Append("'" + usuario.Cpf + "', ")
                .Append("'" + usuario.DataNasc + "', ")
                .Append("'" + usuario.Telefone + "', ")
                .Append("'" + usuario.Email + "', '")
                .Append(usuario.Senha + "'")
                .Append(");");
           
            MySqlCommand comando = new MySqlCommand(sqlInsert.ToString(), conexao);
            comando.ExecuteNonQuery();

            MessageBox.Show("Usuário cadastrado!");
            conexao.Close();
        }
    }
}
