package br.com.larimaia.service;

import br.com.larimaia.DAO.ClienteDAO;
import br.com.larimaia.DAO.PedidoDAO;
import br.com.larimaia.DAO.ProdutoDAO;
import br.com.larimaia.DAO.TipoEventoDAO;
import br.com.larimaia.model.Pedido;
import br.com.larimaia.exception.ServiceException;
import br.com.larimaia.model.Cliente;
import br.com.larimaia.model.ItemPedido;
import br.com.larimaia.model.Produto;
import br.com.larimaia.model.TipoEvento;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PedidoService {
    private final PedidoDAO pedidoDAO;

    public PedidoService() {
        pedidoDAO = new PedidoDAO();
    }

    public void salvar(Pedido pedido) throws ServiceException {

        if (pedido.getOrigemPedido().isEmpty()) {
            throw new ServiceException("Campo Origem do Pedido é obrigatório!");
        }

        if (pedido.getDataPedido() == null) {
            throw new ServiceException("Campo Data do Pedido é obrigatório!");
        }
        
        if (pedido.getCliente().getNome().isEmpty()) {
            throw new ServiceException("Campo Cliente é obrigatório!");
        }

        if (pedido.getCerimonial().isEmpty()) {
            throw new ServiceException("Campo Cerimonial é obrigatório!");
        }
        
        if (pedido.getDataEvento() == null) {
            throw new ServiceException("Campo Data do Evento é obrigatório!");
        }

        if (pedido.getTipoEvento().getDescricao().isEmpty()) {
            throw new ServiceException("Campo Tipo é obrigatório!");
        }
        
        if (pedido.getHoraEvento().isEmpty()) {
            throw new ServiceException("Campo Hora é obrigatório!");
        }
        
        if (pedido.getLocalEvento().isEmpty()) {
            throw new ServiceException("Campo Local do Evento é obrigatório!");
        }
        
        if (pedido.getEnderecoEvento().isEmpty()) {
            throw new ServiceException("Campo Endereço é obrigatório!");
        }
        
        if (pedido.getTipoEvento().getDescricao().isEmpty()) {
            throw new ServiceException("Campo Tipo é obrigatório!");
        }

        try {
            pedidoDAO.salvar(pedido);
        } catch (ParseException ex) {
            Logger.getLogger(PedidoService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void excluir(Integer id) {
       pedidoDAO.excluir(id);
    }

    public Pedido buscarPorId(Integer id) {
        return pedidoDAO.buscarPorId(id);
    
    }
    public List<Pedido> buscarTodos() {
          return (List<Pedido>) pedidoDAO.buscarTodosPedidos();
    }
    
    public static ObservableList<Cliente> buscarClientes(){
        ClienteDAO cliDAO = new ClienteDAO();
         ObservableList<Cliente> 
                relacaoClientes = FXCollections.observableArrayList( cliDAO.buscarCliente());
        return relacaoClientes;
    }
    
    public static ObservableList<Produto> buscarProdutos(){
        ProdutoDAO pdao = new ProdutoDAO();
        ObservableList<Produto> 
                relacaoProduto = FXCollections.observableArrayList( pdao.buscaProduto());
        return relacaoProduto;
    }
    
    public static ObservableList<TipoEvento>  buscarTipoEventos(){
        TipoEventoDAO tipodao = new TipoEventoDAO();
        ObservableList<TipoEvento> 
                relacaoTipoevento = FXCollections.observableArrayList( tipodao.buscarTodosOsTiposDeEventos());

        return relacaoTipoevento;
    }
    
    public int setarIdDoPedido(){
         return pedidoDAO.setarIdDoPedidoCadastrado();
    }

    
    
}
