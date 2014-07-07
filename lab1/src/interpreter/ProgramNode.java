package interpreter;

public class ProgramNode extends Node{

	public Node commandListNode;
	
	@Override
	public void parse(Context context) throws ParseException {
		 
		context.skipToken("program");
		commandListNode = new CommandListNode();
		commandListNode.parse(context);
	
	}
	


}
