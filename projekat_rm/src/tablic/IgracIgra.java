package tablic;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class IgracIgra extends Thread{
	

	String ime;
	PrintWriter out;
	
	public IgracIgra(String ime,Socket sock) {
		
		this.ime=ime;
		
		try {
			this.out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(sock.getOutputStream())));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
