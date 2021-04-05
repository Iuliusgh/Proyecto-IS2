package main.launcher;

import java.util.Scanner;

import main.launcher.Command;
import main.launcher.CommandGenerator;
import main.launcher.CommandExecuteException;


public class Controller {
	
	public final String prompt = "Command > ";
	public static final String unknownCommandMsg = String.format("Unknown command");
	
	    private Scanner scanner;
	   
	    public Controller( Scanner scanner) {
		    this.scanner = scanner;
	    }

	public void run() throws CommandParseException {
		
		// TODO Auto-generated method stub
		System.out.println(prompt);
		String s = scanner.nextLine(); // Lee el comando
		String[] parameters = s.toLowerCase().trim().split(" ");
		System.out.println("[DEBUG] Executing: " + s);
		try { // Genera commando y lo ejecuta
			Command command = CommandGenerator.parse(parameters);
			command.execute();
		} catch(CommandExecuteException ex) {
			System.out.format(ex.getMessage() +"%n%n");
		}
		
	}

}
