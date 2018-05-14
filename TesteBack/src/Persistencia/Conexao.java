/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Christian Gama
 */
public class Conexao {

    static Connection conexao;

    public Conexao() {

        conexao = null;
    }

    public Connection conectar() throws Exception {

        try {

            Class.forName("org.firebirdsql.jdbc.FBDriver");
            
            File arq = new File("");  
            String diretorio = arq.getAbsolutePath();
            conexao = DriverManager.getConnection("jdbc:firebirdsql:localhost/3050:" + diretorio.replace("\\", "/") + "/database/TESTEBACK.fdb", "sysdba", "masterkey");
            
            return conexao;
        }
        catch (ClassNotFoundException ex) {

            throw new Exception("Erro na localização do driver!\n(" + ex.getMessage() + ")");
        }
        catch (SQLException e) {
            throw new Exception("Erro na conexão!\n(" + e.getMessage() + ")");
        }
    }

        public void desconectar() throws Exception {
            try {

                conexao.close();
            }
            catch (SQLException ex) {

                throw new Exception("Erro ao Desconectar!\n(" + ex.getMessage() + ")");
            }
        }
}
