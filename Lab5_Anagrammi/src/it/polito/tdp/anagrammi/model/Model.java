package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import javax.naming.StringRefAddr;

import it.polito.tdp.anagrammi.DAO.DizionarioDAO;

public class Model {
	
	List<Anagramma> anagrammiValidi = new ArrayList<>();
	List<Anagramma> anagrammiNonValidi = new ArrayList<>();
	DizionarioDAO dizionarioDAO = new DizionarioDAO();
	
	
	public void calcolaAnagrammi(String input, Anagramma parziale, int livello){
		
		//deepcopy 
		
		Anagramma anagramma = new Anagramma(parziale);
		
		//condizione di terminazione
		if( livello == input.length()) {
			if (this.isCorretto(anagramma)) {
				anagrammiValidi.add(anagramma);
				return;
			}else {
				anagrammiNonValidi.add(anagramma);
				return;
			}
			
		}
		
		for(int i =0 ; i<input.length(); i++) {
		//generazione di una soluzione parziale
		
		char c = input.charAt(i);	
		parziale.aggiungiLettera(c);
		
		// filtro 
		
		if(parziale.isCorretto(c,input) && !this.isPresente(parziale)) {    
			this.calcolaAnagrammi(input, parziale, livello+1);
		}
		
		parziale.backtrack();
	
		}
		return ;
		
	}




	private boolean isCorretto(Anagramma anagramma) {
		return this.dizionarioDAO.cercaParola(anagramma.getAnagramma());
	}
	
	private boolean isPresente(Anagramma anagramma) {
		for(Anagramma a : anagrammiValidi) {
			if(a.getAnagramma().equals(anagramma.getAnagramma())) {
				return true;
			}
		}
		for(Anagramma a : anagrammiNonValidi) {
			if(a.getAnagramma().equals(anagramma.getAnagramma())) {
				return true;
			}
		}
		return false;
	}
	
	public String getAnagrammiValidi() {
		StringBuilder sb = new StringBuilder();
		for(Anagramma a : anagrammiValidi) {
			sb.append(a.getAnagramma()+"\n");
		}
		return sb.toString();
		
	}
	
	public String getAnagrammiNonValidi() {
		StringBuilder sb = new StringBuilder();
		for(Anagramma a : anagrammiNonValidi) {
			sb.append(a.getAnagramma()+"\n");
		}
		return sb.toString();
		
	}
	
	public void resetAnagrammi() {
		anagrammiValidi.clear();
		anagrammiNonValidi.clear();
	}
	
	

}
