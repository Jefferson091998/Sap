import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class PooProva {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcao = 1,parcelas = 0;
        ArrayList<Usuario> users = new ArrayList<>();
        ArrayList<Produto> produtos = new ArrayList<>();

        do {
            System.out.println("Login ou Cadastrar \n" +
                    "1 - Login\n" +
                    "2 - Cadastrar\n" +
                    "0 - Sair");
            opcao = scan.nextInt();
            switch (opcao){
                case 1:
                    if(users.size() == 0) {
                        System.out.println("Nenhum user cadastrado");
                        break;
                    }

                    System.out.println("Informe o login");
                    String login = scan.next();

                    System.out.println("Informe a senha");
                    String senha = scan.next();

                    for(int i = 0; i < users.size(); i++) {
                        users.get(i).verificarLogin(login, senha);
                        if (users.get(i).permissao == true){
                            System.out.println("LOGADO COM SUCESSO");
                            if (users.get(i).isPermissao() == true) {
                                System.out.println("1 - Cadastrar Produto\n" +
                                        "2 - Atualizar Produto");
                                int operacao = scan.nextInt();
                                if(operacao == 1) {
                                    System.out.println("Informe o nome do produto");
                                    String produtoNome = scan.next();
                                    System.out.println("Informe o valor do produto");
                                    double produtoValor = scan.nextDouble();
                                    Produto produto = new Produto(produtoNome, produtoValor);
                                    produtos.add(produto);
                                } else if (operacao == 2) {
                                    for (int j = 1; j <= produtos.size(); j++) {
                                        System.out.println(j + " - " + produtos.get(j-1).infoProduto());
                                    }

                                    int opcaoProduto = scan.nextInt();
                                    if(opcaoProduto > produtos.size() || opcaoProduto <= 0) {
                                        System.out.println("produto n existe");
                                        break;
                                    }

                                    System.out.println("Informe o novo nome do produto");
                                    String produtoNome = scan.next();
                                    System.out.println("Informe o novo valor do produto");
                                    double produtoValor = scan.nextDouble();
                                    produtos.get(opcaoProduto-1).setNome(produtoNome);
                                    produtos.get(opcaoProduto-1).setValor(produtoValor);
                                }else{
                                    System.out.println("Opcao invalida");
                                }
                            } else if (users.get(i).isPermissao() == false) {
                                Cliente cliente = new Cliente();
                                cliente = (Cliente) users.get(i);
                                System.out.println("1 - Atualizar Perfil\n" +
                                        "2 - Imprimir Info\n" +
                                        "3 - Fazer Pedido\n" +
                                        "4 - Visualizar Pedidos");
                                int operacaoCliente = scan.nextInt();
                                if (operacaoCliente == 1) {
                                    users.get(i).atualizarPerfil();
                                }
                                if (operacaoCliente == 2) {
                                    users.get(i).imprimirInfo();
                                }
                                if (operacaoCliente == 3) {
                                    for (int j = 1; j <= produtos.size(); j++) {
                                        System.out.println(j + " - " + produtos.get(j-1).infoProduto());
                                    }

                                    int opcaoProduto = scan.nextInt();
                                    if(opcaoProduto > produtos.size() || opcaoProduto <= 0) {
                                        System.out.println("produto n existe");
                                        break;
                                    }
                                    Date date = new Date();
                                    Produto comprado = new Produto();
                                    comprado = produtos.get(opcaoProduto-1);
                                    Pedido pedido = new Pedido((int) Math.random(), date);
                                    pedido.setProdutos(comprado);
                                    users.get(i).fazerPedido(pedido);
                                    System.out.println("escolher forma de pagamento");
                                    System.out.println("1-Cartao de credito");
                                    System.out.println("2-pix");
                                    int formaDePagamento = scan.nextInt();
                                    if (formaDePagamento==1) {
                                        CartaoCredito cartao = new CartaoCredito();
                                        System.out.println("Informe od dados do Cartao de Credito");
                                        System.out.println("Informe o numero do cartao");
                                        cartao.setNumero(scan.next());
                                        System.out.println("Informe o titular do cartao");
                                        cartao.setTitular(scan.next());
                                        System.out.println("Informe o data de validade do cartao");
                                        cartao.setDtValidade(scan.next());
                                        System.out.println("Informe o cvv do cartao");
                                        cartao.setCvv(scan.next());
                                        System.out.println("Informe o numero se pagara a vista ou em 2X");
                                        parcelas=scan.nextInt();
                                        if(parcelas!=1 || parcelas!=2){
                                            System.out.println("quantidades de parcelas invalida");
                                        }
                                    }
                                    pedido.setFormaDePagamento(formaDePagamento,parcelas);
                                    cliente.setPedidos(pedido);
                                    users.set(i, cliente);
                                }
                                if (operacaoCliente == 4) {
                                    users.get(i).visualizarPedidos();
                                }
                            }
                        } else {
                            System.out.println("CONTA INEXSISTENTE");
                        }
                    }
                    break;

                case 2:
                    System.out.println("1 - ADMIN \n" +
                            "2 - Cliente");
                    int opcaoCadastro = scan.nextInt();
                    if (opcaoCadastro == 1) {
                        Admin admin = new Admin();
                        System.out.println("Informe o nome do admin");
                        admin.setNomeAdmin(scan.next());
                        System.out.println("Informe o login do admin");
                        admin.setLogin(scan.next());
                        System.out.println("Informe a senha do admin");
                        admin.setSenha(scan.next());
                        System.out.println("Informe o email do admin");
                        admin.setEmail(scan.next());
                        users.add(admin);
                    } else if (opcaoCadastro == 2) {
                        Cliente cliente = new Cliente();
                        System.out.println("Informe o nome do cliente");
                        cliente.setNomeCliente(scan.next());
                        System.out.println("Informe o login do cliente");
                        cliente.setLogin(scan.next());
                        System.out.println("Informe a senha do cliente");
                        cliente.setSenha(scan.next());
                        System.out.println("Informe o email do cliente");
                        cliente.setEmail(scan.next());
                        System.out.println("Informe o endereco do cliente");
                        cliente.setEndereco(scan.next());
                        users.add(cliente);
                    }
                    break;
            }
        } while (opcao != 0);
    }
}
