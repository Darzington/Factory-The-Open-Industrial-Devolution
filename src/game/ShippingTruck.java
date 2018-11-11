package game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.zalinius.physics.Point2D;
import com.zalinius.utilities.Debug;

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
	
	public void validateContents() {
		int total = packedItems.size();
		int valid = (int) packedItems.stream().filter(item -> item.isComplete()).count();
		int invalid = total - valid;
		
		Debug.log("There are " + valid + " valid items.");
		Debug.log("There are " + invalid + " invalid items.");
		Debug.log("For a grand total of " + total + " items.");
	}
	
	@Override
	protected Edge selectOutgoingEdge() {
		return null;
	}
	
	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.CYAN);
		g.draw(getClickArea());
	}

}
