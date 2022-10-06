package tablic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	public static ArrayList<ServerThread> igraci=new ArrayList<ServerThread>();
	int port=Igrac.port;
	
	public Server() {
		
		try(ServerSocket ss=new ServerSocket(port)){
			
			System.err.println("Server radi.");
			
			while(true) {
				
				Socket sock=ss.accept();
				
				ServerThread st=new ServerThread(this,sock);
				igraci.add(st);
				
				
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	

}
