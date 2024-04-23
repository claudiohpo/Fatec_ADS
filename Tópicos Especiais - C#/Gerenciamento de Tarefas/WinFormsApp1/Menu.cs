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
    public partial class Menu : Form
    {
        private Usuario user;

        public Menu()
        {
            InitializeComponent();
        }

        public Menu(Usuario user)
        {
            this.user = user;
            InitializeComponent();
        }

        private void cadastrarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            CadastrarAtividade cadastrar = new CadastrarAtividade(user);
            cadastrar.Show();
        }

        private void consultarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ConsultarAtividade consultar = new ConsultarAtividade(user);
            consultar.Show();
        }

        private void alterarToolStripMenuItem_Click(object sender, EventArgs e)
        {
            AlterarAtividade alterar = new AlterarAtividade(user);
            alterar.Show();
        }

        private void excluirToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ExcluirAtividade excluir = new ExcluirAtividade(user);
            excluir.Show();
        }

        private void Menu_Load(object sender, EventArgs e)
        {

        }

        private void Menu_FormClosed(object sender, FormClosedEventArgs e)
        {
            //Abre Novamente o formulário de Login
            Login formMenu = new Login();
            formMenu.Show();
        }
    }
}
