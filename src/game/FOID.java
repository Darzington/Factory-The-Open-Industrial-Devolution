package game;

import java.awt.Graphics2D;

import com.zalinius.architecture.GameContainer;
import com.zalinius.architecture.IGraphical;
import com.zalinius.architecture.ILogical;

public class FOID implements IGraphical, ILogical{

	public FOID() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		FOID foid = new FOID();
		GameContainer game = new GameContainer(foid, foid);
		game.startGame();
	}

	@Override
	public void update(double delta) {
		
	}

	@Override
	public void render(Graphics2D g) {		
	}

}
