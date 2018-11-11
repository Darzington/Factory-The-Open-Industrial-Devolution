package game;

import java.awt.Shape;

import com.zalinius.architecture.input.Clickable;
import com.zalinius.physics.Point2D;

public class MachineBaseNode extends Node {

	Node connectedMachine;
	boolean controlsPower;
	
	public MachineBaseNode(boolean controlsPower, Edge outgoingEdge, Point2D center){
		super(outgoingEdge, center);
		this.controlsPower = controlsPower;
		if (!controlsPower)
		{
			isOn = false;	//so items will pass through
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
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Shape clickArea() {
				return getClickArea();
			}
		};
	}
}
