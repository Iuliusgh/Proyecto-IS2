
import java.util.Scanner;
import main.launcher.CommandParseException;
import main.launcher.Controller;


public class Main {
	public static final String usageMsg = "Usage: not valid files";


	public static void main(String[] args){
		if (args.length < 1 || args.length > 2)
			System.out.print(usageMsg);
		else {
			try {
				
				Controller controller = new Controller( new Scanner(System.in));
				controller.run();
			}
			catch (NumberFormatException nfe) {
					System.out.println("An error ocurred");
			} catch (CommandParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	

}
