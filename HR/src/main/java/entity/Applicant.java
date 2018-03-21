package entity;

import entity.types.Ability;
import entity.types.Role;

import java.util.HashMap;
import java.util.Map;

public class Applicant extends User{

    private Integer vacancyID;
    private Map<Ability,Integer> requirement = new HashMap<Ability, Integer>();
    private boolean employment;


    public Applicant(String name, Integer vacancyID, Map<Ability,Integer> requirement) {
        super(name, Role.EMPLOYEE);
        this.vacancyID = vacancyID;
        this.requirement = requirement;
    }

    public boolean isEmployment() {
        return employment;
    }

    public void setEmployment(boolean employment) {
        this.employment = employment;
    }

    public Integer getVacancyID() {
        return vacancyID;
    }

    public void setVacancyID(Integer vacancyID) {
        this.vacancyID = vacancyID;
    }

    public Map<Ability, Integer> getRequirement() {
        return requirement;
    }

    public void setRequirement(Map<Ability, Integer> requirement) {
        this.requirement = requirement;
    }
}
