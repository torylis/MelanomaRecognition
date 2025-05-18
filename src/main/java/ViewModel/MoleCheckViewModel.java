package ViewModel;

import java.time.LocalDate;

public class MoleCheckViewModel {
    private int moleId;
    private double risk;
    private String imagePath;
    private LocalDate date;
    private String location;

    public MoleCheckViewModel(int moleId, double risk, String imagePath, LocalDate date, String location) {
        this.moleId = moleId;
        this.risk = risk;
        this.imagePath = imagePath;
        this.date = date;
        this.location = location;
    }

    public int getMoleId() {
        return moleId;
    }

    public double getRisk() {
        return risk;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getLocation() {
        return location;
    }
}
