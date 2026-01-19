import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CourseDAO dao = new CourseDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1) Add course");
            System.out.println("2) Show all courses");
            System.out.println("3) Update credits");
            System.out.println("4) Delete course");
            System.out.println("5) Exit");
            System.out.print("Choose (1-5): ");

            int a = sc.nextInt();
            sc.nextLine(); // очистить Enter после nextInt()

            switch (a) {
                case 1: {
                    System.out.print("Course id: ");
                    String id = sc.nextLine();

                    System.out.print("Course name: ");
                    String name = sc.nextLine();

                    System.out.print("Credits: ");
                    int credits = sc.nextInt();
                    sc.nextLine();

                    try {
                        dao.insert(new Course(name, credits, id));
                        System.out.println("Inserted.");
                    } catch (SQLException e) {
                        System.out.println("Insert error: " + e.getMessage());
                    }
                    break;
                }

                case 2: {
                    try {
                        dao.readAll();
                    } catch (SQLException e) {
                        System.out.println("Read error: " + e.getMessage());
                    }
                    break;
                }

                case 3: {
                    System.out.print("Course id to update: ");
                    String id = sc.nextLine();

                    System.out.print("New credits: ");
                    int newCredits = sc.nextInt();
                    sc.nextLine();

                    try {
                        dao.updateCredits(id, newCredits);
                        System.out.println("Updated (if id existed).");
                    } catch (SQLException e) {
                        System.out.println("Update error: " + e.getMessage());
                    }
                    break;
                }

                case 4: {
                    System.out.print("Course id to delete: ");
                    String id = sc.nextLine();

                    try {
                        dao.delete(id);
                        System.out.println("Deleted (if id existed).");
                    } catch (SQLException e) {
                        System.out.println("Delete error: " + e.getMessage());
                    }
                    break;
                }

                case 5:
                    System.out.println("Bye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Wrong option. Choose 1-5.");
            }
        }
    }
}
