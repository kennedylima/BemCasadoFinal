
package br.com.larimaia.DAO;

import br.com.larimaia.model.ItemPedido;
import br.com.larimaia.model.Pedido;
import br.com.larimaia.util.ConexaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ItemPedidoDAO {
    
    Connection conexao;
    
    public ItemPedidoDAO(){
        conexao= ConexaoUtil.getConnection();
    }
    
    
    
    public List<ItemPedido> listarItens(){
        
        String sql = "SELECT * FROM itempedido";
        return null;
    }
    
     public void salvar(ItemPedido item) throws ParseException {
        if (item.getId() == null) {
            cadastrar(item);
        } else {
            alterar(item);
        }
    }
    
     private void cadastrar(ItemPedido item) {
        String sql = "INSERT INTO ItemPedido (idproduto,quantidade,valor) VALUES (?,?,?)";
        
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
             preparadorSQL.setInt(1, item.getPedido().getId());
             preparadorSQL.setInt(2, item.getQuantidade());
             preparadorSQL.setDouble(3, (item.getValor()*item.getQuantidade()));
            
            preparadorSQL.executeQuery();
            preparadorSQL.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemPedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    private void alterar(ItemPedido item) {
        
    }
     
    
    public void excluir(int id){
        String sql = "DELETE FROM itempedido WHERE id=?";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);

            preparadorSQL.setInt(1, id);
            preparadorSQL.execute();
            preparadorSQL.close();

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }

    
    
}
