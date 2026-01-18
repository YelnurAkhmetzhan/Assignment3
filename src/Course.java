    import java.util.Objects;

    public class Course {
        private String name;
        private int credits;
        private String id;

        public Course(String name, int credits, String id) {
            this.name = name;
            this.credits = credits;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public int getCredits() {
            return credits;
        }

        public String getId() {
            return id;
        }

        @Override
        public String toString() {
            return "Course{name='" + name + "', credits=" + credits + ", id='" + id + "'}";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Course)) return false;
            Course course = (Course) o;
            return Objects.equals(id, course.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
