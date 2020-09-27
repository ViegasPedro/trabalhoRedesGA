package trabalhoRedesGA;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

	private static List<Ride> rides = new ArrayList<>();

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// starta o server na porta informada
		System.out.println("SERVER START");
		ServerSocket serverSocket = new ServerSocket(6789);
		Client.start();
		while (true) {
			System.out.println("###########################################");
			// fica aqui aguardando o request, quando ele chega é retornado um socket
			Socket connectionSocket = serverSocket.accept();
			// starta streams de leitura e escrita
			ObjectOutputStream output = new ObjectOutputStream(connectionSocket.getOutputStream());
			ObjectInputStream input = new ObjectInputStream(connectionSocket.getInputStream());

			RequestDTO clientRequest = (RequestDTO) SocketUtil.readData(input);
			switch (clientRequest.getRequest()) {
			case GET_RIDE:
				// se a lista está vázia retorna que não achou corrida
				if (rides.size() == 0) {
					SocketUtil.writeData(output, false);
				} else {
					SocketUtil.writeData(output, findEmptyRide(clientRequest.getDriverId()));
				}
				break;
			case CHECK_RIDE:
				rides.forEach(r -> System.out.println(r));
				SocketUtil.writeData(output, checkRideStatus(clientRequest.getUserId()));
				break;
			case INSERT_RIDE:
				Ride ride = new Ride(clientRequest.getUserId(), rides.size(),0, RideStatus.AVAILABLE);
				rides.add(ride);
				SocketUtil.writeData(output, ride.getRideId());
				break;
			case FINISH_RIDE:
				finishRide(clientRequest.getDriverId());
				break;
			default:
				System.out.println("Erro na leitura do client");
			}
			connectionSocket.close();
		}
	}

	private static boolean findEmptyRide(int driverId) {
		for (Ride ride : rides) {
			if (ride.getStatus() == RideStatus.AVAILABLE) {
				ride.setStatus(RideStatus.ON_THE_ROAD);
				ride.setDriverId(driverId);
				return true;
			}
		}
		return false;
	}
	
	private static void finishRide(int driverId) {
		for (Ride ride : rides) {
			if (ride.getStatus() == RideStatus.ON_THE_ROAD && ride.getDriverId() == driverId) {
				ride.setStatus(RideStatus.FINISHED);
				break;
			}
		}
	}
	
	private static RideStatus checkRideStatus(int rideId) {
		for (Ride ride : rides) {
			if (ride.getRideId() == rideId) {
				return ride.getStatus();
			}
		}
		return null;
	}

}
