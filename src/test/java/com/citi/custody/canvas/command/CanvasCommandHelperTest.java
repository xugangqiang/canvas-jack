package com.citi.custody.canvas.command;

import com.citi.custody.canvas.core.ICanvas;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CanvasCommandHelperTest {

    @Test
    public void testCreateCanvasCommand() {
        String[] args = {"C", "10", "2"};
        Optional<CanvasOperationCommand> cmd = CanvasCommandHelper.getCommand(args);
        assertTrue(cmd.isPresent());
        assertEquals(CreateCanvasCommand.class, cmd.get().getClass());
    }

    @Test
    public void testDrawLineCommand() {
        String[] args = {"L", "10", "2", "10", "6"};
        Optional<CanvasOperationCommand> cmd = CanvasCommandHelper.getCommand(args);
        assertTrue(cmd.isPresent());
        assertEquals(DrawLineCommand.class, cmd.get().getClass());
    }

    @Test
    public void testDrawRectangleCommand() {
        String[] args = {"R", "1", "2", "10", "6"};
        Optional<CanvasOperationCommand> cmd = CanvasCommandHelper.getCommand(args);
        assertTrue(cmd.isPresent());
        assertEquals(DrawRectangleCommand.class, cmd.get().getClass());
    }

    @Test
    public void testQuitCommand() {
        String[] args = {"Q"};
        Optional<CanvasOperationCommand> cmd = CanvasCommandHelper.getCommand(args);
        assertTrue(cmd.isPresent());
        assertEquals(QuitCommand.class, cmd.get().getClass());
    }
}
