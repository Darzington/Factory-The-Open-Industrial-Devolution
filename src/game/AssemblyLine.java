package game;

public abstract class AssemblyLine {

	private Input input;
	
	public AssemblyLine(Input input) {
		this.input = input;
	}
	
	public void inputItem(Item item) {
		input.addToQueue(item);
	}

}
