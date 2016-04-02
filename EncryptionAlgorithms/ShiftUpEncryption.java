package EncryptionAlgorithms;

public class ShiftUpEncryption extends ShiftEncryption
			implements EncryptionAlogorithm {

	public ShiftUpEncryption(char method, int key) {
		super(method, key);
	}

	public String encryotChar(char ch){
		return "" + (char)(ch + this.key);
	}


}
