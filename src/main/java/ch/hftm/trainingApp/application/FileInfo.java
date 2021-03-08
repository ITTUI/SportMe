package ch.hftm.trainingApp.application;
import java.io.Serializable;

public class FileInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	// Fields
	private String fileName;
	private String dirPath;
	
	// Constructor
	public FileInfo() {
	}
	
	public FileInfo(String fileName, String dirPath) {
		this.fileName = fileName;
		this.dirPath = dirPath;
	}

	// Getter and Setter
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDirPath() {
		return dirPath;
	}

	public void setDirPath(String dirPath) {
		this.dirPath = dirPath;
	}
}