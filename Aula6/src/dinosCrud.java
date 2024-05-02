public class dinosCrud {
    private String Nome;
    private float Altura;
    private float Peso;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public float getPeso() {
        return Peso;
    }

    public void setPeso(float peso) {
        Peso = peso;
    }

    public float getAltura() {
        return Altura;
    }

    public void setAltura(float altura) {
        Altura = altura;
    }

    public dinosCrud(String nome, float peso, float altura) {
        Nome = nome;
        Peso = peso;
        Altura = altura;
    }
}

