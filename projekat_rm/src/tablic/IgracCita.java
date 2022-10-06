package tablic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class IgracCita extends Thread{
	
	BufferedReader in;
	private String ime;
	
	
	public IgracCita(String ime,Socket sock) {
		this.ime=ime;
		
		try {
			
			this.in=new BufferedReader(new InputStreamReader(sock.getInputStream()));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
