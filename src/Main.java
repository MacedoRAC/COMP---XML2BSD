import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Main {
	 public static void main(String[] args) {
	        try{
				CharStream input = new ANTLRFileStream(args[0]);
				compLexer lexer = new compLexer(input);
				CommonTokenStream tokens = new CommonTokenStream(lexer);
				comp parser = new comp(tokens);
	            ParseTree tree = parser.start();
	            ParseTreeWalker walker = new ParseTreeWalker();
	            MyCompListener listener = new MyCompListener();
	            walker.walk(listener, tree);
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }

	   }
}