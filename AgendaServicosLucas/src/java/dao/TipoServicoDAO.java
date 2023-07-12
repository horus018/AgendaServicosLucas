package dao;

import java.io.Serializable;
import models.TipoServico;

public class TipoServicoDAO extends GenericDAO<TipoServico>{

    public TipoServico findById(int id) {
        return findByExample(new TipoServico(id, null));
    }
}
