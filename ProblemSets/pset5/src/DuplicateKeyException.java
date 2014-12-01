// Lenny Scott, pset 5
public class DuplicateKeyException extends RuntimeException {
	private String duplicateKeyString;

	public DuplicateKeyException(Object duplicateKey) {
		duplicateKeyString = duplicateKey.toString();
	}

	public String getMessage() {
		return "The Key " + duplicateKeyString + " is already present.";
	}

}