package dao;

import java.util.LinkedList;
import java.util.List;

public abstract class GenericDAO<T> {

    protected LinkedList<T> lista;

    public GenericDAO() {
        lista = new LinkedList<>();
    }

    public void inserir(T obj) {
        if (!lista.contains(obj)) {
            lista.add(obj);
        }
    }

    public void remover(T obj) {
        lista.remove(obj);
    }

    public List<T> listar() {
        LinkedList<T> resp = new LinkedList<>();
        resp.addAll(lista);
        return resp;
    }

    public T findByExample(T ex) {
        int pos = lista.indexOf(ex);
        if (pos >= 0) {
            return lista.get(pos);
        }
        return null;
    }

}
