
package br.com.larimaia.controller;


import br.com.larimaia.DAO.PedidoDAO;
import br.com.larimaia.model.Cliente;
import br.com.larimaia.model.Pedido;
import br.com.larimaia.model.Produto;
import br.com.larimaia.model.TipoEvento;
import br.com.larimaia.service.PedidoService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView;

public class PedidoController implements Initializable {
    
    private Pedido pedido;
    
    @FXML
    private TextField tfOrigemPedido;
    
    @FXML
    private DatePicker tfDataPedido;
    
    @FXML 
    private ComboBox<Cliente> comboBoxClientes;

    @FXML
    private TextField tfcerimonial;
    
    @FXML
    private DatePicker dataEvento;
    
    @FXML 
    private ComboBox<TipoEvento> comboBoxTipo;
    
    @FXML
    private TextField tfHorarioEvento;

    @FXML
    private TextField tfLocalEvento;
    
    @FXML
    private TextField tfEndereco;
    
    @FXML 
    private ComboBox<Produto> comboBoxProduto;
    
    @FXML
    private TextField tfQuantidade;
            
    @FXML
    private TextField tfValor;

    @FXML
    private Button btAdiconar;
    
    @FXML
    private TextField tfObs;
    
    
    @FXML
    private Button btnSAl;
        
    @FXML
    private TableView tabela;
    
    @FXML
    private TableColumn tabColProduto;
    
    @FXML
    private TableColumn tabColQuantidade;
    
    @FXML
    private TableColumn tabColValor;
    
    @FXML
    private TableColumn tabColExcluir;
    
    
    @FXML  
    private void btnSal (ActionEvent e){
//        PedidoDAO buscar = new PedidoDAO();
//        buscar.buscarPorId(1);
        try {
            pedido =new Pedido();
            
            
            
        } catch (Exception exc) {
            JOptionPane.showMessageDialog(null, exc);
        }
        
        
    }
    
    @FXML  
    private void buscarPedido (ActionEvent e){
        PedidoDAO buscar = new PedidoDAO();
        buscar.buscarTodosPedidos();
        
    }
    
    @FXML  
    private void buscarPedidoPorId (ActionEvent e){
        PedidoDAO buscar = new PedidoDAO();
        buscar.buscarPorId(1);
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxClientes.setItems(PedidoService.buscarClientes());
         comboBoxProduto.setItems(PedidoService.buscarProdutos());
         comboBoxTipo.setItems(PedidoService.buscarTipoEventos());
         
       
    }  
    
    @FXML
    public void buscarNomeClientes(){
        
        
    }
    
    
}
