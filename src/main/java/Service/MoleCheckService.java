package Service;

import Repository.DAO.MoleCheck;
import Service.Entity.MoleCheckEntity;
import Service.iRepository.iMoleCheckRepository;

import java.util.ArrayList;
import java.util.List;

public class MoleCheckService {
    private iMoleCheckRepository moleCheckRepository;

    public MoleCheckService(iMoleCheckRepository moleCheckRepository) {
        this.moleCheckRepository = moleCheckRepository;
    }

    public MoleCheckEntity getMoleCheck(int id) {
        MoleCheck check = moleCheckRepository.read(id);
        return this.convertToEntity(check);
    }

    public void deleteMoleCheck(int id) {
        moleCheckRepository.delete(id);
    }

    public List<MoleCheckEntity> getChecksForUser(int userId) {
        List<MoleCheck> checks = moleCheckRepository.readAll(userId);
        List<MoleCheckEntity> entities = new ArrayList<>();

        for (MoleCheck check : checks) {
            MoleCheckEntity entity = convertToEntity(check);
            entities.add(entity);
        }

        return entities;
    }

    private MoleCheckEntity convertToEntity(MoleCheck check) {
        if (check == null) return null;

        MoleCheckEntity entity = new MoleCheckEntity();
        entity.setMoleId(check.getMoleId());
        entity.setUserId(check.getUserId());
        entity.setRisk(check.getRisk());
        entity.setImagePath(check.getImagePath());
        entity.setDate(check.getDate());
        entity.setLocation(check.getLocation());

        return entity;
    }

    public MoleCheck convertToMoleCheck(MoleCheckEntity entity) {
        if (entity == null) return null;

        MoleCheck check = new MoleCheck();
        check.setMoleId(entity.getMoleId());
        check.setUserId(entity.getUserId());
        check.setRisk(entity.getRisk());
        check.setImagePath(entity.getImagePath());
        check.setDate(entity.getDate());
        check.setLocation(entity.getLocation());

        return check;
    }
}