package trabalhoRedesGA;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Driver {

	public void requestRide(int id) {
		new Thread() {
			public void run() {
				for (int i = 0; i < 3; i++) {
					try {
						Socket socketCliente = new Socket("127.0.0.1", 6789);
						// escreve no server
						// socketCliente.getOutputStream()
						ObjectOutputStream output = new ObjectOutputStream(socketCliente.getOutputStream());
						output.flush();
						output.writeObject("I'm client " + id);
						output.flush();
						output.close();

						socketCliente.close();
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}.start();
	}
}
