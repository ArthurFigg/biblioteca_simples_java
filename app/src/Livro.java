import java.time.LocalDate;

public class Livro {
    private int id;
    private String titulo;
    private Autor autor;
    private boolean disponivel;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;

    // Construtor
    public Livro(int id, String titulo, Autor autor, boolean disponivel) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;
        LocalDate now = LocalDate.now();
        this.dataCadastro = now;
        this.dataAtualizacao = now;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    // Setters (com atualização da data de modificação)
    public void setTitulo(String titulo) {
        this.titulo = titulo;
        this.dataAtualizacao = LocalDate.now();
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
        this.dataAtualizacao = LocalDate.now();
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
        this.dataAtualizacao = LocalDate.now();
    }

    // Método toString para imprimir o objeto de forma legível
    @Override
    public String toString() {
        return "Livro [id=" + id + ", título=" + titulo + ", autor=" + autor.getNome() +
               ", disponível=" + (disponivel ? "Sim" : "Não") + "]";
    }
}
