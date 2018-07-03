package com.sdk4.app.mars;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.sdk4.app.mars.var.ActionEnum;
import com.sdk4.app.mars.var.DirectEnum;

public class RoverMain {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int maxX = 0;
		int maxY = 0;
		
		Map<Rover, ActionEnum[]> rovers = new LinkedHashMap<Rover, ActionEnum[]>();
		
		System.out.println("请输入:");
		
		Scanner scan = new Scanner(System.in);
		
		int index = -1;
		String line;
		while (true) {
			line = scan.nextLine();
			
			if ("go".equalsIgnoreCase(line)) {
				System.out.println("输出:");
				
				for (Entry<Rover, ActionEnum[]> entry : rovers.entrySet()) {
					Rover rover = entry.getKey();
					try {
						rover.doActions(maxX, maxY, entry.getValue());
						System.out.println(rover.toString());
					} catch (ActionException e) {
						System.err.println(e.getMessage());
					}
				}
				
				rovers.clear();
				index = -1;
				
				System.out.println();
				System.out.println();
				System.out.println("请输入:");
				
				continue;
			}
			
			if ("quit".equalsIgnoreCase(line)) {
				break;
			}
			
			index++;
			
			if (index == 0) {
				String arr[] = line.split("[ ]");
				if (arr.length != 2) {
					System.err.print("右顶点坐标输入错误，请重新输入：");
					index--;
					continue;
				} else {
					maxX = Integer.parseInt(arr[0]);
					maxY = Integer.parseInt(arr[1]);
				}
			} else {
				String arr[] = line.split("[ ]");
				if (arr.length != 3) {
					System.err.print("火星车信息输入错误，请重新输入：");
					index--;
					continue;
				} else {
					int x = Integer.parseInt(arr[0]);
					int y = Integer.parseInt(arr[1]);
					DirectEnum direct = DirectEnum.valueOf(arr[2]);
					Rover rover = new Rover(x, y, direct);
					
					line = scan.nextLine();
					if (line == null || line.isEmpty()) {
						System.err.print("火星车指令串不能为空，请重新输入：");
					} else {
						rovers.put(rover, ActionEnum.of(line));
					}
				}
			}
		}
	}

}
