public class CartaoCredito {

    private String numero;
    private String titular;
    private  String dtValidade;
    private String cvv;

    public CartaoCredito() {
    }

    public CartaoCredito(String numero, String titular, String dtValidade, String cvv) {
        this.numero = numero;
        this.titular = titular;
        this.dtValidade = dtValidade;
        this.cvv = cvv;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getDtValidade() {
        return dtValidade;
    }

    public void setDtValidade(String dtValidade) {
        this.dtValidade = dtValidade;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String infoProduto() {
        return String.format("Numero: %s \nTitular: %s\nData de Validade: %d\nCvv: %s", this.numero, this.titular, this.dtValidade, this.cvv);
    }
}
