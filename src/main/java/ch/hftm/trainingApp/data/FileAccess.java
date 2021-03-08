package ch.hftm.trainingApp.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import ch.hftm.trainingApp.application.*;

public class FileAccess {

	private final static String LASTFILEINFOPATH = "FileInfo.ser";

	private static Path defaultPath = Paths.get("C:/TRAINING");
	private static String actualFile = "";

	public static String getActualDirectoryString() {
		return defaultPath.toString();
	}

	public static String getActualFileString() {
		return actualFile;
	}

	public static void initializeActualPath() throws ClassNotFoundException, IOException {
		FileInfo lastFileInfo = deSerializeFileInfo();
		if (lastFileInfo != null) {
			defaultPath = Paths.get(lastFileInfo.getDirPath());
			actualFile = lastFileInfo.getFileName();
		}
	}

	// Save the File
	public static void saveFile(String pathStr, String content) throws IOException {
		Path path = preparePath(pathStr);

		if (!Files.exists(path.getParent())) {
			Files.createDirectories(path.getParent());
		}

		BufferedWriter writer = Files.newBufferedWriter(path, 
			Charset.forName("UTF-8"),
			StandardOpenOption.CREATE,
			StandardOpenOption.APPEND);
		writer.write(content);
		writer.close();

		serializeFileInfo(new FileInfo(path.getFileName().toString(), path.getParent().toString()));
	}

	// Read (load) the File	
	public static String readFile(String pathStr) throws IOException {
		Path path = preparePath(pathStr);

		StringBuilder content = new StringBuilder();
		BufferedReader reader = Files.newBufferedReader(path);
		String line = reader.readLine();
		while (line != null) {
			content.append(line + "\n");
			line = reader.readLine();
		}
		reader.close();

		return content.toString();
	}

	private static Path preparePath(String pathStr) {
		Path path = defaultPath.resolve(pathStr);
		path = path.normalize();
		defaultPath = path.getParent();
		actualFile = path.getFileName().toString();
		return path;
	}

	private static void serializeFileInfo(FileInfo c) throws IOException {
		FileOutputStream fileOut = new FileOutputStream(LASTFILEINFOPATH);
		ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
		objOut.writeObject(c);
		objOut.close();
		fileOut.close();
	}

	private static FileInfo deSerializeFileInfo() throws IOException, ClassNotFoundException {
		if (Files.exists(Paths.get(LASTFILEINFOPATH))) {
			FileInputStream fileIn = new FileInputStream(LASTFILEINFOPATH);
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			FileInfo file = (FileInfo) objIn.readObject();
			objIn.close();
			return file;
		}
		return null;
	}

}