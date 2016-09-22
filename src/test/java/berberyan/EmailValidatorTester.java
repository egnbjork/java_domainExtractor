package berberyan;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmailValidatorTester {
	
	@Test
	public void test_validate_empty_string(){
		String email = "";
		boolean emailIsValid = ValidateEmail.isValid(email);
		assertFalse(emailIsValid);	
	}
	
	@Test
	public void test_validate_string_with_spaces_only(){
		String email = "";
		boolean emailIsValid = ValidateEmail.isValid(email);
		assertFalse(emailIsValid);	
	}
	
	@Test
	public void test_valid_email(){
		String email = "some@gmail.com";
		boolean emailIsValid = ValidateEmail.isValid(email);
		assertTrue(emailIsValid);
	}
	
	@Test
	public void test_valid_email_with_spaces(){
		String email = "  some@gmail.com ";
		boolean emailIsValid = ValidateEmail.isValid(email);
		assertTrue(emailIsValid);
	}
	
	@Test
	public void test_not_valid_email_ends_with_at(){
		String email = "some@";
		boolean emailIsValid = ValidateEmail.isValid(email);
		assertFalse(emailIsValid);
	}
	
	@Test
	public void test_not_valid_email_without_domain(){
		String email = "some@m";
		boolean emailIsValid = ValidateEmail.isValid(email);
		assertFalse(emailIsValid);
	}
	
	@Test
	public void test_not_valid_email_without_at(){
		String email = "some.m";
		boolean emailIsValid = ValidateEmail.isValid(email);
		assertFalse(emailIsValid);
	}
}
