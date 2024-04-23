using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinFormsApp1
{
    public partial class CadastroUsuario : Form
    {
       

        public CadastroUsuario()
        {

            InitializeComponent();
        }

        private void btnCadastrar_Click(object sender, EventArgs e)
        {

            string telefone = Regex.Replace(mtbTelefone.Text, @"[^\d]", "");
            DateTime dataAtual = DateTime.Now;
            string dataFormatada = dataAtual.ToString("dd/MM/yyyy");

            if ((string.IsNullOrEmpty(txbNome.Text))) {
                MessageBox.Show("por favor, insira um nome!");
            }
            else if ((string.IsNullOrEmpty(txbEmail.Text)))
            {
                MessageBox.Show("por favor, insira um email!");
            }
            else if ((string.IsNullOrEmpty(txbSenha.Text)) || (string.IsNullOrEmpty(txbConfSenha.Text)))
            {
                MessageBox.Show("por favor, insira uma senha e confirme!");
            }
            else if (dtpNasc.Text.Equals(dataFormatada))
            {
                MessageBox.Show("A data de nascimento não pode ser hoje!");
            }
            else if (!txbSenha.Text.Equals(txbConfSenha.Text))
            {
                txbConfSenha.Focus();
                MessageBox.Show("Senhas diferentes!");
            }
            else
            {
                Usuario usuario = new Usuario(txbNome.Text, txbCpf.Text, dtpNasc.Text, telefone, txbEmail.Text, txbConfSenha.Text);
                IDao<Usuario> _dao = new UsuarioDao();
                _dao.Inserir(usuario);
                limpar();
            }
        }

        private void btnLimpar_Click(object sender, EventArgs e)
        {
            limpar();

        }

        private void limpar()
        {
            txbNome.Clear();
            txbCpf.Clear();
            dtpNasc.Value = DateTimePicker.MinimumDateTime;
            dtpNasc.ResetText();
            mtbTelefone.Clear();
            txbEmail.Clear();
            txbSenha.Clear();
            txbConfSenha.Clear();
        }
    }
}
