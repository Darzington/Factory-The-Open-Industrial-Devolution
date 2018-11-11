package game;

import java.awt.Color;
import java.awt.Graphics2D;
import com.zalinius.architecture.GameObject;

public class Test implements GameObject {
	
	double x, y;
	
	@Override
	public void update(double delta) {
		x += 60*delta;
		y += 60*delta;
	}

	@Override
	public void render(Graphics2D g) {	
		g.setColor(Color.MAGENTA);
		g.drawRect((int)x, (int)y, 50, 50);
	}
}
