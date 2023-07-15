package src.IO;

public class Produto {
    private int quantidade;
    private double preço;
    private String id;
    public Produto(int quantidade, double preço, String id) {
        this.quantidade = quantidade;
        this.preço = preço;
        this.id = id;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public double getPreço() {
        return preço;
    }
    public void setPreço(double preço) {
        this.preço = preço;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
