package Service;

import Repository.DAO.User;
import Service.iRepository.iUserRepository;

import java.time.LocalDate;

public class AuthService {
    private iUserRepository userRepository;

    public AuthService(iUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public int login(String login, String password) {
        int userId = userRepository.identify(login);
        if (userId == -1) {
            return -1;
        }

        boolean correct = userRepository.authorize(userId, password);
        if (correct) {
            return userId;
        }
        else
            return -2;
    }

    public int register(String login, String password, String username, String gender, LocalDate birthdate) {
        if (userRepository.identify(login) != -1) {
            return -1;
        }

        User user = new User();
        user.setUsername(username);
        user.setLogin(login);
        user.setPassword(password);
        user.setGender(gender);
        user.setBirthdate(birthdate);

        return userRepository.create(user);
    }
}
