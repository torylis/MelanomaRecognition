package Service.Entity;

import java.time.LocalDate;
import java.util.List;

public class UserEntity {
    private int userId;
    private String username;
    private String login;
    private String password;
    private LocalDate birthdate;
    private String gender;
    private List<MoleCheckEntity> checks;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<MoleCheckEntity> getChecks() {
        return checks;
    }

    public void setChecks(List<MoleCheckEntity> checks) {
        this.checks = checks;
    }
}
