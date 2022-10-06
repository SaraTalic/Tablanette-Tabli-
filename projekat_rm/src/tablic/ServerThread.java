package tablic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread {

	String ime;
	Server server;
	Socket sock;
	BufferedReader in;
	PrintWriter out;
	
	public ServerThread(Server s, Socket soc) {
		
		this.server=s;
		this.sock=soc;
		
		try {
			this.in= new BufferedReader(new InputStreamReader(this.sock.getInputStream()));
			this.out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.sock.getOutputStream())));
			this.ime=in.readLine();
		}catch(IOException e) {
			e.printStackTrace();
		}
		

	}
	
}
