package trabalhoRedesGA;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketUtil {

	public static void writeData(Socket socket, Object data) throws IOException {
		ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
		output.flush();
		output.writeObject(data);
		output.flush();
		output.close();
	}
	
	public static Object readData(Socket socket) throws IOException, ClassNotFoundException {
		ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
		return (Object)input.readObject();
	}
}
