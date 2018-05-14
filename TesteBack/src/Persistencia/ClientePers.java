/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import ValorObjeto.ClienteVO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 *
 * @author Christian Gama
 */
public class ClientePers 
{
    Conexao conexao;
    private ClienteVO clienteVO;
    
    public ClientePers(ClienteVO clienteVO)
    {
        this.clienteVO = clienteVO;
        conexao  = new Conexao();
    }
    
    public ClientePers ()
    {
        conexao  = new Conexao();
    }
    
    public boolean cadastrar() throws Exception {

        boolean verificacao = false;
        
        try {

            Connection con = conexao.conectar();

            CallableStatement cs = con.prepareCall("{call CADASTRAR_CUSTOMER_ACCOUNT(?,?,?,?)}");

            cs.setString(1, clienteVO.getCpf_cnpj());
            cs.setString(2, clienteVO.getNm_custumer());
            cs.setBoolean(3, clienteVO.isIs_active());
            cs.setFloat(4, clienteVO.getVl_total());


            cs.executeUpdate();
            
            conexao.desconectar();
            return verificacao = true;

        } catch (Exception e) {

            System.out.println("Erro ao cadastrar Cliente: "+e.getMessage());
            verificacao = false;
            
        } finally {
            
            conexao.desconectar();
            return verificacao;
        }
    }
    
    public boolean alterar() throws Exception {
        
        boolean verificacao = false;
        
        try {
            

            Connection con = conexao.conectar();            
            Statement stm = con.createStatement();  
            
            stm.executeUpdate("update TB_CUSTOMER_ACCOUNT set cpf_cnpj = '"+clienteVO.getCpf_cnpj()+
                        "', nm_customer = '"+clienteVO.getNm_custumer()+
                        "', is_active = '"+clienteVO.isIs_active()+
                        "', vl_total = "+clienteVO.getVl_total()+
                        " where ID_CUSTOMER = "+clienteVO.getId_customer());
            
            conexao.desconectar();
            return verificacao = true;
            
        
        } catch (SQLException e) {

            System.out.println("Erro ao alterar Cliente: "+e.getMessage());
            verificacao = false;            
        } 
        catch (Exception e) {

            System.out.println("Erro ao alterar Cliente: "+e.getMessage());
            verificacao = false;            
        } 
        finally {
            
            conexao.desconectar();
            return verificacao;
        }
        
    }
    
    public boolean excluir() throws Exception {
        
        boolean verificacao = false;

        try {
            
            Connection con = conexao.conectar();            
            Statement stm = con.createStatement(); 

            stm.executeUpdate("delete from TB_CUSTOMER_ACCOUNT where TB_CUSTOMER_ACCOUNT.ID_CUSTOMER = " + clienteVO.getId_customer()+ "");

            conexao.desconectar();
            return verificacao = true;
            
        
        } catch (SQLException e) {

            System.out.println("Erro ao alterar Cliente: "+e.getMessage());
            verificacao = false;            
        } 
        catch (Exception e) {

            System.out.println("Erro ao alterar Cliente: "+e.getMessage());
            verificacao = false;            
        } 
        finally {
            
            conexao.desconectar();
            return verificacao;
        }
        
    }
    
    public Vector buscar(String filtro) throws Exception {

        Vector clientes = new Vector();
        
        try {
            Connection con = conexao.conectar();
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery("select * from TB_CUSTOMER_ACCOUNT where upper(TB_CUSTOMER_ACCOUNT.NM_CUSTOMER) like upper('%" + filtro + "%') order by TB_CUSTOMER_ACCOUNT.VL_TOTAL desc");

            while (rs.next()) {

                ClienteVO clienteVO = new ClienteVO();
                        
                clienteVO.setId_customer(rs.getInt(1));
                clienteVO.setCpf_cnpj(rs.getString(2));
                clienteVO.setNm_custumer(rs.getString(3));
                clienteVO.setIs_active(rs.getBoolean(4));
                clienteVO.setVl_total(rs.getFloat(5));

                
                clientes.add(clienteVO);
            }           
            
        } catch (Exception e) {
            
            System.out.println("Erro Buscar Cliente : "+e.getMessage());
            clientes.removeAllElements();
            
        } finally {
            
            conexao.desconectar();
            return clientes;
        }
    }    
    
    public Vector buscarCalculo() throws Exception {

        Vector clientes = new Vector();
        
        try {
            Connection con = conexao.conectar();
            Statement stm = con.createStatement();

            ResultSet rs = stm.executeQuery("select * from TB_CUSTOMER_ACCOUNT where (TB_CUSTOMER_ACCOUNT.VL_TOTAL > 560) and (TB_CUSTOMER_ACCOUNT.ID_CUSTOMER BETWEEN 1500 AND 2700) order by TB_CUSTOMER_ACCOUNT.VL_TOTAL desc");

            while (rs.next()) {

                ClienteVO clienteVO = new ClienteVO();
                        
                clienteVO.setId_customer(rs.getInt(1));
                clienteVO.setCpf_cnpj(rs.getString(2));
                clienteVO.setNm_custumer(rs.getString(3));
                clienteVO.setIs_active(rs.getBoolean(4));
                clienteVO.setVl_total(rs.getFloat(5));

                
                clientes.add(clienteVO);
            }           
            
        } catch (Exception e) {
            
            System.out.println("Erro Buscar Cliente : "+e.getMessage());
            clientes.removeAllElements();
            
        } finally {
            
            conexao.desconectar();
            return clientes;
        }
    }
}
