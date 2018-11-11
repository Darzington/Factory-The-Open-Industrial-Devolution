package game;

import java.awt.Color;
import java.awt.Graphics2D;

import com.zalinius.physics.Point2D;

public class FillerMachine extends MachineBaseNode {
	
	
	private FillerFunction fillerFunction;
	private StorageNode storage;
	private boolean itemRuined = false;

	public FillerMachine(Edge outgoingEdge, double holdTime, Point2D center, FillerFunction fillerFunction) {
		super(true, outgoingEdge, holdTime, center);
		this.fillerFunction = fillerFunction;
		setConnectedMachine(this);	//Can turn itself off and on
	}
	
	public void connectToStorageNode(StorageNode storage)
	{
		this.storage = storage;
	}
	
	@Override
	public boolean inputItem(Item item)
	{		
		if(super.inputItem(item) && storage != null && storage.isFull())
		{
			storage.outputItem();
		}
		
		if(isOn && (storage == null || storage.isFull()))
		{
			if (!fillerFunction.fill(item))
			{
				currentItem = new Garbage(item.getHeight(), item.getColor());
			}
		}	

		return true;
	}
		
	@Override
	public void feedInItem(Item item)
	{
		if(currentItem == null)
		{
			super.outputItem(item);
		}
		else
		{
			item = null;	//item is added to the product or turned to garbage
		}
	}
	
	@Override
	public void render(Graphics2D g) {
		if (isOn)
			g.setColor(Color.BLUE);
		else
			g.setColor(Color.RED);
		g.draw(getClickArea());
	}

}
