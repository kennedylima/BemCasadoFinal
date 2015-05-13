
package br.com.larimaia.DAO;

import br.com.larimaia.model.Cliente;
import br.com.larimaia.util.ConexaoUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;


public class ClienteDAO {
    Connection conexao;
    
    public ClienteDAO(){
        conexao= ConexaoUtil.getConnection();
    }
    
    public List<Cliente> buscarCliente(){
        String sql= "SELECT * FROM cliente ORDER by nome ";
        
        try {
            PreparedStatement preparadorSql= conexao.prepareStatement(sql);
            ResultSet resultado = preparadorSql.executeQuery();
            List<Cliente> clientes = new ArrayList<Cliente>();
            
            while (resultado.next()){
                
                Cliente cliente = new Cliente();
                
                cliente.setId(resultado.getInt("idcliente"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setEmail(resultado.getString("email"));
                cliente.setTelefone(resultado.getString("telefone"));
                clientes.add(cliente);
            }
            
            preparadorSql.close();
            return clientes;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
          
}
