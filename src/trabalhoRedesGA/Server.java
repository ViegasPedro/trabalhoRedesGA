package trabalhoRedesGA;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
			ObjectOutputStream output = new ObjectOutputStream(connectionSocket.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(connectionSocket.getInputStream());
			
			Request clientRequest = (Request) SocketUtil.readData(input);
			switch(clientRequest) {
				case GET_RIDE:
					System.out.println("Bombou");
					SocketUtil.writeData(output, "Salve!!!!");
					break;
				case UPDATE_RIDE:
					System.out.println("Corrida atualizada");
					SocketUtil.writeData(output, "UPODATEZADA");
					break;
				default:
					System.out.println("Erro na leitura do client");
			}
			connectionSocket.close();
		}
	}

}
