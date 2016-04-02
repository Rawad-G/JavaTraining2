package encryptor1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileOperations {
	private String path;
	private boolean addDir;
	private String dirPath;

	public FileOperations(String path, boolean addDir, String dirPath) {
		this.path = path;
		this.addDir = addDir;
		this.dirPath = dirPath;

	}

	String readFile(){
		String text = "";
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(this.path));
			int val;
			while((val = reader.read()) != -1){
				text += (char)val;
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("invalid path, program stopped");
			System.exit(1);
		}
		return text;
	}

	void writeResult(String result, int key, String operation){
		String extension = this.path.substring(this.path.lastIndexOf('.')
				+ 1, this.path.length());
		String resultPath = this.path.substring(0, this.path.lastIndexOf('.'))
				+ "_" + operation + "." + extension;
		String keyPath = this.path.substring(0, this.path.
				lastIndexOf('\\')) + "\\" + "key." + extension;
		if(this.addDir){
			resultPath = resultPath.substring(0, resultPath.lastIndexOf('\\'))
					+ this.dirPath + 
					resultPath.substring(resultPath.lastIndexOf('\\'), resultPath.length());
			keyPath = keyPath.substring(0, keyPath.lastIndexOf('\\')) + this.dirPath + 
					keyPath.substring(keyPath.lastIndexOf('\\'), keyPath.length());

		}

		try {
			Writer writer = new FileWriter(resultPath);
			writer.write(result);
			writer.close();
			writer = new FileWriter(keyPath);
			writer.write("" + key);
			writer.close();
		} catch (IOException e) {
		}
	}

	String getPath(){
		return this.path;
	}
}
