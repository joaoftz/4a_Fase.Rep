import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.Set;

@Entity
public class EmpresarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
		@Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "empresario")
    private List<JogadoresEntity> nomeJogador;

    // Construtores, getters e setters
    public EmpresarioEntity() {}

    public EmpresarioEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<JogadoresEntity> getJogadores() {
        return jogadores;
    }

    public void setBooks(Set<JogadoresEntity> jogadores) {
        this. = jogadores;
    }
}

