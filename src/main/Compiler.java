package main;

import java.io.File;
import java.nio.file.Path;

public class Compiler {
	
	private final static String MAC_DIR = "/Users/ducu97/IntelliJProjects/FinalProject/src/test/sample_progs/";
	private final static String ECLIPSE_DIR = "src/test/sample_progs/";

	public static void main(String[] args) {
		// generate path to file
		Path progPath;
		if (args.length > 0) {
			progPath = new File(MAC_DIR + args[0]).toPath();
		} else {
			progPath = new File(ECLIPSE_DIR + "program12.txt").toPath();
		}
		//SprilGenerator.generate(progPath);


	}

}
