package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DizionarioDAO {
	
	
	
	public boolean cercaParola(String parola) {
		
		String sql="SELECT id FROM parola WHERE nome='"+parola+"'";
	
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();
			
			
			
			if(rs.next()) {
			
				return true;
				
			}
			else {
				
				return false;
			}
			
		
			
			
		}catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
	}
	
	

}
