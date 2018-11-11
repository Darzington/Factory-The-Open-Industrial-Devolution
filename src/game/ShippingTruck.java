package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.zalinius.physics.Point2D;

public class ShippingTruck extends Node {

	private ArrayList<Item> packedItems;
	
	public ShippingTruck(Point2D center) {
		super(null, center);
		packedItems = new ArrayList<>();
	}
	
	@Override
	public boolean inputItem(Item item)
	{
		packedItems.add(item);
		return true;
	}
	
	public ArrayList<Item> getPackedItem()
	{
		return packedItems;
	}
	
	@Override
	protected Edge selectOutgoingEdge() {
		return null;
	}
	
	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.CYAN);
		g.fill(getClickArea());
	}

}
