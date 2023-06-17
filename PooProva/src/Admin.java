import java.util.Objects;
//import pooprova.Usuario;

public class Admin extends Usuario{

    private String nomeAdmin;

    public Admin() {
    }

    public String getNomeAdmin() {
        return nomeAdmin;
    }

    public void setNomeAdmin(String nomeAdmin) {
        this.nomeAdmin = nomeAdmin;
    }

    public boolean isPermissao() {
        return true;
    }

    @Override
    public void verificarLogin(String l, String s) {
        boolean verificar;
        if((Objects.equals(this.login, l)) && (Objects.equals(this.senha, s))) {
            verificar = true;
        } else verificar = false;
        this.permissao=verificar;
    }

    @Override
    public void atualizarPerfil() {

    }

    @Override
    public void imprimirInfo() {

    }

    @Override
    public void visualizarPedidos() {
    }

    @Override
    public void fazerPedido(Pedido p) {

    }

    public void cadastrarProduto() {

    }
}
