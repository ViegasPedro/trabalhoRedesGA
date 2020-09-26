package trabalhoRedesGA;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketUtil {

	public static void writeData(ObjectOutputStream output, Object data) throws IOException {
		output.flush();
		output.writeObject(data);
		output.flush();
	}

	public static Object readData(ObjectInputStream input) throws IOException, ClassNotFoundException {
        return (Object) input.readObject();
	}
}
