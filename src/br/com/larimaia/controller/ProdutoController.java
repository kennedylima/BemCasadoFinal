
package br.com.larimaia.controller;

import br.com.larimaia.DAO.ClienteDAO;
import br.com.larimaia.DAO.ProdutoDAO;
import br.com.larimaia.model.Cliente;
import br.com.larimaia.model.Produto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class ProdutoController implements Initializable {
   
    @FXML 
    private ComboBox<Produto> comboBoxProduto;
    
    @FXML
    private Label label;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ProdutoDAO pdao = new ProdutoDAO();
        ObservableList<Produto> 
                relacaoProduto = FXCollections.observableArrayList( pdao.buscaProduto());
         comboBoxProduto.setItems(relacaoProduto);
    
    }
    
}
