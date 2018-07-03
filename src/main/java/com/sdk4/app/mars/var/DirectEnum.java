package com.sdk4.app.mars.var;

import java.util.HashMap;
import java.util.Map;

/**
 * 方向
 * 
 * @author sh
 *
 */
public enum DirectEnum {
	N(1, "北"), W(2, "西"), S(3, "南"), E(4, "东");
	
	private int index; // 方向值(用于计算左右转动90度)
	private String text; // 方向名称
	
	DirectEnum(int index, String text) {
		this.index = index;
		this.text = text;
	}

	public int getIndex() {
		return index;
	}
	
	public String getText() {
		return text;
	}
	
	static Map<Integer, DirectEnum> _cache = new HashMap<Integer, DirectEnum>();
	
	static {
		for (DirectEnum de : DirectEnum.values()) {
			_cache.put(de.index, de);
		}
	}
	
	public static DirectEnum of(Integer index) {
		return _cache.get(index);
	}
}
