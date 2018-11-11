package levels;

import game.AssemblyLine;

public class Level1 extends Level {

	public static final int N = 30;
	
	public Level1() {
		super(assemblyLine());
	}
	
	private static AssemblyLine assemblyLine() {
		return new Line1();
	}
}
