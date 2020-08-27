package Command;

import Errors.ErrorExceptions;

import java.time.LocalDateTime;

/**
 * Represents the overall command abstract class for sub-class to follow.
 */
public abstract class Command {
    public static void execute(String s) throws ErrorExceptions {}
    public static void execute() throws ErrorExceptions {}
    public static void execute(int i) throws ErrorExceptions {}
    public static void execute(LocalDateTime date) throws ErrorExceptions {}
}
