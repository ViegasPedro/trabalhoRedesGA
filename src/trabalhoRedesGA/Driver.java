package trabalhoRedesGA;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class Driver {

	public void requestRide(int id) {
		new Thread() {
			public void run() {
				//for(int i = 0; i < 3; i++) {
					try {
						Socket socketCliente = new Socket("127.0.0.1", 6789);
						SocketUtil.writeData(socketCliente, Request.GET_RIDE);
						socketCliente.close();
					} catch (Exception e) {
						// TODO: handle exception
					}
				//}
			}
		}.start();
	}
}
