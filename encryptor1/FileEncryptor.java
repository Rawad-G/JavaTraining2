package encryptor1;

import EncryptionAlgorithms.EncryptionAlogorithm;

public class FileEncryptor {

	EncryptionAlogorithm ea;

	public FileEncryptor(EncryptionAlogorithm ea) {
		this.ea = ea;
	}

	public void performAlgorithm(FileOperations f){

		if(this.ea.getMethod() == 'E')
			encryptFile(f);
		else
			decryptFile(f);

	}
	public void encryptFile(FileOperations f){
		String content = f.readFile();
		String res = this.ea.encryptText(content);
		f.writeResult(res, this.ea.getKey(), "encrypted");
	}

	public void decryptFile(FileOperations f){
		String content = f.readFile();
		String res = "";
		try {
			res = this.ea.decryptText(content);
		} catch (InvalidEncryptionKeyException e) {
			System.exit(1);
		}
		f.writeResult(res, this.ea.getKey(), "decrypted");
		String sourcePath = f.getPath();
		System.out.println("the decrypted file is at the following location " 
				+ sourcePath.substring(0, sourcePath.lastIndexOf('\\')));


	}

}
