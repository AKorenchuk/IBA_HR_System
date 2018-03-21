package entity;

import entity.types.Ability;

import java.util.*;

public class Vacancy {

    private String vacancyName;
    private Map<Ability,Pair> requirement = new HashMap<Ability, Pair>();
    private long count;

    private static long vacancyID = 0;

    public static ArrayList <Vacancy> positions = new ArrayList();

    public Vacancy(String vacancyName, Map<Ability, Pair> requirement, Integer count){
        this.vacancyName = vacancyName;
        (this.requirement).putAll(requirement);
        this.count = count;
        this.vacancyID = vacancyID++;
        positions.add(this);
    }


    @Override
    public String toString() {
        String listOfAbility = "";
        for(Map.Entry<Ability, Pair> e : requirement.entrySet()) {
            listOfAbility += e.getKey().name() + " " + e.getValue() + "\n";
        }
        return "Vacancy{" +
                "vacancyName='" + vacancyName + '\'' +
                ", requirement=" + listOfAbility  +
                ", count=" + count +
                ", vacancyID=" + vacancyID +
                '}';
    }

    public String getVacancyName() {
        return vacancyName;
    }

    public void setVacancyName(String vacancyName) {
        this.vacancyName = vacancyName;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public static long getVacancyID() {
        return vacancyID;
    }

    public static void setVacancyID(long vacancyID) {
        Vacancy.vacancyID = vacancyID;
    }

    public Map<Ability, Pair> getRequirement() {
        return requirement;
    }

    public void setRequirement(Map<Ability, Pair> requirement) {
        this.requirement = requirement;
    }
}
