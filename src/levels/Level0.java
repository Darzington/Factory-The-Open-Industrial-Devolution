package levels;

import game.AssemblyLine;

public class Level0 extends Level {

	public Level0() {
		super(assemblyLine());
	}
	
	private static AssemblyLine assemblyLine() {
		return new Line0();
	}

}
