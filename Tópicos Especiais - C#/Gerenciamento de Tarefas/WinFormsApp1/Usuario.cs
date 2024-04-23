using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms.VisualStyles;

namespace WinFormsApp1
{
    public class Usuario
    {
        
        public int Id { get; private set; }
        public string Nome { get; private set; }
        public string Cpf { get; private set; }
        public string DataNasc { get; private set; }
        public string Telefone { get; private set; }
        public string Email {get; private set;}
        public string Senha {get; private set;}
        public List<Atividade> atividades;

        public Usuario(string nome, string cpf, string dataNasc, string telefone, string email, string senha)
        {
            Nome = nome;
            Cpf = cpf;
            DataNasc = dataNasc;
            Telefone = telefone;
            Email = email;
            Senha = senha;
        }

        public Usuario(string id, string email)
        {
            Id = Convert.ToInt16(id);
            Email = email;
        }

        public List<Atividade> getAtividades()
        {
            return this.atividades;
        }

        public void addAtividades(Atividade atividade)
        {
            atividades.Add(atividade);
        }
    }
}
