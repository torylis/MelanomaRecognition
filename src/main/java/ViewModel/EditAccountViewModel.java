package ViewModel;

import java.time.LocalDate;

public class EditAccountViewModel {
    private String username;
    private String gender;
    private LocalDate birthdate;

    public EditAccountViewModel(String username, String gender, LocalDate birthdate) {
        this.username = username;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public String getUsername() {
        return username;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
