import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Cliente extends Usuario{
    private String nomeCliente;
    private String endereco;
    private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
    public Cliente() {
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Cliente(String nomeCliente, String endereco) {
        this.nomeCliente = nomeCliente;
        this.endereco = endereco;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido pedidos) {
        this.pedidos.add(pedidos);
    }
    

    @Override
    public boolean isPermissao() {
        return false;
    }

    @Override
    public void verificarLogin(String l, String s) {
        boolean verificar;
        if((Objects.equals(this.login, l)) && (Objects.equals(this.senha, s))) {
            verificar = true;
        } else verificar = false;
        this.permissao=verificar;
    }

    public void atualizarPerfil(){
        Scanner input = new Scanner(System.in);

        System.out.println("Informe o nome do cliente");
        this.nomeCliente=input.next();
        System.out.println("Informe o login do cliente");
        this.login=input.next();
        System.out.println("Informe a senha do cliente");
        this.senha=input.next();
        System.out.println("Informe o email do cliente");
        this.email=input.next();
        System.out.println("Informe o endereco do cliente");
        this.endereco=input.next();
    }

    @Override
    public void imprimirInfo() {
        System.out.println(String.format("Nome: %s \nEndereco: %s", this.nomeCliente, this.endereco));

    }

    @Override
    public void visualizarPedidos() {
        for(int i = 0; i < pedidos.size(); i++) {
            pedidos.get(i).imprimirInfo();
        }
    }

    @Override
    public void fazerPedido(Pedido p) {
        this.pedidos.add(p);
    }

}
