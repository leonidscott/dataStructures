public class HashtableFullException extends RuntimeException {
	public final OpenAddressHashtable failed;
	
	public HashtableFullException(OpenAddressHashtable failed) {
		this.failed = failed;
	}
}