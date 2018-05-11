package Excepciones;

public class LetterException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public LetterException() {
		this("Letra ");
	}
	public LetterException(String str) {
		super(str+" no valida");
	}
}