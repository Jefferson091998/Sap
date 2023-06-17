import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private int numPedido;
    private Date dataCriacao;
    private ArrayList<Produto> produtos = new ArrayList<>();
    private double valorFinal = 0;
    private String formaDePagamento;

    public Pedido() {
    }

    public Pedido(int numPedido, Date dataCriacao) {
        this.numPedido = numPedido;
        this.dataCriacao = dataCriacao;
    }
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto p) {
        this.produtos.add(p);
    }
    public int getNumPedido() {
        return numPedido;
    }

    public void setNumPedido(int numPedido) {
        this.numPedido = numPedido;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public void setFormaDePagamento(int formaDePagamento,int formaDePagamen2) {
        if(formaDePagamento==1){
            if(formaDePagamen2==1){
            this.formaDePagamento="Cartao de credito 1X";
            } else if(formaDePagamen2==2){
                this.formaDePagamento="Cartao de credito 2X";
            }else {
                this.formaDePagamento="Quantidade de pacelas invalida";
            }
        }else if(formaDePagamento==2){
            this.formaDePagamento="PIX";
        }else {
            this.formaDePagamento="Outra forma de pagamento";
        }
    }
    

    public String imprimirInfo(){
        System.out.println("Numero do pedido " + numPedido);
        for(int i = 0; i < produtos.size(); i++) {
            System.out.println((i+1) + " " + produtos.get(i).getNome() + " " + produtos.get(i).getValor());
            System.out.println(this.calcularPreco());
        }
        return null;
    }

    public double calcularPreco(){
        for (int i=0;produtos.size()>i;i++){
            valorFinal+=this.produtos.get(i).getValor();
        }
        this.valorFinal=valorFinal;
        return valorFinal;
    }
}
