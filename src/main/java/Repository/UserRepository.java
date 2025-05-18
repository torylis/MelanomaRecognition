package Repository;

import Repository.DAO.User;
import Service.iRepository.iUserRepository;

import java.sql.*;

public class UserRepository implements iUserRepository {

    @Override
    public int create(User user) {
        String sql = "INSERT INTO users (username, login, password, birthdate, gender) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) { // указываем, что нам нужно получить сгенерированные ключи

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getLogin());
            stmt.setString(3, user.getPassword());
            stmt.setDate(4, Date.valueOf(user.getBirthdate()));
            stmt.setString(5, user.getGender());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }


    @Override
    public User read(int id) {
        String sql = "SELECT * FROM users WHERE user_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return convertToUser(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET username=?, login=?, password=?, birthdate=?, gender=? WHERE user_id=?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getLogin());
            stmt.setString(3, user.getPassword());
            stmt.setDate(4, Date.valueOf(user.getBirthdate()));
            stmt.setString(5, user.getGender());
            stmt.setInt(6, user.getUserId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM users WHERE user_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int identify(String login) {
        String sql = "SELECT user_id FROM users WHERE login = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("user_id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public boolean authorize(int userId, String password) {
        String sql = "SELECT 1 FROM users WHERE user_id = ? AND password = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    private User convertToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setBirthdate(rs.getDate("birthdate").toLocalDate());
        user.setGender(rs.getString("gender"));
        return user;
    }
}
