package game;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.zalinius.architecture.GameObject;
import com.zalinius.physics.Point2D;
import com.zalinius.utilities.Debug;

public class Node implements GameObject {
	
	public final static int NODE_SIZE = 50;

	protected Item currentItem;
	protected ArrayList<Edge> outgoingEdges;
	protected boolean isOn;
	protected Point2D center;
	
	public Node()	
	{
		this.outgoingEdges = new ArrayList<>();
		isOn = true;
		center = new Point2D(0,0);
	}
	
	public Node(Point2D center)	
	{
		this.outgoingEdges = new ArrayList<>();
		isOn = true;
		this.center = center;
	}
	
	public Node(Edge outgoingEdge, Point2D center)	
	{
		this();
		this.center = center;
		
		if(outgoingEdge != null) {
			outgoingEdges.add(outgoingEdge);
		}
	}
	
	public boolean inputItem(Item item)
	{
		if (!isFull() && isOn)
		{
			currentItem = item;
			return true;
		}
		else
		{
			outputItem(item);
			return false;
		}
	}
	
	protected void outputItem()
	{
		outputItem(currentItem);
		currentItem = null;	
	}
	
	protected void outputItem(Item item)
	{
		Edge correctEdge = selectOutgoingEdge();
		correctEdge.inputItem(item);
	}
	
	public boolean isFull() {
		return currentItem != null;
	}
	
	protected Edge selectOutgoingEdge()
	{
		return outgoingEdges.get(0);
	}

	
	public void addOutgoingEdge(Edge newEdge)
	{
		outgoingEdges.add(newEdge);
	}
	
	public void togglePoweredStatus()
	{
		isOn = !isOn;
	}
	
	public boolean isOn()
	{
		return isOn;
	}
	
	public Point2D getCenter()
	{
		return center;
	}
	
	public Rectangle getClickArea()
	{
		return new Rectangle((int)(center.x - NODE_SIZE/2.0) , (int)(center.y - NODE_SIZE/2.0), NODE_SIZE, NODE_SIZE);
	}
	
	public void drawRectangle(Graphics2D g)
	{
		g.draw(getClickArea());
	}
	
	@Override
	public void update(double delta) {

	}
	
	@Override
	public void render(Graphics2D g) {	

	}
}