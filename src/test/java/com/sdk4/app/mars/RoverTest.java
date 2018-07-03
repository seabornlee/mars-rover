package com.sdk4.app.mars;

import org.junit.Assert;
import org.junit.Test;

import com.sdk4.app.mars.var.ActionEnum;
import com.sdk4.app.mars.var.DirectEnum;

/**
 * 移动测试
 * 
 * @author sh
 *
 */
public class RoverTest {
	
	@Test
	public void testMove() throws ActionException {
		int maxX = 5, maxY = 5;
		
		// 
		Rover rover = new Rover(1, 2, DirectEnum.N);
		ActionEnum actions[] = ActionEnum.of("LMLMLMLMM");
		
		rover.doActions(maxX, maxY, actions);
		
		Assert.assertEquals("1 3 N", rover.toString());
		
		// 
		rover = new Rover(3, 3, DirectEnum.E);
		actions = ActionEnum.of("MMRMMRMRRM");
		
		rover.doActions(maxX, maxY, actions);
		Assert.assertEquals("5 1 E", rover.toString());
	}

}
