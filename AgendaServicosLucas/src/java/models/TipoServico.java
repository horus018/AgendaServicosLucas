package models;

public class TipoServico {
    private int id;
    private String descricao;
    
    public TipoServico() {
    }
    
    public TipoServico(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
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
        final TipoServico other = (TipoServico) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "TipoServico{" + "id=" + id + ", descricao=" + descricao + '}';
    }
    
    
}

