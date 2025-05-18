package ViewModel;

import Service.Entity.MoleCheckEntity;

import java.util.List;

public class MainViewModel {
    private String username;
    private List<MoleCheckEntity> moleCheck;

    public MainViewModel(String username, List<MoleCheckEntity> moleCheck) {
        this.username = username;
        this.moleCheck = moleCheck;
    }

    public String getUsername() {
        return username;
    }

    public List<MoleCheckEntity> getMoleCheck() {
        return moleCheck;
    }
}
