package trabalhoRedesGA;


public class Client {

	public static void start(){

		new Driver().startDriver(1);
		new Driver().startDriver(2);
		new User().startUser(1);
		new User().startUser(2);
		new User().startUser(3);
	}

}
