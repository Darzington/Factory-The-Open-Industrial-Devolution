package game;

import java.awt.Rectangle;
import java.awt.Shape;

import com.zalinius.architecture.input.Clickable;

public class MachineBaseNode extends Node {

	Node connectedMachine;
	boolean controlsPower;
	
	public MachineBaseNode(Node connectedMachine, boolean controlsPower, Edge outgoingEdge){
		super(outgoingEdge);
		this.connectedMachine = connectedMachine;
		this.controlsPower = controlsPower;
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
					connectedMachine.togglePoweredState();
				}				
			}
			
			@Override
			public int mouseButtonCode() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Shape clickArea() {
				return new Rectangle(0, 0, Node.NODE_SIZE, Node.NODE_SIZE);
			}
		};
	}
}
