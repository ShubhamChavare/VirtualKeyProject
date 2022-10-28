package virtualkey;

public class VirtualKeyMain {

	public static void main(String[] args) {
		// Basic info shown
		WelcomeScreen ws = new WelcomeScreen();
		ws.showFileDetails();
		// get input according to user choice
		ws.getUserChoice();
	}

}
