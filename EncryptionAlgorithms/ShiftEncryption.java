package EncryptionAlgorithms;

import java.util.Random;

import encryptor1.InvalidEncryptionKeyException;

public class ShiftEncryption implements EncryptionAlogorithm{
	protected char method;
	protected int key;

	public ShiftEncryption(char method, int key) {
		this.method = method;
		if(key == -1){
		}
		else{
			this.key = key;
		}

	}
	public String encryptText(String text){
		Random rand = new Random();
		this.key = rand.nextInt(5) + 1;
		
		String encryptedText = "";
		for(int i = 0; i < text.length(); i++){
			encryptedText += encryotChar(text.charAt(i));
		}
		return encryptedText;
	}
	public String encryotChar(char ch){
		return "" + (char)(ch + this.key);
	}

	public String decryptText(String text) throws InvalidEncryptionKeyException{
		try {
			Integer.parseInt("" + this.key);
		} catch (Exception e) {
			throw new InvalidEncryptionKeyException("invalid key, key must be an integer");
		}
		if(this.key < 0){
			throw new InvalidEncryptionKeyException("invalid key, key must be a positive");
		}
		String decryptedText = "";
		for(int i = 0; i < text.length(); i++){
			decryptedText += "" + (char)(text.charAt(i) - this.key);
		}
		return decryptedText;
	}

	public int getKey(){
		return this.key;
	}

	public char getMethod(){
		return this.method;
	}

	public int getKeyStrength(){
		return 2;
	}


}
