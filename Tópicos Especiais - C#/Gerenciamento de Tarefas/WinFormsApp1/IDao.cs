using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WinFormsApp1
{
    internal interface IDao<T>
    {
        public void Inserir(T obj);
        public T? BuscarPorId(int id);
        public IEnumerable<T> BuscarTodos();
        public void Deletar(T obj);
        public void Alterar (T obj);

    }
}
