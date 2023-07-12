package models;

public class Equipe {
    private int id;
    private String nome;
    private TipoServico tipoServico;
    private String responsavel;
    private double valorPeriodo;

    public Equipe() {
    }

    public Equipe(int id, String nome, TipoServico tipoServico, String responsavel, double valorPeriodo ) {
        this.id = id;
        this.nome = nome;
        this.responsavel = responsavel;
        this.valorPeriodo = valorPeriodo;
        this.tipoServico = tipoServico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public double getValorPeriodo() {
        return valorPeriodo;
    }

    public void setValorPeriodo(double valorPeriodo) {
        this.valorPeriodo = valorPeriodo;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Equipe other = (Equipe) obj;
        return this.id == other.id;
    }
    
    
}
