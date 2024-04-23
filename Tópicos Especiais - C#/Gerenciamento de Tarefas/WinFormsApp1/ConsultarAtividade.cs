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
    public partial class ConsultarAtividade : Form
    {
        ConexaoFactory conexao = new ConexaoFactory();
        Usuario user;

        public ConsultarAtividade(Usuario user)
        {
            this.user = user;
            InitializeComponent();
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void Buscar_Click(object sender, EventArgs e)
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

        }
    }
}
