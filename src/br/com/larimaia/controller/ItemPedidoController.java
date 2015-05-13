
package br.com.larimaia.controller;

import br.com.larimaia.DAO.ItemPedidoDAO;
import br.com.larimaia.exception.ServiceException;
import br.com.larimaia.model.ItemPedido;
import br.com.larimaia.service.ItemPedidoService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ItemPedidoController {
    
    public void salvar(ItemPedido ip){
        ItemPedidoService ipservice = new ItemPedidoService();
       
        try {
            ipservice.salvar(ip);
        } catch (ServiceException ex) {
            Logger.getLogger(ItemPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void itempedidopedido(int idpedido,int iditempedido){
         ItemPedidoService ipservice = new ItemPedidoService();
         
         try {
            ipservice.itemPedidoPedido(iditempedido,iditempedido);
            
        } catch (ServiceException ex) {
            Logger.getLogger(ItemPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int consultarIdItemPedido(){
        ItemPedidoDAO ipDAO = new ItemPedidoDAO();
        return ipDAO.buscarIdItemPempedido();
    }
    
}
