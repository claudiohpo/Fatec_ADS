using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WinFormsApp1
{

    public class Atividade
    {

        public int Id { get; private set; }
        public string Nome { get; private set; }
        public string Tema { get; private set; }
        public string Descricao { get; private set; }
        public string DataAtribuicao { get; private set; }
        public string DataSubmissao { get; private set; }
        public string DataEntrega { get; private set; }
        public Boolean Feito { get; private set; }
        public Usuario Usuario { get; private set; }

        public Atividade(string nome, string tema, string descricao, string dataAtribuicao, string dataSubmissao, string dataEntrega)
        {
            Nome = nome;
            Tema = tema;
            Descricao = descricao;
            DataAtribuicao = dataAtribuicao;
            DataSubmissao = dataSubmissao;
            DataEntrega = dataEntrega;
        }


        public Atividade(string nome, string tema, string descricao, string dataAtribuicao, string dataSubmissao, string dataEntrega, Usuario usuario)
        {
            Nome = nome;
            Tema = tema;
            Descricao = descricao;
            DataAtribuicao = dataAtribuicao;
            DataSubmissao = dataSubmissao;
            DataEntrega = dataEntrega;
            Usuario = usuario;
        }


    }
}
