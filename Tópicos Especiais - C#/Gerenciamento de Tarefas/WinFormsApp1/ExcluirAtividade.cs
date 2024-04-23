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
    public partial class ExcluirAtividade : Form
    {
        ConexaoFactory conexao = new ConexaoFactory();
        Usuario user;

        public ExcluirAtividade(Usuario user)
        {
            user = user;
            InitializeComponent();
            this.user = user;
        }

        private void btnExcluir_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(txbExcluir.Text))
            {
                MessageBox.Show("Por favor, escolha um projeto para excluir!");
            }
            else
            {
                MySqlConnection conn = conexao.getConexaoMySQL();
                StringBuilder sqlDelete = new StringBuilder();

                sqlDelete.Append("DELETE FROM ")
                    .Append("atividades ")
                    .Append("WHERE atv_nome=@nome AND atv_usu_id=@id")
                    .Append(";");

                MySqlCommand comando = new MySqlCommand(sqlDelete.ToString(), conn);

                comando.Parameters.AddWithValue("@nome", txbExcluir.Text);
                comando.Parameters.AddWithValue("@id", user.Id);
                comando.ExecuteNonQuery();

                MessageBox.Show("Atividade excluída!");
                txbExcluir.Clear();
                conn.Close();
            }

        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvDados.Visible = true;

            IDbConnection conn = conexao.getConexaoMySQL();

            StringBuilder sqlSelect = new StringBuilder();
            sqlSelect.Append("SELECT ")
                .Append("atv_nome, atv_tema, atv_desc, atv_dtAtrib, atv_dtSub, atv_dtEnt ")
                .Append("FROM atividades ")
                .Append("WHERE atv_usu_id=@id;");

            using (MySqlCommand comando = new MySqlCommand(sqlSelect.ToString(), (MySqlConnection)conn))
            {
                comando.Parameters.AddWithValue("@id", user.Id);
                DataTable dt = new DataTable();
                using (MySqlDataAdapter adaptador = new MySqlDataAdapter(comando))
                {
                    adaptador.Fill(dt);
                }
                dgvDados.DataSource = dt;
            }

            panel1.Visible = true;
        }

        private void dgvDados_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }
    }
}
