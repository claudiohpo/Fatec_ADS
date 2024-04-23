using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinFormsApp1
{
    public partial class AlterarAtividade : Form
    {
        private Usuario user;
        private string entrega;

        public AlterarAtividade(Usuario user)
        {
            this.user = user;
            InitializeComponent();
        }

        private void btnAlterar_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(txbNome.Text))
            {
                MessageBox.Show("por favor, digite um titulo");
            }
            else
            {
                if (DateTime.Compare(Convert.ToDateTime(dtpAtribuicao.Text), Convert.ToDateTime(dtpEntrega.Text)) < 0)
                {
                    IDbConnection conexao = new ConexaoFactory().getConexaoMySQL();
                    StringBuilder sqlInsert = new StringBuilder();

                    sqlInsert.Append("UPDATE ")
                            .Append("atividades ")
                            .Append("SET ")
                            .Append("atv_nome=@nome, atv_tema=@tema, atv_desc=@descricao, ")
                            .Append("atv_dtAtrib=@atribuicao, atv_dtSub=@submissao, ")
                            .Append("atv_dtEnt = @entrega ")
                            .Append("WHERE atv_nome = @codigo AND atv_usu_id=@id;");

                    MySqlCommand cmd = new MySqlCommand(sqlInsert.ToString(), (MySqlConnection)conexao);
                    cmd.Parameters.AddWithValue("@codigo", txbCodigo.Text);
                    cmd.Parameters.AddWithValue("@id", user.Id);
                    cmd.Parameters.AddWithValue("@nome", txbNome.Text);
                    cmd.Parameters.AddWithValue("@tema", txbTema.Text);
                    cmd.Parameters.AddWithValue("@descricao", txbDesc.Text);
                    cmd.Parameters.AddWithValue("@atribuicao", dtpAtribuicao.Text);
                    //cmd.Parameters.AddWithValue("@submissao", dtpSubmissao.Text);
                    cmd.Parameters.AddWithValue("@submissao", entrega);
                    cmd.Parameters.AddWithValue("@entrega", dtpEntrega.Text);

                    cmd.ExecuteNonQuery();

                    MessageBox.Show("Atividade Atualizada!");
                    conexao.Close();
                }
                else
                {

                    MessageBox.Show("As datas estão incompativeis");
                }

            }

        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            IDbConnection conexao = new ConexaoFactory().getConexaoMySQL();
            StringBuilder sqlSelect = new StringBuilder();

            sqlSelect.Append("SELECT ")
                .Append("atv_nome ")
                .Append("FROM atividades ")
                .Append("WHERE atv_nome=@nome AND atv_usu_id=@id")
                .Append(";");

            MySqlCommand comando = new MySqlCommand(sqlSelect.ToString(), (MySqlConnection)conexao);
            comando.Parameters.AddWithValue("@nome", txbCodigo.Text);
            comando.Parameters.AddWithValue("@id", user.Id);
            MySqlDataReader reader = (MySqlDataReader)comando.ExecuteReader();

            if (!reader.Read())
            {
                MessageBox.Show("Atividade não existe.");
                txbCodigo.Focus();
            }
            else
            {
                panel1.Visible = true;
            }


        }

        private void label6_Click(object sender, EventArgs e)
        {

        }

        private void btnEntregar_Click(object sender, EventArgs e)
        {
            DateTime dataAtual = DateTime.Now;
            entrega = dataAtual.ToString("dd/MM/yyyy");
        }
    }
}
