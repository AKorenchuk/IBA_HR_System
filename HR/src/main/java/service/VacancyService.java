package service;

import exception.ValidationErrorException;
import entity.EntityException.NullPointerSkillException;
import entity.Pair;
import entity.Vacancy;
import entity.types.Ability;
import entity.types.AbilityState;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static entity.Vacancy.positions;
import static validation.CheckVacancy.*;
import static validation.CheckVacancy.checkName;
import static validation.CheckVacancy.checkNumberOfCondidates;
import static console.ConsoleMenu.*;

public class VacancyService implements service.interfaceBS.VacancyService{

    public void addVacancy() throws ValidationErrorException, NullPointerSkillException {
        Scanner in = new Scanner(System.in);
        Vacancy position;

        System.out.println("vacancyName: ");
        String name = checkName(in.nextLine());

        Map< Ability, Pair> requirement = new HashMap<Ability, Pair>();

        while(true) {
            System.out.println(Ability.printListOfAbility());
            System.out.println("Choose skillID ( 0-exit ): ");
            Integer id = checkSkillID(in.nextLine());
            if( id == 0 ){
                break;
            }
            System.out.println("Choose priority (1 - min  10 - max): ");
            Integer priority = checkPriority(in.nextLine());
            System.out.println("Choose status ("+ Arrays.toString(AbilityState.values())+": ");

            if(requirement.containsKey(Ability.values()[id-1]))
                System.out.println("This skill is already there.Try again");
            else
                requirement.put(Ability.values()[id-1], new Pair(checkStatus(in.nextLine()), priority));

        }

        if( !requirement.values().stream().anyMatch(k -> k.getStatus().equals(AbilityState.MANDATORY)) ){
            throw new ValidationErrorException("invalid requirement");
        }

        System.out.println("Choose number of condidates : ");
        Integer count = checkNumberOfCondidates(in.nextLine());
        position = new Vacancy(name,requirement,count);

    }

    public void deleteVacancy(Integer vacancyID) {
        positions.remove(vacancyID);
    }

    public void editVacancy(Integer vacancyID) throws ValidationErrorException {
        Vacancy vacancy = positions.get(vacancyID);
        while(true) {
            System.out.println("Do you want to change \n");
            printMenu(RESUME_POINT);
            Scanner in = new Scanner(System.in);
            Integer answer = in.nextInt();
            if(checkCorrectAnswer(answer,RESUME_POINT)) {
                switch (answer) {
                    case 0:
                        printConsoleMenu(MENU);
                    case 1:
                        Map<Ability,Pair> requirement = vacancy.getRequirement() ;
                        System.out.println(" abilityID : ");
                        int id = in.nextInt();
                        Ability ability = Ability.values()[id-1];
                        if(requirement.containsKey( ability )){
                            Pair pair = requirement.get( ability );
                            System.out.println(" newPriority : ");
                            int priority = checkPriority(in.nextLine());
                            pair.setPriority(priority);
                            requirement.put(ability, pair);
                            vacancy.setRequirement(requirement);
                            positions.set(vacancyID-1,vacancy);
                        }
                        else
                            System.out.println("invalid abilityID");
                        break;
                    case 2:
                        System.out.println(" new number of condidate : \n");
                        long count = checkNumberOfCondidates( in.nextLine());
                        vacancy.setCount(count);
                        positions.set(vacancyID-1,vacancy);
                        break;
                }
            }
            else {
                System.out.println("invalid answer \n");
                printConsoleMenu(MENU);
            }
        }
    }

    private void printConsoleMenu(String[] menu) {
    }

    @Override
    public void printVacancy() {
        if(positions.isEmpty()){
            System.out.println(" list of vacancy is empty \n");
        }
        else {
            String listOfVacancy = "";
            for (int i = 0; i < positions.size(); i++) {
                listOfVacancy += positions.get(i) + " \n ";
            }
            System.out.println(listOfVacancy);
        }
    }

}
