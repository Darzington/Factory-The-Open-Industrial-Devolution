package game;

import java.awt.Color;
import java.awt.Graphics2D;

import com.zalinius.physics.Point2D;

public class Pipe extends Edge {

	private static final int OUTER_PIPE_WIDTH = 24;
	private static final int INNER_PIPE_WIDTH = 20;
	
	public Pipe(Point2D start, Point2D end, Node nextNode) {
		super(start, end, nextNode);
	}

	@Override
	public void render(Graphics2D g) {	
		super.render(g);
		
		for (Item item : getContents()) {
			if(item.getPosition().y > start.y + INNER_PIPE_WIDTH*2 && item.getPosition().y < end.y - INNER_PIPE_WIDTH * 2 + 4) {
				drawBulge(g, item.getPosition(), item.getWidth(), item.getHeight());
			}
		}
		
		drawPipe(g);
		
		
		
		drawFastener(Point2D.add(start, new Point2D(0,Node.HALF_NODE_SIZE)), g);
		drawFastener(Point2D.add(end, new Point2D(0,-Node.HALF_NODE_SIZE)), g);
		int inc = 1;
		if(end.y < start.y) {
			inc = -1;
		}
	}
	
	private void drawFastener(Point2D center, Graphics2D g) {
		g.setColor(Color.RED.darker());
		g.fillRect((int)center.x - OUTER_PIPE_WIDTH / 2, (int)center.y - OUTER_PIPE_WIDTH / 4 , OUTER_PIPE_WIDTH, OUTER_PIPE_WIDTH/2);
	}
	
	private void drawBulge(Graphics2D g, Point2D center, double width, double height) {
		g.setColor(Color.RED);
		int bulgeWidth = (int)(INNER_PIPE_WIDTH + width/2);
		int bulgeHeight = (int)(INNER_PIPE_WIDTH + height/2);
		g.fillOval((int)(center.x - bulgeWidth/2.0 - center.y/40 % 1), (int)(center.y - (INNER_PIPE_WIDTH + height/2)/2), bulgeWidth, bulgeHeight);
	}
	
	private void drawPipe(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillRect((int)start.x - INNER_PIPE_WIDTH/2, (int)start.y + Node.HALF_NODE_SIZE, INNER_PIPE_WIDTH, (int)end.y - (int)start.y - Node.NODE_SIZE);
	}

}
