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
		g.drawLine((int)start.x - Node.HALF_NODE_SIZE, (int)(start.y + Node.HALF_NODE_SIZE), (int)end.x + Node.HALF_NODE_SIZE, (int)(end.y + Node.HALF_NODE_SIZE));
	}
}
