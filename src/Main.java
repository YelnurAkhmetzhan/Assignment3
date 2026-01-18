public class Main {
    public static void main(String[] args) {

        Course oop = new Course("Object Oriented Programming", 25, "CS101");
        Course db = new Course("Databases", 24, "CS202");

        Professor prof1 = new Professor("Dr. Smith", "Computer Science", "smith@email.com");
        Professor prof2 = new Professor("Dr. Brown", "Computer Science", "brown@email.com");

        University university = new University("AITU", "Astana");

        university.addCourse(oop);
        university.addCourse(db);
        university.addProfessor(prof1);
        university.addProfessor(prof2);

        System.out.println(university);

        System.out.println("Courses with >= 25 credits:");
        System.out.println(university.filterCoursesByCredits(25));

        System.out.println("Find course CS101:");
        System.out.println(university.findCourseById("CS101"));

        Person p = prof1;
        System.out.println("Role: " + p.getRole()); // полиморфизм
    }
}
