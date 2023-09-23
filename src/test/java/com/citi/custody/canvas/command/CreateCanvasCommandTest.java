package com.citi.custody.canvas.command;

import com.citi.custody.canvas.core.AbstractCanvas;
import com.citi.custody.canvas.core.ICanvas;
import com.citi.custody.canvas.core.SimpleCanvas;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CreateCanvasCommandTest {

    @Test
    public void testCreateCanvas() {
        String[] args = {"C", "10", "2"};
        CreateCanvasCommand command = new CreateCanvasCommand(args);
        ICanvas canvas = command.execute(null);

        List<String> view = canvas.getCanvasView();
        for (int i=0; i<=11;i++) {
            assertEquals('-', view.get(0).charAt(i));
            assertEquals('-', view.get(3).charAt(i));
        }
        assertEquals('|', view.get(1).charAt(0));
        assertEquals('|', view.get(2).charAt(0));
        assertEquals('|', view.get(1).charAt(11));
        assertEquals('|', view.get(2).charAt(11));
    }
}
