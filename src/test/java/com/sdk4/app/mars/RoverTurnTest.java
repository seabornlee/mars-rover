package com.sdk4.app.mars;

import org.junit.Assert;
import org.junit.Test;

import com.sdk4.app.mars.var.ActionEnum;
import com.sdk4.app.mars.var.DirectEnum;

/**
 * 左右转动
 * 
 * @author sh
 *
 */
public class RoverTurnTest {
	
	/**
	 * 测试左转动
	 */
	@Test
	public void tesDirectTurnLeft() {
		Rover rover = new Rover(0, 0, DirectEnum.N);
		
		rover.turn(ActionEnum.L);
		Assert.assertEquals(rover.getDirect(), DirectEnum.W);
		
		rover.turn(ActionEnum.L);
		Assert.assertEquals(rover.getDirect(), DirectEnum.S);
		
		rover.turn(ActionEnum.L);
		Assert.assertEquals(rover.getDirect(), DirectEnum.E);
		
		rover.turn(ActionEnum.L);
		Assert.assertEquals(rover.getDirect(), DirectEnum.N);
		
		rover.turn(ActionEnum.L);
		Assert.assertEquals(rover.getDirect(), DirectEnum.W);
	}

	/**
	 * 测试右转动
	 */
	@Test
	public void tesDirectTurnRight() {
		Rover rover = new Rover(0, 0, DirectEnum.N);
		
		rover.turn(ActionEnum.R);
		Assert.assertEquals(rover.getDirect(), DirectEnum.E);
		
		rover.turn(ActionEnum.R);
		Assert.assertEquals(rover.getDirect(), DirectEnum.S);
		
		rover.turn(ActionEnum.R);
		Assert.assertEquals(rover.getDirect(), DirectEnum.W);
		
		rover.turn(ActionEnum.R);
		Assert.assertEquals(rover.getDirect(), DirectEnum.N);
		
		rover.turn(ActionEnum.R);
		Assert.assertEquals(rover.getDirect(), DirectEnum.E);
	}
	
	/**
	 * 测试右转动
	 */
	@Test
	public void tesDirectTurn() {
		Rover rover = new Rover(0, 0, DirectEnum.N);
		
		rover.turn(ActionEnum.R);
		Assert.assertEquals(rover.getDirect(), DirectEnum.E);
		
		rover.turn(ActionEnum.R);
		Assert.assertEquals(rover.getDirect(), DirectEnum.S);
		
		rover.turn(ActionEnum.L);
		Assert.assertEquals(rover.getDirect(), DirectEnum.E);
		
		rover.turn(ActionEnum.R);
		Assert.assertEquals(rover.getDirect(), DirectEnum.S);
		
		rover.turn(ActionEnum.R);
		Assert.assertEquals(rover.getDirect(), DirectEnum.W);
	}
}
