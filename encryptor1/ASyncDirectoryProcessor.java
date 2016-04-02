package encryptor1;

import java.io.File;
import java.util.ArrayList;

import EncryptionAlgorithms.EncryptionAlogorithm;

public class ASyncDirectoryProcessor implements IDirectoryProcessor{

	private String path;
	private EncryptionAlogorithm ea;
	private File fpath;
	private FileEncryptor fe;

	public ASyncDirectoryProcessor(String path, EncryptionAlogorithm ea){
		this.path = path;
		this.ea = ea;
		this.fpath = new File(this.path);
		fe = new FileEncryptor(this.ea);

		boolean dir = new File(this.path + "\\encrypted").mkdirs();
	}

	public void encryptDirectory() {		
		ArrayList<Thread> threadList = new ArrayList<Thread>();
		for(final File fileEntry : fpath.listFiles()) {
			if(fileEntry.isDirectory()) {
			} 
			else{
				Thread t = new Thread(){
					public void run(){
						String extension = fileEntry.getAbsolutePath().
								substring(fileEntry.getAbsolutePath().
										lastIndexOf('.') + 1, fileEntry.
										getAbsolutePath().length());
						
						
						if(extension.equals("txt")){
							FileOperations f = new FileOperations
									(fileEntry.getAbsolutePath(), true, "\\encrypted");
							fe.performAlgorithm(f);
						}
					}
				};
				threadList.add(t);
			}
		}

		for(int i = 0; i < threadList.size(); i++){
			threadList.get(i).start();
		}
	}

	public void decryptDirectory() {
		ArrayList<Thread> threadList = new ArrayList<Thread>();
		for(final File fileEntry : fpath.listFiles()) {
			if(fileEntry.isDirectory()) {
			} 
			else{
				Thread t = new Thread(){
					public void run(){
						String extension = fileEntry.getAbsolutePath().
								substring(fileEntry.getAbsolutePath().
										lastIndexOf('.') + 1,
										fileEntry.getAbsolutePath().length());
						if(extension.equals("txt")){
							FileOperations f = new FileOperations
									(fileEntry.getAbsolutePath(), true, "\\decrypted");
							fe.performAlgorithm(f);
						}
					}
				};
				threadList.add(t);
			}
		}

		for(int i = 0; i < threadList.size(); i++){
			threadList.get(i).start();
		}

	}

}
