
package br.com.larimaia.service;

import br.com.larimaia.DAO.ItemPedidoDAO;
import br.com.larimaia.DAO.PedidoDAO;
import br.com.larimaia.exception.ServiceException;
import br.com.larimaia.model.ItemPedido;
import br.com.larimaia.model.Pedido;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemPedidoService {
    private final ItemPedidoDAO itempedidoDAO;

    public ItemPedidoService() {
        itempedidoDAO = new ItemPedidoDAO();
    }

    public void salvar(ItemPedido ip) throws ServiceException {

        if (ip.getProduto().getId() == null) {
            throw new ServiceException("Campo Produto é obrigatório!");
        }

        if (ip.getQuantidade()== null) {
            throw new ServiceException("Campo Quantidade é obrigatório");
        }
        
        if (ip.getValor()== null) {
            throw new ServiceException("Campo Valor está vazio!");
        }
        if(ip.getId()== null){
            throw new ServiceException(ip.getId()+"Não é um pedido valido");
        }
         
         itempedidoDAO.salvarListaDeItensPedido(ip);
        
    }
    
    public void itemPedidoPedido(int idPedido,int idItemPedido) throws ServiceException{
        
        if(idPedido < 0){
            throw new ServiceException("idPedido não corresponde");
        }
        
        if (idItemPedido <0){
            throw new ServiceException("idItemPedido não corresponde");
        }
    }
    
    
    
    
}
