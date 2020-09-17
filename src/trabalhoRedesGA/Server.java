package trabalhoRedesGA;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		String fraseCliente;

		// starta o server na porta informada
		ServerSocket serverSocket = new ServerSocket(6789);
		while (true) {
			// fica aqui aguardando o request, quando ele chega é retornado um socket
			Socket socketConexao = serverSocket.accept();
			// pega o envio do client
			// socketConexao.getInputStream();

			ObjectInputStream input = new ObjectInputStream(socketConexao.getInputStream());
			fraseCliente = (String) input.readObject();

			System.out.println(fraseCliente);
			socketConexao.close();
		}

	}

}
