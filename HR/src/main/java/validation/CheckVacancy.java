package validation;

import exception.ValidationErrorException;
import entity.types.Ability;
import entity.types.AbilityState;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class CheckVacancy {

    public static String checkName(String name) throws ValidationErrorException {
        try {
            Pattern p = Pattern.compile("^[a-zA-Z\\s]{3,15}$");
            Matcher m = p.matcher(name);
            return name;
        }
        catch(PatternSyntaxException e){
            throw new ValidationErrorException("invalid vacancyName");
        }
    }


    public static int checkSkillID(String skillID) throws ValidationErrorException {
        try {
            int id = Integer.parseInt(skillID);
            if( id < 0 || id > Ability.values().length )
                throw new ValidationErrorException("invalid skillID");
            else
                return id;
        }
        catch(Exception e){
            throw new ValidationErrorException("invalid skillID");
        }
    }

    public static int checkPriority(String priority) throws ValidationErrorException {
        try {
            int prt = Integer.parseInt(priority);
            if(prt < 1 && prt >10 )
                throw new ValidationErrorException("invalid priority");
            else
                return Integer.parseInt(priority);
        }
        catch(Exception e){
            throw new ValidationErrorException("invalid priority");
        }
    }

    public static int checkNumberOfCondidates(String count) throws ValidationErrorException {
        try {
            Pattern p = Pattern.compile("^[1-9]+$");
            Matcher m = p.matcher(count);
            return Integer.parseInt(count);
        }
        catch(PatternSyntaxException e){
            throw new ValidationErrorException("invalid count");
        }
    }

    public static AbilityState checkStatus(String status) throws ValidationErrorException {
        try {
            return AbilityState.valueOf(status.toUpperCase());
        }
        catch( IllegalArgumentException e){
            throw new ValidationErrorException("invalid  status");
        }
        catch( NullPointerException e){
            throw new ValidationErrorException("invalid status (==null)");
        }
    }

}
