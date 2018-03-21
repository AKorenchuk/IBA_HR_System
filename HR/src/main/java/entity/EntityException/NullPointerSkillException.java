package entity.EntityException;

public class NullPointerSkillException extends Throwable {

    String message;

    public NullPointerSkillException(){

    }


    public NullPointerSkillException(String message){
        super(message);
    }


}
