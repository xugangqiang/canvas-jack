package com.citi.custody.canvas.command;

import com.citi.custody.canvas.core.AbstractCanvas;
import com.citi.custody.canvas.core.SimpleCanvas;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DrawRectangleCommandTest {

    @Test
    public void testDrawLine() {
        AbstractCanvas canvas = new SimpleCanvas(20, 4);
        String[] args = {"L", "1", "1", "19", "3"};
        DrawRectangleCommand command = new DrawRectangleCommand(args);
        command.execute(canvas);

        List<String> view = canvas.getCanvasView();
        for (int i=1; i<=19;i++) {
            assertEquals('x', view.get(1).charAt(i));
            assertEquals('x', view.get(3).charAt(i));
        }
        assertEquals('x', view.get(2).charAt(1));
        assertEquals('x', view.get(2).charAt(19));
    }
}
