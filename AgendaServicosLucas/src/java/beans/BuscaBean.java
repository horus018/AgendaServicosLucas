package beans;

import dao.EquipeDAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import models.Equipe;
import models.TipoServico;

@Named(value = "buscaBean")
@SessionScoped
public class BuscaBean implements Serializable {
    
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private TipoServico tipoServicoSelecionado;
    private Equipe equipeSelecionada;
    private LinkedList<SelectItem> itensEquipe;
    private String responsavel;
    private double valor;
    private String showData;
    private String periodo;
    private double totalServico;
    private String contratante;
    private String telefone;
    private String email;
    private String endereco;
    
    @Inject
    EquipeDAO equipeDAO;
    
    public BuscaBean() {
    }
    
    @PostConstruct
    public void iniciar() {
        itensEquipe = new LinkedList<SelectItem>();
        itensEquipe.add(new SelectItem(null, "Selecione o tipo de serviço primeiro"));
    }
    
    public TipoServico getTipoServicoSelecionado() {
        return tipoServicoSelecionado;
    }
    
    public void setTipoServicoSelecionado(TipoServico tipoServicoSelecionado) {
        this.tipoServicoSelecionado = tipoServicoSelecionado;
        itensEquipe.clear();
        if (tipoServicoSelecionado == null) {
            itensEquipe.add(new SelectItem(null, "Selecione o tipo de serviço primeiro"));
        } else {
            itensEquipe.add(new SelectItem(null, "Selecione a equipe"));
            for (Equipe e : equipeDAO.filtarPorItensEquipe(tipoServicoSelecionado)) {
                itensEquipe.add(new SelectItem(e, e.getNome()));
            }
        }
        this.setResponsavel(null);
        this.setValor(0.0);
        double valor = 1;
        this.equipeSelecionada = null;
        this.totalServico = 0.0;
    }
    
    public LinkedList<SelectItem> getItensEquipe() {
        return itensEquipe;
    }
    
    public Equipe getEquipeSelecionada() {
        return equipeSelecionada;
    }
    
    public void setEquipeSelecionada(Equipe equipeSelecionada) {
        this.equipeSelecionada = equipeSelecionada;
        if (equipeSelecionada == null) {
            this.setResponsavel(null);
            this.setValor(0.0);
            this.setTotalServico(0.0);
        } else {
            this.setResponsavel(equipeSelecionada.getResponsavel());
            this.setValor(equipeSelecionada.getValorPeriodo());
            double valor = 1;
            if (this.getPeriodo() != null) {
                if (this.getPeriodo().equals("Dia inteiro")) {
                    valor = 2;
                }
                this.setTotalServico(this.getEquipeSelecionada().getValorPeriodo() * valor);
            }
        }
    }
    
    public String getResponsavel() {
        return responsavel;
    }
    
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
        
    }
    
    public double getValor() {
        return valor;
    }
    
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String getShowData() {
        return showData;
    }
    
    public void setShowData(String showData) {
        this.showData = showData;
    }
    
    public String getPeriodo() {
        return periodo;
    }
    
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
        double valor = 1;
        if (periodo != null) {
            if (periodo.equals("Dia inteiro")) {
                valor = 2;
            }
            this.totalServico = this.getEquipeSelecionada().getValorPeriodo() * valor;
        }
        
    }
    
    public double getTotalServico() {
        return totalServico;
    }
    
    public void setTotalServico(double totalServico) {
        this.totalServico = totalServico;
    }
    
    public String getContratante() {
        return contratante;
    }
    
    public void setContratante(String contratante) {
        this.contratante = contratante;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public void agendar() {

//        try {
//            formatedDate = dateFormat.parse(dateFormat.format(showData));
//        } catch (Exception e) {
//            FacesMessage message = new FacesMessage("Formato de data inválido. Use o formato dd/MM/yyyy.");
//            FacesContext.getCurrentInstance().addMessage("data", message);
//        }
//        
//        Agendamento agendamento = new Agendamento(equipeSelecionada, formatedDate, periodo, totalServico, contratante, telefone, email, endereco);
//        this.cadAgendamento.agendar(agendamento);
    }
    
    public void limpar() {
        
    }
    
}
