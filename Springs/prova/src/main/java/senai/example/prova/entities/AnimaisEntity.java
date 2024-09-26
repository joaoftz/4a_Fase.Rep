package senai.example.prova.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AnimaisEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String  nome;

    @Column(name = "tipo")
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "adotante_id")
    private AdotantesEntity Adotantes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public AdotantesEntity getAdotantes() {
        return Adotantes;
    }

    public void setAdotantes(AdotantesEntity adotantes) {
        Adotantes = adotantes;
    }
}
