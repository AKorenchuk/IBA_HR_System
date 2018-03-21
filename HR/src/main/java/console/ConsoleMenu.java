package console;

import entity.EntityException.NullPointerSkillException;
import entity.Vacancy;
import exception.ValidationErrorException;
import service.VacancyService;

import java.util.Scanner;

public class ConsoleMenu {

    public static void printConsoleMenu(String[] menu) throws ValidationErrorException, NullPointerSkillException {

        while(true) {
            System.out.println("---------------------------------------------");
            System.out.println("Choose action : ");
            printMenu(menu);
            System.out.println("---------------------------------------------");

            int answer = 0;
            while (true) {
                System.out.print("Your answer : ");
                try {
                    Scanner sc = new Scanner(System.in);
                    answer = sc.nextInt();
                    if (!checkCorrectAnswer(answer, menu)) {
                        System.out.println("Incorrect answer." +
                                "This number is not included in the specified range.Try again ");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Incorrect answer. You must enter a number.Try again ");
                }
            }
            analyzeRequest(menu, answer);
        }
    }

    public static boolean checkCorrectAnswer(int answer,String[] menu){
                return ( answer >= 0 && answer <= menu.length );
    }

    public static final String[] MENU ={"1 - view job openings",
            "2 - create job openings",
            "3 - change job requirements",
            "4 - add resume of the candidate",
            "5 - editing candidate data",
            "6 - select specialists",
            "0 - EXIT "};


    public static final String[] RESUME_POINT ={
            "1 - priorety of ability",
            "2 - number of condidates",
            "0 - exit"};

    public static void printMenu(String[] menu){
        for(int i = 0; i < menu.length; i++){
            System.out.println(menu[i]);
        }
    }

    public static service.interfaceBS.VacancyService vacancyService = new VacancyService();

    public static void analyzeRequest( String[] menu,int answer) throws ValidationErrorException, NullPointerSkillException {
        if( menu.equals(MENU) ){
            switch (answer) {
                case 0: System.exit(1);
                    break;
                case 1:  vacancyService.printVacancy();
                    break;
                case 2:  vacancyService.addVacancy();
                    break;
                case 3:
                    System.out.println("Enter vacancyID \n");
                    Scanner in = new Scanner(System.in);
                    int vacancyID = in.nextInt();
                    if(vacancyID < 0 && vacancyID >= Vacancy.getVacancyID()) {
                        System.out.println("invalid vacancyID \n");
                    }
                    else
                        vacancyService.editVacancy(vacancyID);
                    break;
//                case 4:  addResume();
//                    break;
//                case 5:  editResume();
//                    break;
//                case 6:  selectSpecialists();
//                    break;
                default: System.exit(1);
                    break;
            }
        }
    }

}
