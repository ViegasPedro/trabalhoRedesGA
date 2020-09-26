package trabalhoRedesGA;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Driver {

	public void requestRide(int id) {
		new Thread() {
			public void run() {
				// for(int i = 0; i < 3; i++) {
				try {
					Socket socketCliente = new Socket("127.0.0.1", 6789);
					System.out.println("START CLIENT");
					ObjectOutputStream output = new ObjectOutputStream(socketCliente.getOutputStream());
					ObjectInputStream input = new ObjectInputStream(socketCliente.getInputStream());

					SocketUtil.writeData(output, Request.GET_RIDE);

					Object serverResponse = SocketUtil.readData(input);
					System.out.println(serverResponse);

					SocketUtil.writeData(output, Request.UPDATE_RIDE);
					System.out.println(SocketUtil.readData(input));

					socketCliente.close();
					System.out.println("FINISH CLIENT");
				} catch (Exception e) {
					// TODO: handle exception
				}
				// }
			}
		}.start();
	}
}
