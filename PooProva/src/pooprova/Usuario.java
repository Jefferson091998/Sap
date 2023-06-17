import java.util.Date;

public abstract class Usuario {
    protected String login;
    protected String senha;
    private Date dataRegistro;
    protected String email;

    protected boolean permissao;

    public Usuario() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPermissao(boolean permissao) {
        this.permissao = permissao;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public abstract boolean isPermissao();

    public abstract void verificarLogin(String l, String s);

    public abstract void atualizarPerfil();

    public abstract void imprimirInfo();

    public abstract void visualizarPedidos();

    public abstract void fazerPedido(Pedido p);
}
