package game;

import java.awt.Shape;
import java.awt.event.MouseEvent;

import com.zalinius.architecture.GameStage;
import com.zalinius.architecture.input.Clickable;
import com.zalinius.physics.Point2D;
import com.zalinius.utilities.time.GameClock;

public class MachineBaseNode extends TimedNode {

	Node connectedMachine;
	boolean controlsPower;
	
	public MachineBaseNode(boolean controlsPower, Edge outgoingEdge, double holdTime, Point2D center){
		super(outgoingEdge, holdTime, center);
		this.controlsPower = controlsPower;
		if (!controlsPower)
		{
			isOn = false;	//so items will pass through
		}
		else
		{
			GameStage.addInput(getControls());
		}
	}
	
	@Override
	public boolean inputItem(Item item)
	{
		if (super.inputItem(item))
		{
			return true;
		}
		else
		{
			super.outputItem(item);
			return false;
		}
	}
	
	public void setConnectedMachine(Node connectedMachine)
	{
		this.connectedMachine = connectedMachine;

	}
	
	public Clickable getControls()
	{
		return new Clickable() {
			
			@Override
			public void mouseReleased() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked() {
				if (connectedMachine != null && controlsPower)
				{
					connectedMachine.togglePoweredStatus();
				}				
			}
			
			@Override
			public int mouseButtonCode() {
				return MouseEvent.BUTTON1;
			}
			
			@Override
			public Shape clickArea() {
				return getClickArea();
			}
		};
	}
}
