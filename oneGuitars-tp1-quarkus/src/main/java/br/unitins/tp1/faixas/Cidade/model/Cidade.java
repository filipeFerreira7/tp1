package br.unitins.tp1.faixas.Cidade.model;
import br.unitins.tp1.faixas.Cliente.service.DefaultEntity.model.DefaultEntity;
import br.unitins.tp1.faixas.Estado.model.Estado;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cidade extends DefaultEntity {
 
        private String nome;

        @ManyToOne
        @JoinColumn(name="id_estado")
        private Estado estado;


        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Estado getEstado() {
            return estado;
        }

        public void setEstado(Estado estado) {
            this.estado = estado;
        }

        
    
}