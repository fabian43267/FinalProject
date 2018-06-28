package checker;

import java.util.HashMap;
import java.util.Stack;

public class Scope {
	private Stack<HashMap<String,Type>> scopes;
	
	public Scope() {
		scopes = new Stack<>();
		openScope();
	}
	
	public boolean addVariable(String id, Type type) {
		if (scopes.peek().containsKey(id)) {
			return false;
		} else {
			scopes.peek().put(id, type);
			return true;
		}
	}
	
	public boolean isDefined(String id) {
		boolean result = false;
		for (int i = scopes.size() - 1; i >= 0; i--) {
			result = result || scopes.get(i).containsKey(id);
		}
		return result;
	}
	
	public Type getType(String id) {
		for (int i = scopes.size() - 1; i >= 0; i--) {
			if (scopes.get(i).containsKey(id)) {
				return scopes.get(i).get(id);
			}
		}
		return null;
	}
	
	public boolean isInCurrentScope(String id) {
		return scopes.peek().containsKey(id);
	}
	
	public void openScope() {
		scopes.push(new HashMap<>());
	}
	
	public void closeScope() {
		scopes.pop();
	}

}
