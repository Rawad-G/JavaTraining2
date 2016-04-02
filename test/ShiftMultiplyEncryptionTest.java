package encryptor1;

import static org.junit.Assert.*;

import org.junit.Test;

import EncryptionAlgorithms.ShiftMultiplyEncryption;

public class ShiftMultiplyEncryptionTest {

	@Test
	public void test1() {
		ShiftMultiplyEncryption shift = new  ShiftMultiplyEncryption('E', 1);
		String res = shift.encryptText("abc");
		int key = shift.getKey();
		String result = "" + (char)('a' * key);
		result += (char)('b' * key);
		result += (char)('c' * key);
		
		assertEquals(result, res);
	}
	
	
	@Test
	public void test2() {
		ShiftMultiplyEncryption shift = new  ShiftMultiplyEncryption('E', 2);
		int key = shift.getKey();
		assertEquals(2, key);
	}

}
