package main.launcher;

import main.launcher.Command;
import main.launcher.CommandParseException;
import sql.SQL;

public class CommandParse extends Command {
	
	protected final static String name = "register";
	private final static String details = "register user command"; 
	protected final static String shortcut = "[r]egister" ;
	private final static String help = "Use the register command";
	private final static String invalid = "Invalid command" ;
	protected int pas;
	protected String user;

	public CommandParse() {
		super(name, shortcut, details, help);
		// TODO Auto-generated constructor stub
	}
	
	public CommandParse(String user, int pas) {
		this();
		this.pas = pas;
		this.user = user;
	}

	@Override
	public boolean execute() throws CommandExecuteException {
		// TODO Auto-generated method stub
		try {
		SQL app = new SQL();
		app.insert(user, pas);
		return true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
            throw new CommandExecuteException("[ERROR]: Failed to add to data base.");
		}
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		 if ((commandWords[0].equalsIgnoreCase(shortcut) || commandWords[0].equalsIgnoreCase(name))) {// Comprueba si el comando está bien escrito
			if(commandWords.length == 3) {
				try {
					user = commandWords[1];
					pas = Integer.parseInt(commandWords[2]);
					
					return new CommandParse(user,pas); // Crea nuevo objeto
				}catch(NumberFormatException ex) {
					throw new CommandParseException("[ERROR]: " + invalid);
				}
			}
			else {
				throw new CommandParseException("[ERROR]: " + invalid);
			}
		}
	   else {
		  return null;
	   }
	}	
}


