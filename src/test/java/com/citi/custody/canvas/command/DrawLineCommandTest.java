package com.citi.custody.canvas.command;

import com.citi.custody.canvas.core.AbstractCanvas;
import com.citi.custody.canvas.core.Coordinate;
import com.citi.custody.canvas.core.SimpleCanvas;
import com.citi.custody.canvas.exception.IllegalCoordinateException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DrawLineCommandTest {

    @Test
    public void testDrawLine() {
        AbstractCanvas canvas = new SimpleCanvas(20, 4);
        String[] args = {"L", "1", "3", "6", "3"};
        DrawLineCommand command = new DrawLineCommand(args);
        command.execute(canvas);

        List<String> view = canvas.getCanvasView();
        for (int i=1; i<=6;i++) {
            assertEquals('x', view.get(3).charAt(i));
        }
    }
}
