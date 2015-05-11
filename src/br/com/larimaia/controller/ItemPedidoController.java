
package br.com.larimaia.controller;

import br.com.larimaia.DAO.ItemPedidoDAO;
import br.com.larimaia.model.ItemPedido;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ItemPedidoController {
    
    public void salvar(ItemPedido ip){
        ItemPedidoDAO ipdao = new ItemPedidoDAO();
        try {
            ipdao.salvar(ip);
        } catch (ParseException ex) {
            Logger.getLogger(ItemPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
