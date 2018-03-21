package console;

import entity.EntityException.NullPointerSkillException;
import exception.ValidationErrorException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static console.ConsoleMenu.MENU;

public class Main {

    public static void main(String[] args) throws ValidationErrorException, NullPointerSkillException {


        ConsoleMenu.printConsoleMenu( MENU );

    }

}
