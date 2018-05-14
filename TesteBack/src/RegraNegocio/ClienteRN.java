/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RegraNegocio;

import Persistencia.ClientePers;
import ValorObjeto.ClienteVO;
import Visao.JFRMManterCliente;
import java.util.Vector;

/**
 *
 * @author Christian Gama
 */
public class ClienteRN {
    
    private ClienteVO clienteVO;
    
    public ClienteRN (ClienteVO clienteVO)
    {
        this.clienteVO = clienteVO;
    }
    
    public ClienteRN ()
    {
        
    }
    
    public boolean cadastrar() throws Exception {

        ClientePers clientePers = new ClientePers(clienteVO);

        return clientePers.cadastrar(); 
    }
    
    public boolean alterar() throws Exception {

        ClientePers clientePers = new ClientePers(clienteVO);

        return clientePers.alterar(); 
    }
    
    public boolean excluir() throws Exception {

        ClientePers clientePers = new ClientePers(clienteVO);

        return clientePers.excluir(); 
    }    
    
    public Vector buscar(String busca) throws Exception {
        
        ClientePers clientePers = new ClientePers();
        return clientePers.buscar(busca);
    }  
    
    public Vector buscarCalculo() throws Exception
    {
        ClientePers clientePers = new ClientePers(clienteVO);
        
        
        return clientePers.buscarCalculo();
    }
    
}
