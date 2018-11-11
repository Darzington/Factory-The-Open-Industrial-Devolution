package game;

import java.awt.Color;
import java.awt.Graphics2D;

import com.zalinius.physics.Point2D;

public class FillerMachine extends MachineBaseNode {
	
	public enum Filler { CEREAL, PRIZE }
	
	private Filler fillerType;
	private StorageNode storage;

	public FillerMachine(Edge outgoingEdge, double holdTime, Point2D center, Filler fillerType) {
		super(true, outgoingEdge, holdTime, center);
		this.fillerType = fillerType;
		setConnectedMachine(this);	//Can turn itself off and on
	}
	
	public void connectToStorageNode(StorageNode storage)
	{
		this.storage = storage;
	}
	
	@Override
	protected void outputItem(Item item)
	{
		if(isOn)
		{
			CerealBox temp = new CerealBox();
			boolean garbage = false;
			switch(fillerType)
			{
			case CEREAL:
			{
				if (temp.isSameItem(item))
				{
					temp = (CerealBox)item;
					if (temp.addCereal())
					{
						super.outputItem(temp);
					}
					else
					{
						garbage = true;
					}
				}
				else
				{
					garbage = true;
				}
				break;
			}
			
			case PRIZE:
			{
				temp.addCereal();
				if (temp.isSameItem((CerealBox)item))
				{
					temp = (CerealBox)item;
					if(storage != null && storage.isFull())
					{
						if (temp.addPrize())
						{
							super.outputItem(temp);
						}
						else
						{
							garbage = true;
						}
					}
					else
					{
						super.outputItem(item);
					}
				}
				else
				{
					garbage = true;
				}
				break;
			}	
			
			
			}
			
			if(garbage)
			{
				super.outputItem(new Garbage(item.getHeight(), item.getColor()));
			}
		}
		else
		{
			super.outputItem(item);	//we shouldn't be in this function if off, but just in case
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
