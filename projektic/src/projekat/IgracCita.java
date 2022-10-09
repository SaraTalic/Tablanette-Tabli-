package projekat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class IgracCita extends Thread{
	
	private String ime;
	private Socket socket;
	private BufferedReader in;

	public IgracCita(String ime,Socket sock) {
		this.ime=ime;
		this.socket=sock;
		
		try {
			
			this.in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
			try {
				String odg=in.readLine();
				if(odg==null)
					return;
				System.out.println(odg);
			}catch(IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}
