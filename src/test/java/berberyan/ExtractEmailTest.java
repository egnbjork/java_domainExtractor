package berberyan;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class ExtractEmailTest 
{
	
	@Test
	public void test_empty_string(){
		String emails = "";
		List <String> listOfEmails = ExtractEmail.getDomains(emails);
		assertTrue(listOfEmails.isEmpty());
	}
	
	@Test
	public void test_size_after_one_email_string_checked(){
		String email = "eork@gmail.com";
		List<String> listOfDomains = ExtractEmail.getDomains(email);
		assertEquals(listOfDomains.size(),1);		
	}
	
	@Test
	public void test_extract_domain_from_email(){
		String email = "erk@gmail.com";
		List<String> listOfDomains = ExtractEmail.getDomains(email);
		assertEquals(Arrays.asList("@gmail.com"), listOfDomains);
	}
	
	@Test
	public void test_extract_domain_from_email_with_spaces(){
		String email = " eork@gmail.com  ";
		List<String> listOfDomains = ExtractEmail.getDomains(email);
		assertEquals(Arrays.asList("@gmail.com"), listOfDomains);	
	}
	

	@Test
	public void test_size_after_different_emails_with_same_domain(){
		String email = "egnk@gmail.com, mysomeemail@gmail.com";
		List<String> listOfDomains = ExtractEmail.getDomains(email);
		assertEquals(listOfDomains.size(),1);	
	}
	
	@Test
	public void test_extract_domain_from_different_emails(){
		String email = "erk@gmail.com, mysomeemail@gmail.com";
		List<String> listOfDomains = ExtractEmail.getDomains(email);
		assertEquals(Arrays.asList("@gmail.com"), listOfDomains);	
	}
	
	@Test
	public void test_extract_domains_from_emails_with_diff_domains(){
		String email = "ek@gmail.com, mysomeemail@yahoo.com";
		List<String> listOfDomains = ExtractEmail.getDomains(email);
		assertEquals(Arrays.asList("@gmail.com", "@yahoo.com"), listOfDomains);	
	}
	
	@Test
	public void test_extract_domains_from_emails_with_diff_domains_with_spaces(){
		String email = " ejork@gmail.com,   mysomeemail@yahoo.com  ";
		List<String> listOfDomains = ExtractEmail.getDomains(email);
		assertEquals(Arrays.asList("@gmail.com", "@yahoo.com"), listOfDomains);	
	}
	
	@Test
	public void test_extract_domains_from_emails_with_diff_domains_not_sorted_with_spaces(){
		String email = " mysomeemail@yahoo.com, egnbjork@gmail.com  ";
		List<String> listOfDomains = ExtractEmail.getDomains(email);
		assertEquals(Arrays.asList("@gmail.com", "@yahoo.com"), listOfDomains);	
	}
	
	@Test
	public void test_pass_wrong_email_no_at_sign(){
		String email = "foo.m";
		List<String> listOfDomains = ExtractEmail.getDomains(email);
		assertTrue(listOfDomains.isEmpty());
	}
	
	@Test
	public void test_pass_wrong_email(){
		String email = "foo@m";
		List<String> listOfDomains = ExtractEmail.getDomains(email);
		assertTrue(listOfDomains.isEmpty());
	}
	
	@Test
	public void test_pass_good_and_wrong_email(){
		String email = "some@gmail.com, foo@m";
		List<String> listOfDomains = ExtractEmail.getDomains(email);
		assertEquals(Arrays.asList("@gmail.com"), listOfDomains);
	}
	
	@Test
	public void test_pass_wrong_and_good_email(){
		String email = "foo@m, some@gmail.com";
		List<String> listOfDomains = ExtractEmail.getDomains(email);
		assertEquals(Arrays.asList("@gmail.com"), listOfDomains);
	}
	
	@Test
	public void test_pass_wrong_and_two_good_emails(){
		String email = "foo@m, some@gmail.com, someother@aol.com";
		List<String> listOfDomains = ExtractEmail.getDomains(email);
		assertEquals(Arrays.asList("@aol.com", "@gmail.com"), listOfDomains);
	}
}
