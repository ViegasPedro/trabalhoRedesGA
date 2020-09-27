package trabalhoRedesGA;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.ThreadLocalRandom;

public class Driver {

	public void startDriver(int driverId) {
		new Thread() {
			public void run() {
				try {
					while(true) {
						System.out.println("DRIVER INICIOU");
						if(haveRide(driverId)) {
							drive();
							finishRide(driverId);
						}
						Thread.sleep(3000);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			}
		}.start();
	}
	
	public boolean haveRide(int driverId) throws Exception{
		Socket socketCliente = new Socket("127.0.0.1", 6789);
		ObjectOutputStream output = new ObjectOutputStream(socketCliente.getOutputStream());
		ObjectInputStream input = new ObjectInputStream(socketCliente.getInputStream());
		SocketUtil.writeData(output, new RequestDTO(Request.GET_RIDE, 0, driverId));	
		boolean serverResponse = (boolean)SocketUtil.readData(input);	
		socketCliente.close();
		return serverResponse;
	}
	
	public void finishRide(int driverId) throws Exception{
		Socket socketCliente = new Socket("127.0.0.1", 6789);
		ObjectOutputStream output = new ObjectOutputStream(socketCliente.getOutputStream());
		ObjectInputStream input = new ObjectInputStream(socketCliente.getInputStream());
		SocketUtil.writeData(output, new RequestDTO(Request.FINISH_RIDE, 0, driverId));	
		socketCliente.close();
	}
	
	public void drive() throws InterruptedException {
		int randomTime = ThreadLocalRandom.current().nextInt(5, 10+ 1);
		Thread.sleep(randomTime*1000);
	}
}
