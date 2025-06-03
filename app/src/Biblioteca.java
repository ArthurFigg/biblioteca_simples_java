import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Biblioteca {
    private List<Livro> livros;
    private List<Cliente> clientes;
    private List<Autor> autores;
    private List<Emprestimo> emprestimos;

    // Construtor para inicializar as listas e evitar NullPointerException
    public Biblioteca() {
        livros = new ArrayList<>();
        clientes = new ArrayList<>();
        autores = new ArrayList<>();
        emprestimos = new ArrayList<>();
    }

    // Método para adicionar um livro à lista
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    // Método para listar todos os livros com suas informações
    public void listarLivros() {
        for (Livro livro : livros) {
            System.out.println("ID: " + livro.getId() + 
                               ", Título: " + livro.getTitulo() + 
                               ", Autor: " + livro.getAutor().getNome() + 
                               ", Disponível: " + livro.isDisponivel());
        }
    }


    public boolean emprestarLivro(int livroId, int clienteId) {
        Livro livro = buscarLivroPorId(livroId);
        Cliente cliente = buscarClientePorId(clienteId);


        if (livro != null && cliente != null && livro.isDisponivel()) {
            Emprestimo emprestimo = new Emprestimo(emprestimos.size() + 1, livro, cliente);
            emprestimos.add(emprestimo);
            livro.setDisponivel(false);
            return true; 
        }
        return false; 
    }


    public boolean devolverLivro(int emprestimoId) {
        for (Emprestimo emprestimo : emprestimos) {
            // Verifica o empréstimo pelo id e se ainda não foi devolvido
            if (emprestimo.getId() == emprestimoId && emprestimo.getDataDevolucao() == null) {
                emprestimo.setDataDevolucao(LocalDate.now()); // define a data de devolução
                emprestimo.getLivro().setDisponivel(true);   
                return true; 
        }
        return false; 
    }

  
    private Livro buscarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null; 
    }

    
    private Cliente buscarClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null; 
    }
}
