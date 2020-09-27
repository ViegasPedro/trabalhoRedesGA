package trabalhoRedesGA;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class User {

	public void startUser(int userId) {
		new Thread() {
			public void run() {
				try {
					while (true) {
						System.out.println("USER INICIOU");
						int rideId = insertRide(userId);
						boolean keepChecking = true;
						while (keepChecking) {
							switch (checkRide(rideId)) {
							case ON_THE_ROAD:
//								System.out.println("USER: ainda na corrida");
								break;
							case FINISHED:
//								System.out.println("USER: terminou a corrida");
								keepChecking = false;
								break;
							default:
//								System.out.println("USER: esperando motorista");
								break;
							}
							Thread.sleep(3000);
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

	public int insertRide(int userId) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket socketCliente = new Socket("127.0.0.1", 6789);
		ObjectOutputStream output = new ObjectOutputStream(socketCliente.getOutputStream());
		ObjectInputStream input = new ObjectInputStream(socketCliente.getInputStream());
		SocketUtil.writeData(output, new RequestDTO(Request.INSERT_RIDE, userId, 0));
		int rideId = (int) SocketUtil.readData(input);
		socketCliente.close();
		return rideId;
	}

	public RideStatus checkRide(int userId) throws UnknownHostException, IOException, ClassNotFoundException {
		Socket socketCliente = new Socket("127.0.0.1", 6789);
		ObjectOutputStream output = new ObjectOutputStream(socketCliente.getOutputStream());
		ObjectInputStream input = new ObjectInputStream(socketCliente.getInputStream());
		SocketUtil.writeData(output, new RequestDTO(Request.CHECK_RIDE, userId, 0));
		RideStatus rideStatus = (RideStatus) SocketUtil.readData(input);
		socketCliente.close();
		return rideStatus;
	}
}
