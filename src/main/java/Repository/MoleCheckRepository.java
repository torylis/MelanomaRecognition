package Repository;

import Repository.DAO.MoleCheck;
import Service.iRepository.iMoleCheckRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoleCheckRepository implements iMoleCheckRepository {

    @Override
    public void create(MoleCheck check) {
        String sql = "INSERT INTO mole_checks (user_id, risk, image_path, date, location) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, check.getUserId());
            stmt.setDouble(2, check.getRisk());
            stmt.setString(3, check.getImagePath());
            stmt.setDate(4, Date.valueOf(check.getDate()));
            stmt.setString(5, check.getLocation());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public MoleCheck read(int id) {
        String sql = "SELECT * FROM mole_checks WHERE mole_id = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return convertToMoleCheck(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<MoleCheck> readAll(int userId) {
        List<MoleCheck> list = new ArrayList<>();
        String sql = "SELECT * FROM mole_checks WHERE user_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId); // подставляем user_id в запрос

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(convertToMoleCheck(rs));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public void update(MoleCheck check) {
        String sql = "UPDATE mole_checks SET user_id=?, risk=?, image_path=?, date=?, location=? WHERE mole_id=?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, check.getUserId());
            stmt.setDouble(2, check.getRisk());
            stmt.setString(3, check.getImagePath());
            stmt.setDate(4, Date.valueOf(check.getDate()));
            stmt.setString(5, check.getLocation());
            stmt.setInt(6, check.getMoleId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM mole_checks WHERE mole_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public MoleCheck convertToMoleCheck(ResultSet rs) throws SQLException {
        MoleCheck check = new MoleCheck();
        check.setMoleId(rs.getInt("mole_id"));
        check.setUserId(rs.getInt("user_id"));
        check.setRisk(rs.getDouble("risk"));
        check.setImagePath(rs.getString("image_path"));
        check.setDate(rs.getDate("date").toLocalDate());
        check.setLocation(rs.getString("location"));
        return check;
    }
}
