package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class ShippingTruck extends Node {

	private ArrayList<Item> packedItems;
	
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
		super.render(g);
		g.setColor(Color.CYAN);
		g.drawRect(20, 500, 50, 50);
	}

}
