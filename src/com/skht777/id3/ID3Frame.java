/**
 * 
 */
package com.skht777.id3;

import com.skht777.id3.ByteWrapper.ByteSupplier;

/**
 * @author skht777
 *
 */
public class ID3Frame {

	public static class ID3FrameHeader {

		private static int frameSize;
		private static int buffer;

		private FrameID id;
		private int size;
		private byte[] flag;

		ID3FrameHeader(ByteWrapper wrapper) {
			String idstr = wrapper.read(0, buffer).asString();
			id = idstr.matches("\\w+") ? FrameID.valueOf(idstr) : null;
			ByteSupplier bs = wrapper.read(wrapper.current(), buffer);
			size = version.equals(ID3Version.V24) ? bs.asSyncSafe() : bs.asInt();
			flag = version.equals(ID3Version.V22) ? new byte[2] : wrapper.read(wrapper.current(), 2).get();
		}

		public FrameID getId() {
			return id;
		}

		public int getSize() {
			return size;
		}

		public byte[] getFlag() {
			return flag;
		}
		
		@Override
		public String toString() {
			return getId().toString();
		}

	}

	private static ID3Version version;
	
	private ID3FrameHeader header;
	private ByteWrapper frame;

	/**
	 * 
	 */
	private ID3Frame(ID3FrameHeader header, ByteWrapper frame) {
		this.header = header;
		this.frame = frame;
	}
	
	static ID3Frame create(ByteWrapper frames, int off) {
		ID3FrameHeader header = new ID3FrameHeader(frames.split(off, ID3FrameHeader.frameSize));
		return new ID3Frame(header, frames.split(off + ID3FrameHeader.frameSize, header.getSize()));
	}
	
	static void setVersion(ID3Version ver) {
		version = ver;
		ID3FrameHeader.frameSize = version.equals(ID3Version.V22) ? 6 : 10;
		ID3FrameHeader.buffer = version.equals(ID3Version.V22) ? 3 : 4;
	}
	
	public ID3FrameHeader getHeader() {
		return header;
	}

	public ByteWrapper getFrame() {
		return frame;
	}
	
	public int getSize() {
		return ID3FrameHeader.frameSize + header.getSize();
	}
	
	@Override
	public String toString() {
		return getHeader().toString();
	}

}
