package UI;

import Errors.ErrorExceptions;
import Parser.InputManager;

/**
 * Represents the bridge between the UserInterface and the Parser.
 */
public class InitiateParser {
    /**
     * Calls the parse method in InputManger, acts as a bridging method.
     *
     * @param input user input.
     * @return String output of carrying out the action.
     */
    public static String parser2(String input) {
        try {
            return InputManager.parse2(input);
        } catch (ErrorExceptions e) {
            return e.toString();
        }
    }
}
