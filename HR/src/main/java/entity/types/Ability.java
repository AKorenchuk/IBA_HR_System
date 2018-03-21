package entity.types;

public enum Ability {

    RELATIONSHIP_MANAGEMENT,
    TEAMWORK,
    INFLUENCE,
    COLLECTION_AND_ANALYSIS_OF_INFORMATION,
    MAKING_DECISIONS,
    PERSONAL_DEVELOPMENT,
    GENERATION_AND_SUBSTANTIATION_OF_IDEAS,
    PLANNING,
    CLARITY_OF_MANAGEMENT,
    SETTING_GOALS;

    public static String printListOfAbility() {
        String result = "";
        for(int i = 0 ; i < values().length; i++){
            int id = i+1;
            result += id +" - "+ values()[i]+"\n";
        }
        return result;
    }

    }
