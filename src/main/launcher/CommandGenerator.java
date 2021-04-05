package main.launcher;

import main.launcher.Command;
import main.launcher.CommandParse;
import main.launcher.CommandParseException;


public class CommandGenerator {
	
	private static Command[] availableCommands = { // Estatico que contiene la inicialización de los comandos
			new CommandParse()
			
};
	

public static Command parse(String[ ] commandWords) throws CommandParseException { // Miramos a ver si el commando escrito coincide, si no coincide lanza excepción.
	
		Command c = null;
		for(Command Com: availableCommands) {
			c=Com.parse(commandWords);
			if(c != null) {
				break;
			}
		}
		if(c == null) {
			throw new CommandParseException("[ERROR]: Unknown command");
		}
		return c;
}

   public static String commandHelp() { // Estatico que muestra comando de ayuda por cada comando
	  StringBuilder SB = new StringBuilder();
	
	  for(Command Com : availableCommands) {
		  SB.append(Com.helpText());
	  }
	
	  return SB.toString();	
  }

}
