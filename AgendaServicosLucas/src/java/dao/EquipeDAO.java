package dao;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import models.Equipe;
import models.TipoServico;

public class EquipeDAO extends GenericDAO<Equipe> implements Serializable{
    
    public LinkedList<Equipe> filtarPorItensEquipe( TipoServico tipoServico ) {
        LinkedList<Equipe> equipes = new LinkedList<>();
        for ( Equipe e : lista ) {
            if (e.getTipoServico().equals(tipoServico))
                equipes.add( e );
        }
        return equipes;
    }
    
    public Equipe findById(int id) {
        for (Equipe m : lista) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }
}
