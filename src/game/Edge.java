package game;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;

import com.zalinius.architecture.GameObject;
import com.zalinius.physics.Point2D;
import com.zalinius.physics.Vector2D;
import com.zalinius.utilities.Debug;
import com.zalinius.utilities.ZMath;
import com.zalinius.utilities.time.GameClock;

public class Edge implements GameObject {
	
	public static final double NORMAL_EDGE_SPEED = 50;
	
	public static double edgeSpeed;
	protected Point2D start, end;
	private Vector2D change;
	protected ArrayList<Item> currentItems;
	protected Node nextNode;	
	
	public Edge(Point2D start, Point2D end,  Node nextNode) {
		this.start = start;
		this.end = end;
		this.currentItems = new ArrayList<>();
		this.nextNode = nextNode;
		
		setSpeed(NORMAL_EDGE_SPEED);
	}

	public void inputItem(Item item)
	{
		currentItems.add(item);
	}
	
	protected void outputItem(Item item)
	{
		currentItems.remove(item);
		nextNode.inputItem(item);
	}
	
	private void setSpeed(double newSpeed)
	{
		this.edgeSpeed = newSpeed;
		change = new Vector2D(start, end)
					 .originVector();
		change = change.scale(edgeSpeed/change.length());
	}
	
	@Override
	public void update(double delta) {
		ArrayList<Item> removeMe = new ArrayList<>();
		
		Iterator<Item> it = currentItems.iterator();
		while(it.hasNext()) {
			Item item = it.next();
			
			Point2D newPos = item.getPosition();
			newPos = Point2D.add(newPos, change.scale(delta));

			newPos = ZMath.clamp(newPos, start, end);
			item.move(newPos);
			
			if(newPos.equals(end))
			{
				removeMe.add(item);
			}
		}
		
		it = removeMe.iterator();
		while(it.hasNext()) {
			Item item = it.next();
			outputItem(item);
		}
	}

	@Override
	public void render(Graphics2D g) {
		for (Item item : currentItems) {
			item.render(g);
		}
	}
	
	public Node getNextNode() {
		return nextNode;
	}
}
