package CHC5223; // or whatever

public class StationInfo implements IStationInfo {

    private String name;
    private int xPos;
    private int yPos;

    public StationInfo(String name, int xPos, int yPos) {
        if (xPos < 0 || xPos >= 256) throw new IllegalArgumentException("Invalid x position");
        if (yPos < 0 || yPos >= 256) throw new IllegalArgumentException("Invalid y position");
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getxPos() {
        return this.xPos;
    }

    @Override
    public int getyPos() {
        return this.yPos;
    }

    public String toString() {
        return "StationInfo{" +
                "name='" + name + '\'' +

                '}';
    }
}
