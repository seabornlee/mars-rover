package com.sdk4.app.mars;

import com.sdk4.app.mars.var.ActionEnum;
import com.sdk4.app.mars.var.DirectEnum;

/**
 * 火星车
 * 
 * @author sh
 */
public class Rover {
	private int x;
	private int y;
	private DirectEnum direct;
	
	public Rover(int x, int y, DirectEnum direct) {
		this.x = x;
		this.y = y;
		this.direct = direct;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public DirectEnum getDirect() {
		return direct;
	}
	
	public void setDirect(DirectEnum direct) {
		this.direct = direct;
	}
	
	/**
	 * 前进一步
	 * @return
	 */
	public Rover forward() {
		if (direct == DirectEnum.N) {
			y++;
		} else if (direct == DirectEnum.W) {
			x--;
		} else if (direct == DirectEnum.S) {
			y--;
		} else if (direct == DirectEnum.E) {
			x++;
		}
		
		return this;
	}
	
	/**
	 * 左右转90度
	 * 
	 * @param action 转动方向
	 * @return
	 */
	public Rover turn(ActionEnum action) {
		int index = this.direct.getIndex();
		
		if (action == ActionEnum.L) {
			index++;
		} else if (action == ActionEnum.R) {
			index--;
		}
		
		if (index > 4) {
			index = 1;
		} else if (index < 1) {
			index = 4;
		}
		
		this.direct = DirectEnum.of(index);
		
		return this;
	}
	
	/**
	 * 执行指令串
	 * 
	 * @param maxX 最大x值
	 * @param maxY 最大y值
	 * @param actions 指令串
	 * @return
	 * @throws ActionException
	 */
	public Rover doActions(int maxX, int maxY, ActionEnum... actions) throws ActionException {
		for (ActionEnum action : actions) {
			if (action == ActionEnum.L || action == ActionEnum.R) {
				turn(action);
			} else if (action == ActionEnum.M) {
				forward();
				
				if (x > maxX || y > maxY || x < 0 || y < 0) {
					throw new ActionException(this, "火星车移动超出边界[" + x + "," + y + "]");
				}
			}
		}
		
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder tmp = new StringBuilder();
		
		tmp.append(this.x);
		tmp.append(' ');
		tmp.append(this.y);
		tmp.append(' ');
		tmp.append(this.direct.name());
		
		return tmp.toString();
	}
}
