package main.launcher;


import main.launcher.CommandExecuteException;
import main.launcher.CommandParseException;


public abstract class Command {

	protected final String name;
	  protected final String shortcut;
	  private final String details; 
	  private final String help;

	  protected static final String incorrectNumberOfArgsMsg = "Incorrect number of arguments";
	  protected static final String incorrectArgsMsg = "Incorrect arguments format";
	  
	  public Command(String name,  String shortcut, String details, String help){ // Se crea la constructora del comando
	    this.name = name;
	    this.shortcut = shortcut;
	    this.details = details;
	    this.help = help;
	  }
	  
	  public abstract boolean execute() throws CommandExecuteException; // Execute que heredan ya que es abstracto
	  
	  public abstract Command parse(String[] commandWords) throws CommandParseException; // Parse que heredan ya que es abstracto
	  
	  protected boolean matchCommandName(String name) { // Miramos si coincide el nombre del comando
		    return this.shortcut.equalsIgnoreCase(name) || 
		        this.name.equalsIgnoreCase(name);
	  }
	  
	  protected Command parseNoParamsCommand(String[] words) throws CommandParseException { 
		  if (matchCommandName(words[0])) {
			  if (words.length != 2) {
				  throw new CommandParseException("[ERROR]: Command "+ name +" :"+incorrectNumberOfArgsMsg);
			  }
			  else {
				  return this;
			  }
		  }
		  return null;
	  }
	  
	  public String helpText(){ // Devuelve el texto del help
	    return details + ": " + help + "\n";
	  }
}
