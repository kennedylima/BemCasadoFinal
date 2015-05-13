package br.com.larimaia.model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.control.CheckBox;
import javax.swing.JCheckBox;

public class ItemPedido {
    private Integer id;
    private Produto produto;
    private Integer quantidade;
    private Double valor;
    private int idPedido;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getPedido() {
        return idPedido;
    }

    public void setPedido(int idpedido) {
        this.idPedido = idpedido;
    }

    private  SimpleBooleanProperty verificado =  new  SimpleBooleanProperty ( false ); 
   // outras colunas aqui

    public static class Item {
   private SimpleBooleanProperty checked = new SimpleBooleanProperty(false);
   // other columns here

    public SimpleBooleanProperty checkedProperty() {
        return this.checked;
    }

    public java.lang.Boolean getChecked() {
        return this.checkedProperty().get();
    }

    public void setChecked(final java.lang.Boolean checked) {
        this.checkedProperty().set(checked);
    }

    // getter/setter for other columns

}
    
    
}
