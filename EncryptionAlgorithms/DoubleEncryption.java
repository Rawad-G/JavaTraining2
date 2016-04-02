package EncryptionAlgorithms;

import encryptor1.InvalidEncryptionKeyException;

public class DoubleEncryption implements EncryptionAlogorithm {

	private EncryptionAlogorithm ea;

	public DoubleEncryption(EncryptionAlogorithm ea) {
		this.ea = ea;
	}
	public String encryptText(String text) {
		String res = this.ea.encryptText(text);
		return this.ea.encryptText(res);
	}
	public String decryptText(String text) throws InvalidEncryptionKeyException {
		return this.ea.decryptText(text);
	}

	public int getKey(){
		return ea.getKey();
	}

	public char getMethod(){
		return this.ea.getMethod();
	}

	public int getKeyStrength(){
		return this.ea.getKeyStrength();
	}

}
