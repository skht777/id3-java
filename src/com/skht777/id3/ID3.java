/**
 * 
 */
package com.skht777.id3;

import java.io.IOException;

/**
 * @author skht777
 *
 */
public class ID3 {
	
	private ByteWrapper id3;
	private ID3Header header;
	private ID3Frames frames;
	
	
	/**
	 * @throws IOException 
	 * 
	 */
	public ID3(String path) throws IOException {
		id3 = new ByteWrapper(path);
		header = new ID3Header(id3.split(0, 10));
		frames = new ID3Frames(id3.split(10, header.getSize()), header);
	}
	
	public ID3Header getHeader() {
		return header;
	}
	
	public ID3Frames getFrames() {
		return frames;
	}

}
