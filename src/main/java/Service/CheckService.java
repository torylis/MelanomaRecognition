package Service;

import Repository.DAO.MoleCheck;
import Service.Entity.MoleCheckEntity;
import Service.iRepository.iMoleCheckRepository;

public class CheckService {
    private final iMoleCheckRepository moleCheckRepository;
    private final MoleCheckService moleCheckService;

    public CheckService(iMoleCheckRepository moleCheckRepository) {
        this.moleCheckRepository = moleCheckRepository;
        this.moleCheckService = new MoleCheckService(moleCheckRepository);
    }

    public void makeCheck(int userId, String imagePath, String location) {
        double risk = Math.random();

        MoleCheckEntity check = new MoleCheckEntity();
        check.setUserId(userId);
        check.setImagePath(imagePath);
        check.setLocation(location);
        check.setRisk(risk);
        check.setDate(java.time.LocalDate.now());

        MoleCheck moleCheck = moleCheckService.convertToMoleCheck(check);
        moleCheckRepository.create(moleCheck);
    }
}
