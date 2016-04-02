package encryptor1;

public class InvalidEncryptionKeyException extends Exception {

	public InvalidEncryptionKeyException(String message) {
		super(message);
		System.out.println(message);
	}

}
