package berberyan;

public class ValidateEmail {

	private ValidateEmail() {}

	public static boolean isValid(String email){
		if( email.trim().matches(
				"([a-zA-Z0-9_]+@+[a-zA-Z0-9_]+\\.+[a-zA-Z]+(\\.+[a-zA-Z]+)?)"
				)) {
			return true;
		}
		return false;
	}
}
