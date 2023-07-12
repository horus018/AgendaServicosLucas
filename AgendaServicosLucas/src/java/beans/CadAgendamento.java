package beans;

import dao.AgendamentoDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;
import models.Agendamento;

@Named(value = "cadAgendamento")
@SessionScoped
public class CadAgendamento implements Serializable {
    
    @Inject
    AgendamentoDAO agendamentoDAO;

    public CadAgendamento() {
        
    }
    
    public void agendar(Agendamento agendamento){
        //nao consegue criar o agendamentoDAO objeto
        agendamentoDAO.inserir(agendamento);
        System.out.println(agendamento);
    }
    
}
