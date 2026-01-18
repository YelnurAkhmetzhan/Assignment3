import java.util.Objects;

public class Professor extends Person {
    private String department;

    public Professor(String name, String department, String email) {
        super(name, email);
        this.department = department;
    }

    @Override
    public String getRole() {
        return "Professor";
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Professor{name='" + name + "', department='" + department + "', email='" + email + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor)) return false;
        Professor that = (Professor) o;
        return Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
