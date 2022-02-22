/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.sql.Connection;
import util.ConnectionFactory;

/**
 *
 * @author Rafael
 */
public class ConnectionTest {

    public static void main(String[] args) {

        connectionTest();
        
    }

    public static void connectionTest() {
        
        Connection conn = ConnectionFactory.openConnection();

        ConnectionFactory.closeConnection();

    }
}
