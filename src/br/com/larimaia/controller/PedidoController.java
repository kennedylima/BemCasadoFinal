
package br.com.larimaia.controller;


import br.com.larimaia.DAO.PedidoDAO;
import br.com.larimaia.exception.ServiceException;
import br.com.larimaia.model.Cliente;
import br.com.larimaia.model.ItemPedido;
import br.com.larimaia.model.Pedido;
import br.com.larimaia.model.Produto;
import br.com.larimaia.model.TipoEvento;
import br.com.larimaia.service.PedidoService;
import java.awt.HeadlessException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafx.scene.input.KeyCode.S;
import static javafx.scene.input.KeyCode.T;
import javafx.util.Callback;
import javax.swing.JCheckBox;
import static javax.swing.text.html.HTML.Tag.S;


public class PedidoController implements Initializable {
    
    @FXML
    private TextField tfIndicacao;
    
    @FXML
    private TextField tfOrigemPedido;
    
    @FXML 
    private ComboBox<Cliente> comboBoxClientes;

    @FXML
    private TextField tfcerimonial;
    
    @FXML
    private DatePicker dataEvento;
    
    @FXML
    private DatePicker dataPedido;
    
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
    private TextField tfObs;
        
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
    private Button btexcluir;
    
    @FXML
    private Button btnSAl;
    
        
    private static List<ItemPedido> prod = new ArrayList<>();
     
    private PedidoService ps = new PedidoService();
    
    private ObservableList<ItemPedido> dados;
    public Set<ItemPedido> setExcluir;
   
    
    @FXML  
    private void btnSal (ActionEvent e){
        
        Pedido pedido = new Pedido();
        
        pedido.setOrigemPedido(tfOrigemPedido.getText());
        pedido.setDataPedido(dataPedido.getValue().toString());
        pedido.setCliente(comboBoxClientes.getValue());
        pedido.setIndicacao(tfIndicacao.getText());
        pedido.setCerimonial(tfcerimonial.getText());
        pedido.setDataEvento(dataEvento.getValue().toString());
        pedido.setTipoEvento(comboBoxTipo.getValue());
        pedido.setHoraEvento(tfHorarioEvento.getText());
        pedido.setIndicacao(tfIndicacao.getText());
        pedido.setLocalEvento(tfLocalEvento.getText());
        pedido.setEnderecoEvento(tfEndereco.getText());
        pedido.setObs(tfObs.getText());
        pedido.setItens(prod);
        try {
            ps.salvar(pedido);
            pedido.setId(ps.setarIdDoPedido());
            ps.salvarListaItensPedido(pedido.getId(),dados);
            
            JOptionPane.showMessageDialog(null, "Pedido salvo com sucesso!");
            
            limparTela();
            
        } catch (ServiceException | HeadlessException exc) {
            JOptionPane.showMessageDialog(null, exc);
        }
        
        
    }
   
    @FXML
    private void btnAdd(ActionEvent e){
        
        ItemPedido ip = new ItemPedido();
        
        ip.setProduto(comboBoxProduto.getValue());
        ip.setQuantidade(Integer.parseInt(tfQuantidade.getText()));
        
        // Deixando o resultado com duas casas decimais na  coluna valor
        double resultado = comboBoxProduto.getValue().getValor()* ip.getQuantidade();
        resultado = Math.round(resultado * 100);
        resultado = resultado/100;
        ip.setValor(comboBoxProduto.getValue().getValor()* ip.getQuantidade());
        System.out.println(ip.getValor());
        
        
        // Adicionado o objeto ip dentro da lista de item pedido
        prod.add(ip);
        
        // inserindo as informações dentro das colunas correspondentes.
        tabColProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        tabColValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        tabColQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        
        // colocando na Observable list as informações contidas na lista prod
        ObservableList<ItemPedido> dados =
        FXCollections.observableArrayList(
                prod
        );
        
        tabela.setItems(dados);
    }
    
    @FXML  
    private void buscarPedido (ActionEvent e){
        PedidoDAO buscar = new PedidoDAO();
        buscar.buscarTodosPedidos();
    }
    
    //metodo que exclui os itens selecionados na tableview
    @FXML
    private void excluirItens (ActionEvent e){
        // instaniando uma noval lista para copiar as informações da lista prod
        ObservableList<ItemPedido> 
            itensSelecionados =FXCollections.observableArrayList(prod);
        
        // pegando as linhas selecionadas na tela
        setExcluir = new HashSet(tabela.getSelectionModel().getSelectedItems());
       
        // removendo as linhas que foram selecionadas na tela da lista itensSelecionados
        itensSelecionados.removeAll(setExcluir);
        
        // limpando as informações da tableview
        tabela.getItems().clear();
        
        // sobrescrevendo as informações da lista prod com as informaçoes da itensSelecioados
        prod = FXCollections.observableArrayList(itensSelecionados);
        
        //Inserindo a lista prod dentro da table view
        tabela.getItems().addAll(prod);
        
        
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
        tabela.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); 
        
    }  
    
    public void limparTela(){
    tfIndicacao.setText("");
    tfOrigemPedido.setText("");
//    comboBoxClientes;
//    tfcerimonial;
//    dataEvento;
//    dataPedido;
//    comboBoxTipo;
//    tfHorarioEvento;
//    TextField tfLocalEvento;
//    tfEndereco;
//    comboBoxProduto;
//    tfQuantidade;
//    tfValor;
//    tfObs;
//    tabela;
//    tabColProduto;
//    tabColQuantidade;
//    tabColValor;
//    tabColExcluir;
//    btexcluir;
//    btnSAl;
//    
    }   
    

    
}
