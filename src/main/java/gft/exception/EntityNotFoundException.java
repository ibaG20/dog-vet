package gft.exception;

public class EntityNotFoundException extends ApiDogException{

	private static final long serialVersionUID = 8766566498150867601L;

	public EntityNotFoundException(String message) {
		super(message);
	}

}
