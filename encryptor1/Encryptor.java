package encryptor1;

import java.util.Scanner;

import EncryptionAlgorithms.DoubleEncryption;
import EncryptionAlgorithms.EncryptionAlogorithm;
import EncryptionAlgorithms.ShiftUpEncryption;

public class Encryptor {
	public static void main(String[] args) throws InvalidEncryptionKeyException{
		EncryptionAlogorithm e;
		FileOperations f;
		int key = -1;
		Scanner sc = new Scanner(System.in);
		System.out.println("enter E for Encryption or D for Decryption");
		char method = sc.next().charAt(0);
		if(method == 'D'){
			System.out.println("enter a key for decryption");
			try{
				key = sc.nextInt();
			}catch(Exception exp){
				sc.close();
				throw new InvalidEncryptionKeyException("invalid key, key must be an integer");
			};
		}
		System.out.println("enter Yes to go to directory encrypt option and N for No");
		String dirOption = sc.next();
		if(dirOption.equals("Yes")){
			System.out.println("enter a path to the source directory");
			String dirPath = sc.next();
			SyncDirectoryProcessor sync = new SyncDirectoryProcessor(dirPath, new ShiftUpEncryption(method, -1));
			sync.encryptDirectory();
			sc.close();
			System.exit(0);
		}
		System.out.println("enter a path to the source file");
		String sourcePath = sc.next();
		sc.close();
		if(method == 'E'){
			e = new DoubleEncryption(new ShiftUpEncryption(method, -1));
		}
		else{
			e = new DoubleEncryption(new ShiftUpEncryption(method, key));
		}
		f = new FileOperations(sourcePath, false, null);
		FileEncryptor fe = new FileEncryptor(e);
		fe.performAlgorithm(f);
	}

}
