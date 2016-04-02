package EncryptionAlgorithms;

public class ShiftMultiplyEncryption extends ShiftEncryption
			implements EncryptionAlogorithm {
	
	public ShiftMultiplyEncryption(char method, int key) {
		super(method, key);
	}
	
	public String encryotChar(char ch){
		return "" + (char)(ch * this.key);
	}

}
