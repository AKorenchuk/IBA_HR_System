package service.interfaceBS;

import exception.ValidationErrorException;
import entity.EntityException.NullPointerSkillException;

public interface VacancyService {

    public void addVacancy() throws ValidationErrorException, NullPointerSkillException;
    public void deleteVacancy(Integer vacancyID);
    public void editVacancy(Integer vacancyID) throws ValidationErrorException;
    public void printVacancy();

}
