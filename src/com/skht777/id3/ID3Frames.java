/**
 * 
 */
package com.skht777.id3;

import java.util.ArrayList;

/**
 * @author skht777
 *
 */
@SuppressWarnings("serial")
public class ID3Frames extends ArrayList<ID3Frame> {
	
	private ByteWrapper frames;
	
	/**
	 * 
	 */
	public ID3Frames(ByteWrapper wrapper, ID3Header header) {
		super();
		frames = wrapper;
		ID3Frame.setVersion(header.getVersion());
		while(addFrame(ID3Frame.create(frames, stream().mapToInt(f -> f.getSize()).sum())));
	}
	
	private boolean addFrame(ID3Frame frame) {
		if(frame.toString().matches("\\w+")) return add(frame);
		return false;
	}

}
