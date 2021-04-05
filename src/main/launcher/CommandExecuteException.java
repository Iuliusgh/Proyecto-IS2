package main.launcher;

public class CommandExecuteException extends Exception {
	
	private static final long serialVersionUID = 3778950151026063512L;
	
	public CommandExecuteException(){ // Constructora sin mensaje
		super();
	}
	public CommandExecuteException(String message) { // Constructora con mensaje
		super(message);
	}

}
