/**
 * 
 */
package com.skht777.id3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * @author skht777
 *
 */
public class ByteWrapper {
	
	public class ByteSupplier {
		
		private byte[] bytes;
		
		private ByteSupplier(byte[] b) {
			bytes = b.clone();
		}
		
		private ByteSupplier(int len) {
			bytes = new byte[len];
		}
		
		public byte[] get() {
			return bytes;
		}
		
		public byte get(int n) {
			return bytes[n];
		}
		
		public int getLength() {
			return bytes.length;
		}
		
		public String asString() {
			return asObject(ByteUtility::toString);
		}
		
		public int asInt() {
			return asObject(ByteUtility::toInt);
		}
		
		public IntStream stream() {
			return asObject(ByteUtility::stream);
		}
		
		public int asSyncSafe() {
			return asObject(ByteUtility::toSyncSafe);
		}
		
		public String asBynary(int split) {
			return asObject(b -> ByteUtility.toBinary(b, split));
		}
		
		public String asBynary() {
			return asObject(ByteUtility::toBinary);
		}
		
		public <T> T asObject(Function<byte[], T> func) {
			return func.apply(bytes);
		}
		
		@Override
		public String toString() {
			return asBynary(4);
		}
	}
	
	private byte[] bytes;
	private int pointer;
	
	public ByteWrapper(byte[] b) {
		bytes = b.clone();
		reset();
	}
	
	/**
	 * @throws IOException 
	 * 
	 */
	public ByteWrapper(String path) throws IOException {
		this(Files.readAllBytes(Paths.get(path)));
	}
	
	public ByteSupplier read(int off, int len) {
		setPointer(off, len);
		try(ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
			bos.write(bytes, off, len);
			return new ByteSupplier(bos.toByteArray());
		}catch(IOException e) {
			e.printStackTrace();
		}
		return new ByteSupplier(len);
	}
	
	public byte read(int off) {
		return read(off, 1).get(0);
	}
	
	public void write(byte[] b, int off, int len) {
		setPointer(off, len);
		System.arraycopy(b, 0, bytes, off, len);
	}
	
	public void write(byte[] b, int off) {
		write(b, off, b.length);
	}
	
	public void write(String s, int off, int len) {
		byte[] b = Arrays.copyOf(s.getBytes(), len);
		write(b, off, b.length);
	}
	
	public void write(String s, int off) throws IOException {
		write(s.getBytes(), off, s.getBytes().length);
	}
	
	public int getLength() {
		return bytes.length;
	}
	
	public ByteWrapper split(int off, int len) {
		return new ByteWrapper(ByteUtility.split(bytes, off, len));
	}
	
	public ByteWrapper split(int off) {
		return new ByteWrapper(ByteUtility.split(bytes, off));
	}
	
	public void reset() {
		setPointer(0);
	}
	
	public int current() {
		return pointer;
	}
	
	private void setPointer(int pos) {
		pointer = pos;
	}
	
	private void setPointer(int off, int len) {
		setPointer(off + len);
	}

}
