package encryptor1;

import java.io.File;

import EncryptionAlgorithms.EncryptionAlogorithm;

public class SyncDirectoryProcessor implements IDirectoryProcessor {

	private String path;
	private EncryptionAlogorithm ea;
	private File fpath;
	private FileEncryptor fe;

	public SyncDirectoryProcessor(String path, EncryptionAlogorithm ea){
		this.path = path;
		this.ea = ea;
		this.fpath = new File(this.path);
		fe = new FileEncryptor(this.ea);

		boolean dir = new File(this.path + "\\encrypted").mkdirs();
	}
	public void encryptDirectory() {
		for(final File fileEntry : fpath.listFiles()) {
			if(fileEntry.isDirectory()) {
			} 
			else{
				String extension = fileEntry.getAbsolutePath().
						substring(fileEntry.getAbsolutePath().
								lastIndexOf('.') + 1, fileEntry.getAbsolutePath().length());
				if(extension.equals("txt")){
					FileOperations f = new FileOperations
							(fileEntry.getAbsolutePath(), true, "\\encrypted");
					fe.performAlgorithm(f);
				}
			}
		}
	}

	public void decryptDirectory() {
		for(final File fileEntry : fpath.listFiles()) {
			if(fileEntry.isDirectory()) {
			} 
			else{
				String extension = fileEntry.getAbsolutePath().
						substring(fileEntry.getAbsolutePath().
								lastIndexOf('.') + 1, fileEntry.getAbsolutePath().length());
				if(extension.equals("txt")){
					FileOperations f = new FileOperations
							(fileEntry.getAbsolutePath(), true, "\\decrypted");
					fe.performAlgorithm(f);
				}
			}
		}
	}

}
