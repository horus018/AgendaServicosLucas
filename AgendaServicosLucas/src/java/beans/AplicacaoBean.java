package beans;

import dao.AgendamentoDAO;
import dao.EquipeDAO;
import dao.TipoServicoDAO;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.faces.model.SelectItem;
import models.Equipe;
import models.TipoServico;

@Named(value = "aplicacao")
@ApplicationScoped
public class AplicacaoBean {

    private TipoServicoDAO tipoServicoDAO;
    private EquipeDAO equipeDAO;
    private AgendamentoDAO agendamentoDAO;
    private List<SelectItem> itensTipoServico;

    public AplicacaoBean() {
    }

    @PostConstruct
    public void iniciar() {
        tipoServicoDAO = new TipoServicoDAO();
        equipeDAO = new EquipeDAO();
        agendamentoDAO = new AgendamentoDAO();

        TipoServico t = new TipoServico(1, "Limpeza de piscina");
        tipoServicoDAO.inserir(t);
        equipeDAO.inserir(new Equipe(1, "Equipe A1", t, "Clara Ferreira", 384.23));
        equipeDAO.inserir(new Equipe(2, "Equipe A2", t, "Rafael Silva", 325.10));
        equipeDAO.inserir(new Equipe(3, "Equipe A3", t, "Júlia Oliveira", 177.08));
        equipeDAO.inserir(new Equipe(4, "Equipe A4", t, "Felipe Santos", 444.94));

        t = new TipoServico(2, "Higienização de ar-condicionado");
        tipoServicoDAO.inserir(t);
        equipeDAO.inserir(new Equipe(5, "Equipe B1", t, "Isadora Pereira", 322.88));
        equipeDAO.inserir(new Equipe(6, "Equipe B2", t, "Gustavo Rodrigues", 231.42));
        equipeDAO.inserir(new Equipe(7, "Equipe B3", t, "Mariana Almeida", 207.79));
        equipeDAO.inserir(new Equipe(8, "Equipe B4", t, "Lucas Souza", 171.06));

        t = new TipoServico(3, "Lavagem de fachada de vidro");
        tipoServicoDAO.inserir(t);
        equipeDAO.inserir(new Equipe(9, "Equipe C1", t, "Amanda Costa", 211.59));
        equipeDAO.inserir(new Equipe(10, "Equipe C2", t, "Matheus Carvalho", 458.18));
        equipeDAO.inserir(new Equipe(11, "Equipe C3", t, "Camila Lima", 476.57));
        equipeDAO.inserir(new Equipe(12, "Equipe C4", t, "Diego Ribeiro", 350.76));

        t = new TipoServico(4, "Manutenção de jardins e paisagismo");
        tipoServicoDAO.inserir(t);
        equipeDAO.inserir(new Equipe(13, "Equipe D1", t, "Larissa Fernandes", 345.11));
        equipeDAO.inserir(new Equipe(14, "Equipe D2", t, "Vinícius Cardoso", 142.67));
        equipeDAO.inserir(new Equipe(15, "Equipe D3", t, "Nathalia Barbosa", 307.24));
        equipeDAO.inserir(new Equipe(16, "Equipe D4", t, "Guilherme Xavier", 419.56));

    }
    
    public List<SelectItem> getItensTipoServico() {
        if (itensTipoServico == null) {
            itensTipoServico = new LinkedList<>();
            itensTipoServico.add( new SelectItem(null,"Selecione o tipo de serviço"));
            for (TipoServico t : tipoServicoDAO.listar()) {
                itensTipoServico.add(new SelectItem(t, t.getDescricao()));
            }
        }
        return itensTipoServico;
    }

    @Produces
    public TipoServicoDAO getTipoServicoDAO() {
        return tipoServicoDAO;
    }

    @Produces
    public EquipeDAO getEquipeDAO() {
        return equipeDAO;
    }

    @Produces
    public AgendamentoDAO getAgendamentoDAO() {
        return agendamentoDAO;
    }

    @PreDestroy
    public void gravarArquivo() {
        //fazer bean pra gravar a lista de agendamentos em um arquivo, tipo:
        //agendamentoDAO.gravarEmArquivoTxt()
    }

}
