package Service.iRepository;

import Repository.DAO.MoleCheck;

import java.util.List;

public interface iMoleCheckRepository {
    void create(MoleCheck check);
    MoleCheck read(int id);
    List<MoleCheck> readAll(int userId);
    void update(MoleCheck check);
    void delete(int id);
}
