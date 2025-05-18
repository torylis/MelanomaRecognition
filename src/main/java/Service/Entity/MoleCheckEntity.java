package Service.Entity;

import java.time.LocalDate;

public class MoleCheckEntity {
    private int moleId;
    private int userId;
    private double risk;
    private String imagePath;
    private LocalDate date;
    private String location;

    public int getMoleId() {
        return moleId;
    }

    public void setMoleId(int moleId) {
        this.moleId = moleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getRisk() {
        return risk;
    }

    public void setRisk(double risk) {
        this.risk = risk;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
