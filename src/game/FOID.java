package game;

import java.awt.Graphics2D;

import com.zalinius.architecture.GameContainer;
import com.zalinius.architecture.Graphical;
import com.zalinius.architecture.Logical;

import levels.Level;
import levels.Level0;
import levels.Level1;

public class FOID implements Graphical, Logical{
	
	private Test t1;
	private Level level;

	public FOID() {
		level = new Level1();
	}

	public static void main(String[] args) {
		FOID foid = new FOID();
		foid.t1 = new Test();
		
		GameContainer game = new GameContainer(foid, foid);
		game.startGame();
	
	}

	@Override
	public void update(double delta) {
		t1.update(delta);
		level.update(delta);
	}

	@Override
	public void render(Graphics2D g) {	
		t1.render(g);
		level.render(g);
	}

}
