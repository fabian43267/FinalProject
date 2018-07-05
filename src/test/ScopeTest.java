package test;

import static org.junit.Assert.*;

import org.junit.Test;

import checker.Scope;
import checker.Type;

public class ScopeTest {

	@Test
	public void test() {
		// create scope and add two variables
		Scope scope = new Scope();
		scope.addVariable("a", Type.INT);
		scope.addVariable("b", Type.CHAR);
		
		// open new scope and add c
		scope.openScope();
		scope.addVariable("c", Type.INT);
		
		// a and b should still be defined
		assertTrue(scope.isDefined("a"));
		assertTrue(scope.isDefined("b"));
		
		// add another a
		scope.addVariable("a", Type.BOOL);
		
		// this should be the last defined variable
		assertEquals(scope.getType("a"),Type.BOOL); 
		
		// when closing the scope, type should be int again
		scope.closeScope();
		assertEquals(scope.getType("a"), Type.INT);
	}
}
