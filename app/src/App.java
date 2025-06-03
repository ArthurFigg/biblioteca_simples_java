import java.util.Scanner;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca(); // Criação única da biblioteca

        System.out.println("Bem-vindo ao sistema de biblioteca!");

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Emprestar Livro");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Adicionar Cliente");
            System.out.println("6. Sair");
            System.out.println("7. listar Clientes\n");
            System.out.println("8. Listar Autores");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.println("Digite o ID do livro:");
                    int idLivro = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o título do livro:");
                    String titulo = scanner.nextLine();

                    System.out.println("Digite o nome do autor:");
                    String nomeAutor = scanner.nextLine();

                    System.out.println("Digite a nacionalidade do autor:");
                    String nacionalidadeAutor = scanner.nextLine();

                    System.out.println("Digite a data de nascimento do autor (YYYY-MM-DD):");
                    String dataNascimentoAutor = scanner.nextLine();

                    Autor autor = new Autor(nomeAutor, nacionalidadeAutor, LocalDate.parse(dataNascimentoAutor));
                    Livro livro = new Livro(idLivro, titulo, autor, true);
                    biblioteca.adicionarLivro(livro, autor);

                    System.out.println("Livro adicionado com sucesso!");
                    break;

                case 2:
                    biblioteca.listarLivros();
                    break;

                case 3:
                    System.out.println("Digite o ID do livro para emprestar:");
                    int livroId = scanner.nextInt();
                    System.out.println("Digite o ID do cliente:");
                    int clienteId = scanner.nextInt();
                    scanner.nextLine();

                    if (biblioteca.emprestarLivro(livroId, clienteId)) {
                        System.out.println("Livro emprestado com sucesso!");
                    } else {
                        System.out.println("Não foi possível emprestar o livro.");
                    }
                    break;

                case 4:
                    System.out.println("Digite o ID do empréstimo para devolver:");
                    int emprestimoId = scanner.nextInt();
                    scanner.nextLine();

                    if (biblioteca.devolverLivro(emprestimoId)) {
                        System.out.println("Livro devolvido com sucesso!");
                    } else {
                        System.out.println("Não foi possível devolver o livro.");
                    }
                    break;

                case 5:
                    System.out.println("Digite o ID do cliente:");
                    int idCliente = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Digite o nome do cliente:");
                    String nomeCliente = scanner.nextLine();

                    System.out.println("Digite o email do cliente:");
                    String email = scanner.nextLine();

                    System.out.println("Digite o telefone do cliente:");
                    String telefone = scanner.nextLine();

                    Cliente cliente = new Cliente(idCliente, nomeCliente, email, telefone);
                    biblioteca.adicionarCliente(cliente); 

                    System.out.println("Cliente adicionado com sucesso!");
                    break;

                case 6:
                    System.out.println("Saindo do sistema. Até logo!");
                    scanner.close(); 
                    return;
                case 7:
                    biblioteca.listarClientes(); 
                    break;
                case 8:
                    biblioteca.ListarAutores(); 
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    
            }
        }
    }
}
