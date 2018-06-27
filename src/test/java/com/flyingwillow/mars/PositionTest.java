package com.flyingwillow.mars;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {
    @Test
    public void move() throws Exception {

        Position position = new Position(new Point(1, 2), Face.N, new Plateau(new Point(5, 5)));

        position.move();
        position.move();

        System.out.println(position);

    }

}