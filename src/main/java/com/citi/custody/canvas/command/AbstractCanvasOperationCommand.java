package com.citi.custody.canvas.command;

import com.citi.custody.canvas.core.Coordinate;
import com.citi.custody.canvas.core.ICanvas;
import com.citi.custody.canvas.exception.ArgumentMissingException;
import com.citi.custody.canvas.exception.IllegalCoordinateException;

import java.util.List;

public abstract class AbstractCanvasOperationCommand implements CanvasOperationCommand {

    protected final String[] parameters;

    public AbstractCanvasOperationCommand(String[] params) {
        parameters = params;
        validateParameterSize();
    }

    abstract protected int getExpectedParameterCount();

    public void validateParameterSize() {
        final int size = parameters == null ? 0 : parameters.length;
        final int count = getExpectedParameterCount();
        if (size < count) {
            String msg = String.format("expected: %d parameters, but only: %d", count, size);
            throw new ArgumentMissingException(msg);
        }
    }

    public static Integer safeParseInteger(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return null;
        }
    }

    public Coordinate getCoordinateFromParameter(int xIndex, int yIndex) {
        Integer x = safeParseInteger(parameters[xIndex]);
        if (x == null) {
            throw new IllegalCoordinateException(parameters[xIndex]);
        }

        Integer y = safeParseInteger(parameters[yIndex]);
        if (y == null) {
            throw new IllegalCoordinateException(parameters[yIndex]);
        }

        return new Coordinate(x, y);
    }
}
