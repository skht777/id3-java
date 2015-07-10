/**
 * 
 */
package com.skht777.id3;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author skht777
 *
 */
public final class ByteUtility {

	public static IntStream stream(byte[] b) {
		return IntStream.range(0, b.length).map(i -> b[i] & 0xff);
	}
	
	public static int toSyncSafe(byte[] b) {
		byte[] byte32 = Arrays.copyOf(b, 4);
		return ((byte32[0] & 0xff) << 21) + ((byte32[1] & 0xff) << 14) + ((byte32[2] & 0xff) << 7) + (byte32[3] & 0xff);
	}
	
	public static int toInt(byte[] b) {
		if(b.length < 4) {
			byte[] tmp = new byte[4];
			IntStream.rangeClosed(1, b.length).forEachOrdered(i -> tmp[tmp.length - i] = b[b.length - i]);
			return ByteBuffer.wrap(tmp).asIntBuffer().get();
		}
		return ByteBuffer.wrap(b).asIntBuffer().get();
	}
	
	public static String toString(byte[] b) {
		return new String(b);
	}
	
	public static String toBynary(byte[] b, int split) {
		return IntStream.range(0, b.length / split)
				.mapToObj(i -> ByteUtility.split(b, i, split)).map(ByteUtility::toBynary)
				.collect(Collectors.joining("\n"));
	}
	
	public static String toBynary(byte[] b) {
		return ByteUtility.stream(b).mapToObj(ByteUtility::toBynary).collect(Collectors.joining(" "));
	}
	
	public static String toBynary(int b) {
		return String.format("0x%08X", b & 0xff);
	}
	
	public static byte[] split(byte[] src, int off, int len) {
		byte[] split = new byte[len];
		System.arraycopy(src, off, split, 0, len);
		return split;
	}
	
	public static byte[] split(byte[] src, int off) {
		return ByteUtility.split(src, off, src.length - off);
	}

}
