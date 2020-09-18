package trabalhoRedesGA;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

	private List<String> rides = new ArrayList<>();
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// starta o server na porta informada
		System.out.println("SERVER START");
		ServerSocket serverSocket = new ServerSocket(6789);
		Client.start();
		while (true) {
			// fica aqui aguardando o request, quando ele chega é retornado um socket
			Socket connectionSocket = serverSocket.accept();
			// pega o envio do client
			// socketConexao.getInputStream();
			
			Request clientData = (Request) SocketUtil.readData(connectionSocket);			
			if(clientData == Request.GET_RIDE) {
				System.out.println("Bombou");
			}else {
				System.out.println("Erro na leitura do client");
			}

			connectionSocket.close();
		}
	}

}
