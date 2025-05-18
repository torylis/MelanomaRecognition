package ViewModel;

import java.time.LocalDate;

public class AccountViewModel {
    private String username;
    private String gender;
    private LocalDate birthdate;

    public AccountViewModel(String username, String gender, LocalDate birthdate) {
        this.username = username;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getUsername() {
        return username;
    }

    public String getGender() {
        return gender;
    }
}
