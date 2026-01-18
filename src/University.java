import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class University {
    private String name;
    private String city;
    private List<Course> courses = new ArrayList<>();
    private List<Professor> professors = new ArrayList<>();

    public University(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }


    public List<Course> filterCoursesByCredits(int minCredits) {
        return courses.stream()
                .filter(c -> c.getCredits() >= minCredits)
                .collect(Collectors.toList());
    }


    public Course findCourseById(String id) {
        return courses.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "University{name='" + name + "', city='" + city +
                "', courses=" + courses.size() +
                ", professors=" + professors.size() + "}";
    }
}
