package trabalhoRedesGA;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

	public static void main(String[] args) throws IOException {

//		String frase = "Hello World!!!";
//		ObjectOutputStream output;
//		while (true) {
//			Socket socketCliente = new Socket("127.0.0.1", 6789);
//			// escreve no server
//			// socketCliente.getOutputStream()
//			output = new ObjectOutputStream(socketCliente.getOutputStream());
//			output.flush();
//			output.writeObject(frase);
//			output.flush();
//			output.close();
//
//			socketCliente.close();
//		}

		new Driver().requestRide(1);
		new Driver().requestRide(2);

	}

}
