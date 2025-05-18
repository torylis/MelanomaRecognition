package Service.iRepository;

import Repository.DAO.User;

public interface iUserRepository {
    int create(User user);
    User read(int id);
    void update(User user);
    void delete(int id);
    int identify(String login);
    boolean authorize(int userId, String password);
}
