package levels;

import java.awt.Graphics2D;

import com.zalinius.architecture.GameObject;

import game.AssemblyLine;

public abstract class Level implements GameObject{

	private AssemblyLine line;
	
	public Level(AssemblyLine line) {
		this.line = line;
	}
	
	
	public void update(double delta) {
		line.update(delta);
	}

	@Override
	public void render(Graphics2D g) {
		line.render(g);
	}

}
