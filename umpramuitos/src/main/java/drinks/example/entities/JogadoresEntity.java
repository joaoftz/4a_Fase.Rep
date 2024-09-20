import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class JogadoresEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
		@Column(name = "nome_jogador")
    private String nomeJogador;

    @ManyToOne
    @JoinColumn(name = "empresario_id") 
    private EmpresarioEntity empresario;

    // Construtores, getters e setters
    public JogadoresEntity() {}

    public JogadoresEntity(String nomeJogador, EmpresarioEntity empresario) {
        this.nomeJogador = nomeJogador;
        this.empresario = empresario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EmpresarioEntity getEmpresario() {
        return empresario;
    }

    public void setEmpresario(EmpresarioEntity empresario) {
        this.empresario = empresario;
    }
}