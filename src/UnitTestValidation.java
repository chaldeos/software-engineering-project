
import static org.junit.Assert.*;

import org.junit.Test;

public class UnitTestValidation {

	@Test
	public void testValidateUsername() {
		assertEquals("Result", "The username cannot be empty", Validation.validateUsername(""));
		assertEquals("Result", "The username cannot be empty", Validation.validateUsername(null));
		assertEquals("Result", "Username must be at least 4 characters", Validation.validateUsername("abc"));
		assertEquals("Result", null, Validation.validateUsername("Νίκος")); // If Username "Νίκος" not already exists in users table
		assertEquals("Result", null, Validation.validateUsername("abcd")); // If Username "abcd" not already exists in users table
	}
	
	@Test
	public void testValidatePassword() {
		assertEquals("Result", "The password cannot be empty", Validation.validatePassword(""));
		assertEquals("Result", "The password cannot be empty", Validation.validatePassword(null));
		assertEquals("Result", "Password must be at least 6 characters", Validation.validatePassword("12345"));
		assertEquals("Result", null, Validation.validatePassword("88888888"));
		assertEquals("Result", null, Validation.validatePassword("password"));
	}
	
	@Test
	public void testValidateFirstname() {
		assertEquals("Result", "The firstname cannot be empty", Validation.validateFirstname(""));
		assertEquals("Result", "The firstname cannot be empty", Validation.validateFirstname(null));
		assertEquals("Result", null, Validation.validateFirstname("Νίκος"));
		assertEquals("Result", null, Validation.validateFirstname("Αλ"));
	}
	
	@Test
	public void testValidateSurname() {
		assertEquals("Result", "The surname cannot be empty", Validation.validateSurname(""));
		assertEquals("Result", "The surname cannot be empty", Validation.validateSurname(null));
		assertEquals("Result", null, Validation.validateSurname("Νίκος"));
		assertEquals("Result", null, Validation.validateSurname("Αλ"));
	}
	
	@Test
	public void testValidateTin() {
		assertEquals("Result", "The Tax Identify Number cannot be empty", Validation.validateTin(""));
		assertEquals("Result", "The Tax Identify Number cannot be empty", Validation.validateTin(null));
		assertEquals("Result", "Invalid Tax Identify Number", Validation.validateTin("12345"));
		assertEquals("Result", "Invalid Tax Identify Number", Validation.validateTin("12345678"));
		assertEquals("Result", "Invalid Tax Identify Number", Validation.validateTin("12345678a"));
		assertEquals("Result", "Invalid Tax Identify Number", Validation.validateTin("a12345678"));
		assertEquals("Result", "Invalid Tax Identify Number", Validation.validateTin("asdzxcqwe"));
		assertEquals(null, Validation.validateTin("123456789"));
	}
	
	@Test
	public void testValidateAddress() {
		assertEquals("Result", "The address cannot be empty", Validation.validateAddress(""));
		assertEquals("Result", "The address cannot be empty", Validation.validateAddress(null));
		assertEquals("Result", null, Validation.validateAddress("Πηλέως 55"));
		assertEquals("Result", null, Validation.validateAddress("Πηλέως"));
	}
	
	@Test
	public void testValidatePhone() {
		assertEquals("Result", "The phone cannot be empty", Validation.validatePhone(""));
		assertEquals("Result", "The phone cannot be empty", Validation.validatePhone(null));
		assertEquals("Result", "Invalid phone number", Validation.validatePhone("12345"));
		assertEquals("Result", "Invalid phone number", Validation.validatePhone("12345678"));
		assertEquals("Result", "Invalid phone number", Validation.validatePhone("12345678a"));
		assertEquals("Result", "Invalid phone number", Validation.validatePhone("a12345678"));
		assertEquals("Result", "Invalid phone number", Validation.validatePhone("asdzxcqwe"));
		assertEquals("Result", null, Validation.validatePhone("1234567890"));
	}
	
	@Test
	public void testValidateSex() {
		assertEquals("Result", null, Validation.validateSex(0));
		assertEquals("Result", null, Validation.validateSex(1));
		assertEquals("Result", "Invalid sex value", Validation.validateSex(2));
		assertEquals("Result", "Invalid sex value", Validation.validateSex(-1));
	}
	
	@Test
	public void testValidateType() {
		assertEquals("Result", null, Validation.validateType(0));
		assertEquals("Result", null, Validation.validateType(1));
		assertEquals("Result", null, Validation.validateType(2));
		assertEquals("Result", "Invalid user type value", Validation.validateType(4));
		assertEquals("Result", "Invalid user type value", Validation.validateType(-1));
	}
	
	@Test
	public void testValidateReport() {
		assertEquals("Result", "The report cannot be empty", Validation.validateReport(null));
		assertEquals("Result", "The report cannot be empty", Validation.validateReport(""));
		assertEquals("Result", null, Validation.validateReport("fhcgncfgncfg"));
		assertEquals("Result", null, Validation.validateReport("a"));
	}
	
	@Test
	public void testIsNumeric() {
		assertEquals("Result1", true, Validation.isNumeric("65165165"));
		assertEquals("Result2", true, Validation.isNumeric("0"));
		assertEquals("Result3", false, Validation.isNumeric("-6165"));
		assertEquals("Result4", false, Validation.isNumeric("4s"));
		assertEquals("Result5", false, Validation.isNumeric("d5"));
		assertEquals("Result6", false, Validation.isNumeric("dfhxfg"));
		assertEquals("Result7", false, Validation.isNumeric("516515f"));
	}

}