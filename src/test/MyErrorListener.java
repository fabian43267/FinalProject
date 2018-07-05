package test;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

import java.util.ArrayList;
import java.util.List;

public class MyErrorListener extends BaseErrorListener {

    private List<String> errors;

    public MyErrorListener() {
        errors = new ArrayList<>();
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line,
                            int charPositionInLine,
                            String msg,
                            RecognitionException e)
    {
        errors.add("An error occured on line " + Integer.toString(line) + " and column number " + Integer.toString(charPositionInLine) + " for input: " + msg); //+ offendingSymbol.toString());
    }

    public List<String> getErrors() {
        return errors;
    }
}

//Recognizer.removeErrorListeners(); 			// remove default reporting to stderr
//Recognizer.addErrorListener(myListener); 	// add your own error listener