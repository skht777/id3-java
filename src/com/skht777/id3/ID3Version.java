/**
 * 
 */
package com.skht777.id3;

import java.util.Arrays;

/**
 * @author skht777
 *
 */
public enum ID3Version {
	
	V22(2), V23(3), V24(4);
	
	int version;
	
	private ID3Version(int version) {
		this.version = version; 
	}
	
	public static ID3Version valueOf(int ver) {
		return Arrays.stream(ID3Version.values())
				.filter(v -> v.version == ver)
				.findFirst().orElse(null);
	}
	
	@Override
	public String toString() {
		return "v" + (2 + version / 10.0);
	}

}
