package game;

import java.awt.*;

import com.zalinius.physics.Point2D;

public class Conveyor extends Edge {

	public Conveyor(Point2D start, Point2D end) {
		super(1, start, end, new Node() {
			
			@Override
			protected Edge selectOutgoingEdge() {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}

	
	@Override
	public void render(Graphics2D g) {	
		super.render(g);
		g.setColor(Color.WHITE);
		g.drawLine((int)start.x, (int)start.y, (int)end.x, (int)end.y);
	}
}
