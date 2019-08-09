package model.exceptions;

public class DomainException extends Exception { // Exeptions -> obrigado a tratar //// RuntimeException -> pode
												// propagar o erro.
	
	private static final long serialVersionUID = 1L;

	///////////////////////////////////////////////////////////////////////////
	// o Exception é do TIPO SERIAZABLE e necessita de um valor de versão /////
	///////////////////////////////////////////////////////////////////////////
	
	public DomainException(String msg) {
		super(msg);
	}

}
