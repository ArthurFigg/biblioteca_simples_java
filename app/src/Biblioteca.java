import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Biblioteca {
    private List<Livro> livros;
    private List<Cliente> clientes;
    private List<Autor> autores;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        livros = new ArrayList<>();
        clientes = new ArrayList<>();
        autores = new ArrayList<>();
        emprestimos = new ArrayList<>();
    }

    // Método para adicionar um livro com validação
    public void adicionarLivro(Livro livro, Autor autor) {
        if (livro == null || autor == null) return;

        // Verificar se já existe livro com o mesmo ID
        for (Livro l : livros) {
            if (l.getId() == livro.getId()) {
                System.out.println("Erro: Já existe um livro com esse ID.");
                return;
            }

           
            
            if (l.getTitulo().equalsIgnoreCase(livro.getTitulo())) {
                System.out.println("Erro: Já existe um livro com esse título.");
                return;
            }
            
        }

        // Procurar autor existente pelo nome
        Autor autorExistente = buscarAutorPorNome(autor.getNome());

        if (autorExistente != null) {
            livro.setAutor(autorExistente);
        } else {
            autores.add(autor);
            livro.setAutor(autor);
        }

        livros.add(livro);
    }

    private Autor buscarAutorPorNome(String nome) {
        for (Autor a : autores) {
            if (a.getNome().equalsIgnoreCase(nome)) {
                return a;
            }
        }
        return null;
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        }
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
            if (emprestimo.getId() == emprestimoId && emprestimo.getDataDevolucao() == null) {
                emprestimo.setDataDevolucao(LocalDate.now());
                emprestimo.getLivro().setDisponivel(true);
                return true;
            }
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

    public void adicionarCliente(Cliente cliente) {
        if (cliente != null && !clientes.contains(cliente)) {
            clientes.add(cliente);
        }
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        }
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getId() +
                               ", Nome: " + cliente.getNome() +
                               ", Email: " + cliente.getEmail() +
                               ", Telefone: " + cliente.getTelefone());
        }
    }

    public void ListarAutores() {
        if (autores.isEmpty()) {
            System.out.println("Nenhum autor cadastrado.");
        }
        for (Autor autor : autores) {
            System.out.println("Nome: " + autor.getNome() +
                               ", Nacionalidade: " + autor.getNacionalidade() +
                               ", Data de Nascimento: " + autor.getDataNascimento());
        }
    }
}
