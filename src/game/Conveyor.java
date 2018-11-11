package game;

import java.awt.*;
import java.util.ArrayList;

import com.zalinius.physics.Point2D;
import com.zalinius.utilities.time.GameClock;

public class Conveyor extends Edge {
	private static final int SECTION_WIDTH = 10;
	public Conveyor(Point2D start, Point2D end, Node nextNode) {
		super(start, end, nextNode);
	}

	@Override
	public void render(Graphics2D g) {	
		super.render(g);
		g.setColor(Color.WHITE);
		int inc = 1;
		if(end.x < start.x) {
			inc = -1;
		}
		for(int i = (int) start.x - inc*Node.HALF_NODE_SIZE; i != end.x + inc*Node.HALF_NODE_SIZE ; i += inc) {
			if(((i - (int)(GameClock.timeNow() * edgeSpeed * inc)) / SECTION_WIDTH) % 2 == 0) {
				g.setColor(Color.GRAY);
			}
			else {
				g.setColor(Color.WHITE);
			}
			g.drawLine(i, (int)(start.y + Node.HALF_NODE_SIZE), i+inc, (int)(start.y + Node.HALF_NODE_SIZE));
		}
	}
}
