import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("==== HTTP Integration Exercises ====");
            System.out.println("1 - Simple GET of all entities");
            System.out.println("2 - GET of a specific entity");
            System.out.println("3 - GET of a nonexistent entity");
            System.out.println("4 - GET with URL parameters");
            System.out.println("5 - POST to create a new entity");
            System.out.println("6 - GET the created entity");
            System.out.println("7 - POST to update an entity");
            System.out.println("8 - PUT to update an entity");
            System.out.println("9 - DELETE a valid entity");
            System.out.println("10 - DELETE an invalid entity");
            System.out.println("11 - OPTIONS to check allowed methods");
            System.out.println("0 - Exit");
            System.out.print("Choose the exercise: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    Ex01_GetAllEntities.run();
                    break;
                case "2":
                    Ex02_GetEntityById.run();
                    break;
                case "3":
                    Ex03_GetNonexistentEntity.run();
                    break;
                case "4":
                    Ex04_GetWithUrlParameters.run();
                    break;
                case "5":
                    Ex05_PostCreateEntity.run();
                    break;
                case "6":
                    Ex06_GetCreatedEntity.run();
                    break;
                case "7":
                    Ex07_PostUpdateEntity.run();
                    break;
                case "8":
                    Ex08_PutUpdateEntity.run();
                    break;
                case "9":
                    Ex09_DeleteValidEntity.run();
                    break;
                case "10":
                    Ex10_DeleteInvalidEntity.run();
                    break;
                case "11":
                    Ex11_OptionsCheckMethods.run();
                    break;
                case "0":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
            System.out.println();
        }
    }
}
