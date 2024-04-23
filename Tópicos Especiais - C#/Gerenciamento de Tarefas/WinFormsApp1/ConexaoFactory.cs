using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace WinFormsApp1
{
    public class ConexaoFactory
    {
  
        private readonly string endereco = "server=localhost;database=atividades;uid=root;pwd='D@b@2020'";

        public ConexaoFactory()
        {
        }

        public MySqlConnection getConexaoMySQL()
        {
            MySqlConnection conexao = new MySqlConnection(endereco);
            
            conexao.Open();
            return conexao;
        }


    }
}
