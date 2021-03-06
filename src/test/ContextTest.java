package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import checker.Checker;

public class ContextTest {
	
	public final static String PROG_DIR = "src/test/sample_progs/";

	@Test
	public void testCorrectProgs() {
		assertEquals(Checker.checkProgram(PROG_DIR + "program1.txt").size(), 0);
		assertEquals(Checker.checkProgram(PROG_DIR + "program2.txt").size(), 0);
	}
	
	@Test
	public void testWrongProgs() {
		ArrayList<String> errors;
		
		System.out.println("-- wrong_program1.txt --");
		errors = Checker.checkProgram(PROG_DIR + "wrong_program1.txt");
		printErrors(errors);
		assertEquals(errors.size(), 2);
		
		System.out.println("-- wrong_program2.txt --");
		errors = Checker.checkProgram(PROG_DIR + "wrong_program2.txt");
		printErrors(errors);
		assertEquals(errors.size(), 2);
	}
	
	public static void printErrors(ArrayList<String> errors) {
		for (String e : errors) {
			System.out.println(e);
		}
	}
	
	

}
