/**
 * 
 */
package com.skht777.id3;

/**
 * @author skht777
 *
 */
public class ID3Header {

	private String identifier;
	private ID3Version version;
	private byte flag;
	private int size;

	/**
	 * 
	 */
	ID3Header(ByteWrapper wrapper) {
		identifier = wrapper.read(0, 3).asString();
		version = ID3Version.toID3Version(wrapper.read(wrapper.current(), 2).get(0));
		flag = wrapper.read(wrapper.current());
		size = wrapper.read(wrapper.current(), 4).asSyncSafe();
	}

	public String getIdentifier() {
		return identifier;
	}

	public ID3Version getVersion() {
		return version;
	}

	public byte getFlag() {
		return flag;
	}

	public int getSize() {
		return size;
	}

}
