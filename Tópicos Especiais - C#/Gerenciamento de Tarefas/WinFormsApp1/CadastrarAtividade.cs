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
    public partial class CadastrarAtividade : Form
    {
        private Usuario user;

        public CadastrarAtividade()
        {
            InitializeComponent();
        }

        public CadastrarAtividade(Usuario user)
        {
            this.user = user;
            InitializeComponent();
        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void label6_Click(object sender, EventArgs e)
        {

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void dateTimePicker3_ValueChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
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
                    StringBuilder sqlSelect = new StringBuilder();

                    sqlSelect.Append("SELECT ")
                        .Append("atv_nome ")
                        .Append("FROM atividades ")
                        .Append("WHERE atv_nome=@nome AND atv_usu_id=@id")
                        .Append(";");

                    MySqlCommand comando = new MySqlCommand(sqlSelect.ToString(), (MySqlConnection)conexao);
                    comando.Parameters.AddWithValue("@nome", txbNome.Text);
                    comando.Parameters.AddWithValue("@id", user.Id);
                    MySqlDataReader reader = (MySqlDataReader)comando.ExecuteReader();


                    if (!reader.Read())
                    {
                        Atividade atividade = new Atividade(txbNome.Text, txbTema.Text, txbDesc.Text, dtpAtribuicao.Text, dtpSubmissao.Text, dtpEntrega.Text, user);
                        IDao<Atividade> _dao = new AtividadeDao();
                        _dao.Inserir(atividade);
                        limpar();
                    }
                    else
                    {
                        MessageBox.Show("Já há outra atividade com este nome!");
                        txbNome.Focus();
                    }
                }
                else
                {
                    MessageBox.Show("As datas estão incompativeis");
                }

            }

        }

        private void limpar()
        {
            txbNome.Clear();
            txbTema.Clear();
            txbDesc.Clear();
            dtpAtribuicao.ResetText();
            dtpSubmissao.ResetText();
            dtpEntrega.ResetText();
        }
    }
}
