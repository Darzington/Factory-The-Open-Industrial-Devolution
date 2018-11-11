package game;

import java.awt.*;
import java.util.ArrayList;

import com.zalinius.physics.Point2D;

public class Conveyor extends Edge {
	
	public Conveyor(Point2D start, Point2D end, Node nextNode) {
		super(start, end, nextNode);
	}

	@Override
	public void render(Graphics2D g) {	
		super.render(g);
		g.setColor(Color.WHITE);
		g.drawLine((int)start.x, (int)(start.y + Node.NODE_SIZE/2.0), (int)end.x, (int)(end.y + Node.NODE_SIZE/2.0));
	}
}
