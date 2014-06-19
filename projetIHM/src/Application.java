import view.*;
import java.awt.*;

public class Application{

	/**
	 * méthode principale éxécutable
	 * @param args
	 */
	public static void main(String[] args) {
		CarnetAdresse fen = new CarnetAdresse("Carnet D'adresse",new Dimension(640, 480));
		fen.setVisible(true);
	}
}