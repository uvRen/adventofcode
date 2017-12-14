package com.adventofcode.keypad;

public interface IKeyPad {
	
	/**
	 * Moves across the KeyPad according to the commands that are sent
	 * in as parameters. 
	 * @param commands List with moves that will be performed
	 * @return Returns the button that is the last position after all moves has been performed
	 */
	public String move(String commands);
}
