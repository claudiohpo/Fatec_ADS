using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Common;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MySql.Data.MySqlClient;

namespace WinFormsApp1
{
    public partial class Login : Form
    {

        Menu menu;
        CadastroUsuario usuario = new CadastroUsuario();
        public Login()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        { }
        private void btnCadastrar_Click(object sender, EventArgs e)
        {
            usuario.Show();
        }

        private void button2_Click(object sender, EventArgs e)
        { }

        private void btnLogin_Click(object sender, EventArgs e)
        {

            if (string.IsNullOrEmpty(txbLogin.Text) || string.IsNullOrEmpty((txbSenha.Text)))
            {
                MessageBox.Show("É necessário digitar login e senha!");
            }
            else
            {
                IDbConnection conexao = new ConexaoFactory().getConexaoMySQL();
                StringBuilder sqlSelect = new StringBuilder();

                sqlSelect.Append("SELECT ")
                    .Append("usu_email, usu_senha, usu_id ")
                    .Append("FROM usuarios ")
                    .Append("WHERE usu_email=@email")
                    .Append(";");

                MySqlCommand comando = new MySqlCommand(sqlSelect.ToString(), (MySqlConnection)conexao);
                comando.Parameters.AddWithValue("@email", txbLogin.Text);
                MySqlDataReader reader = (MySqlDataReader)comando.ExecuteReader();

                if (!reader.Read())
                {
                    MessageBox.Show("E-mail está incorreto.");
                    txbLogin.Focus();
                }
                else if (reader[1].Equals(txbSenha.Text))
                {
                    Usuario user = new Usuario(reader[2].ToString(), reader[0].ToString());
                    menu = new Menu(user);
                    menu.Show();
                    //Esconde o form de login/senha
                    this.Hide();
                }
                else
                {
                    MessageBox.Show("Senha está incorreta.");
                    txbSenha.Focus();
                }
            }
        }
    }
}
