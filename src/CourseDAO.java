import java.sql.*;

public class CourseDAO {

    public void insert(Course course) throws SQLException {
        String sql = "INSERT INTO course (id, name, credits) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql))
        {

            stmt.setString(1, course.getId());
            stmt.setString(2, course.getName());
            stmt.setInt(3, course.getCredits());
            stmt.executeUpdate();
        }
    }

    public void readAll() throws SQLException {
        String sql = "SELECT * FROM course";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(
                        rs.getString("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("credits")
                );
            }
        }
    }

    public void updateCredits(String id, int newCredits) throws SQLException {
        String sql = "UPDATE course SET credits = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, newCredits);
            stmt.setString(2, id);
            stmt.executeUpdate();
        }
    }

    public void delete(String id) throws SQLException {
        String sql = "DELETE FROM course WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();
        }
    }
}
