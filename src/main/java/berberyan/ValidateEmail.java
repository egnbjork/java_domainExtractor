package berberyan;

public class ValidateEmail {
	public static boolean isValid(String email){
		return email.trim().matches((
				"([a-zA-Z0-9_]+@+[a-zA-Z0-9_]+\\.+[a-zA-Z]+(\\.+[a-zA-Z]+)?)"
				)) ? true : false;
	}
}
