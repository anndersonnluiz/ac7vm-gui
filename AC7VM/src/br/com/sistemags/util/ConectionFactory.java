/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sistemags.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;



/**
 *
 * @author Wolverine
 */


public class ConectionFactory {

    private static EntityManager manager;
    

    public static EntityManager getConnection() {
    	EntityManagerFactory emf = null;
        manager = null;
        emf = Persistence.createEntityManagerFactory("sistemagsPU");
        manager = emf.createEntityManager();
        if (!manager.isOpen()) {
        	JOptionPane.showMessageDialog(null, "Conexão fechada");
        }
        return manager;
    }
  
    
	public static Connection getConexao() {
		Connection conexao = null;
		try {
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:8081/systm", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conexao;
	}
}