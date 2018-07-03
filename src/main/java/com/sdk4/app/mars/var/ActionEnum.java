package com.sdk4.app.mars.var;

/**
 * 动作
 * 
 * @author sh
 *
 */
public enum ActionEnum {
	L("左转"), R("右转"), M("前进");
	
	private String text;
	
	ActionEnum(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	public static ActionEnum[] of(String actions) {
		ActionEnum arr[] = new ActionEnum[actions.length()];
		
		for (int i = 0; i < actions.length(); i++) {
			arr[i] = ActionEnum.valueOf("" + actions.charAt(i));
		}
		
		return arr;
	}
}
