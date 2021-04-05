package main.launcher;

public class CommandParseException extends Exception {
	
	private static final long serialVersionUID = 720538485357781759L;
	
	public CommandParseException(){ // Constructora sin mensaje
		super();
	}
	public CommandParseException(String message) { // Constructora con mensaje
		super(message);
	}

}
