package test.checker;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import checker.Checker;

public class CheckerTest {
	
	public final static String PROG_DIR = "src/test/sample_progs/";

	@Test
	public void testCorrectProgs() {
		assertEquals(Checker.checkProgram(PROG_DIR + "program1.txt").size(), 0);
		assertEquals(Checker.checkProgram(PROG_DIR + "program2.txt").size(), 0);
	}
	
	@Test
	public void testWrongProgs() {
		ArrayList<String> errors;
		errors = Checker.checkProgram(PROG_DIR + "wrong_program1.txt");
		System.out.println(errors.size());
		printErrors(errors);
		
	}
	
	public static void printErrors(ArrayList<String> errors) {
		for (String e : errors) {
			System.out.println(e);
		}
	}
	
	

}
