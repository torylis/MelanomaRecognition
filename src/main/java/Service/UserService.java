package Service;

import Repository.DAO.User;
import Service.Entity.UserEntity;
import Service.iRepository.iMoleCheckRepository;
import Service.iRepository.iUserRepository;

public class UserService {
    private iUserRepository userRepository;
    private iMoleCheckRepository moleCheckRepository;

    public UserService(iUserRepository userRepository, iMoleCheckRepository moleCheckRepository) {
        this.userRepository = userRepository;
        this.moleCheckRepository = moleCheckRepository;
    }

    public UserEntity getUser(int id) {
        User user = userRepository.read(id);
        return this.convertToEntity(user);
    }

    public void updateUser(UserEntity userEntity) {
        User user = this.convertToDAO(userEntity);
        userRepository.update(user);
    }


    public UserEntity convertToEntity(User user) {
        if (user == null) return null;

        UserEntity entity = new UserEntity();
        entity.setUserId(user.getUserId());
        entity.setUsername(user.getUsername());
        entity.setLogin(user.getLogin());
        entity.setPassword(user.getPassword());
        entity.setBirthdate(user.getBirthdate());
        entity.setGender(user.getGender());
        MoleCheckService moleCheckService = new MoleCheckService(moleCheckRepository);
        entity.setChecks(moleCheckService.getChecksForUser(user.getUserId()));

        return entity;
    }

    public User convertToDAO(UserEntity userEntity) {
        if (userEntity == null) return null;

        User user = new User();
        user.setUserId(userEntity.getUserId());
        user.setUsername(userEntity.getUsername());
        user.setLogin(userEntity.getLogin());
        user.setPassword(userEntity.getPassword());
        user.setBirthdate(userEntity.getBirthdate());
        user.setGender(userEntity.getGender());

        return user;
    }
}
