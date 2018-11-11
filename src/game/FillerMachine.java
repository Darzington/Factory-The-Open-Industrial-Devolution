package game;

import java.awt.Color;
import java.awt.Graphics2D;

import com.zalinius.physics.Point2D;

public class FillerMachine extends MachineBaseNode {
	
	
	private FillerFunction fillerFunction;
	private StorageNode storage;

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
	protected void outputItem(Item item)
	{
		if(isOn && (storage == null || storage.isFull()))
		{
			if (fillerFunction.fill(item))
			{
				super.outputItem(item);
			}
			else
			{
				super.outputItem(new Garbage(item.getHeight(), item.getColor()));
			}
		}
		else
		{
			super.outputItem(item);
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
