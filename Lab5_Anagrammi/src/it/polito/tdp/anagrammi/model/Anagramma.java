package it.polito.tdp.anagrammi.model;

public class Anagramma {
	
	private String anagramma;
	private boolean corretto;
	
	public Anagramma(Anagramma a) {
		this.anagramma=a.anagramma;
		this.corretto=a.corretto;
	}
	
	public Anagramma() 
	{
		this.anagramma="";
		this.corretto=false;
	}
	
	
	public Anagramma(String anagramma, boolean corretto) {
		super();
		this.anagramma = anagramma;
		this.corretto = corretto;
	}


	public String getAnagramma() {
		return anagramma;
	}


	public void setAnagramma(String anagramma) {
		this.anagramma = anagramma;
	}

	public void setCorretto(boolean corretto) {
		this.corretto = corretto;
	}


	public void aggiungiLettera(char c) {
		this.anagramma+=c;
		
	}
	
	/**
	* elimino l' ultima lettera inserita
	*/
	
	public void backtrack() {
		int indice = anagramma.length();
		this.anagramma = this.anagramma.substring(0, indice-1);
	}

	public boolean isCorretto(char c, String input) {
		String tmp = input;
		int numeroCaratteriInput = 0; 
		int numeroCaratteriAnagramma = 0 ;
		char car = c ; 
		
		for(int i = 0 ; i < tmp.length(); i++) 
		{
			if(tmp.charAt(i) == car) 
			{
				numeroCaratteriInput++;
			}
		}
		for(int i = 0 ; i < this.anagramma.length() ; i++) 
		{
			if(this.anagramma.charAt(i) == car) 
			{
				numeroCaratteriAnagramma++;
			}
			
		}
		
		if(numeroCaratteriAnagramma>numeroCaratteriInput) 
		{
			this.corretto=false;
		}
		else 
		{
			this.corretto=true;
		}
		return this.corretto;
	}


	public boolean isCompleto(String input) {
		if(input.length()==this.anagramma.length()) 
		{
			return true;
		}
		return false;
	}




	
		
	
	
	
	
	
	

}
