package models;

import java.util.Date;
import java.util.Objects;

public class Agendamento {

    private Equipe equipe;
    private Date date;
    private String perido;
    private double totalServico;
    private String contratante;
    private String telefone;
    private String email;
    private String endereco;

    public Agendamento() {
    }

    public Agendamento(Equipe equipe, Date date, String perido, double totalServico, String contratante, String telefone, String email, String endereco) {
        this.equipe = equipe;
        this.date = date;
        this.perido = perido;
        this.totalServico = totalServico;
        this.contratante = contratante;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPerido() {
        return perido;
    }

    public void setPerido(String perido) {
        this.perido = perido;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.equipe);
        hash = 97 * hash + Objects.hashCode(this.date);
        hash = 97 * hash + Objects.hashCode(this.perido);
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
        final Agendamento other = (Agendamento) obj;
        if (!Objects.equals(this.perido, other.perido)) {
            return false;
        }
        if (!Objects.equals(this.equipe, other.equipe)) {
            return false;
        }
        return Objects.equals(this.date, other.date);
    }

}
