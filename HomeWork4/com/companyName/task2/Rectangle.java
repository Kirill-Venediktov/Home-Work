package HomeWork4.com.companyName.task2;

public class Rectangle {
    private int rx1;
    private int ry1;
    private int rx2;
    private int ry2;
    private int rx3;
    private int ry3;

    public Rectangle() {
    }

    public  Rectangle (int rx1, int ry1, int rx2, int ry2,int rx3, int ry3) {
        this.rx1 = rx1;
        this.ry1 = ry1;
        this.rx2 = rx2;
        this.ry2 = ry2;
        this.rx3 = rx3;
        this.ry3 = ry3;
    }

    public void setRx1(int rx1) {
        this.rx1 = rx1;
    }

    public void setRy1(int ry1) {
        this.ry1 = ry1;
    }

    public void setRx2(int rx2) {
        this.rx2 = rx2;
    }

    public void setRy2(int ry2) {
        this.ry2 = ry2;
    }

    public void setRx3(int rx3) {
        this.rx3 = rx3;
    }

    public void setRy3(int ry3) {
        this.ry3 = ry3;
    }

    public int getRx1() {
        return rx1;
    }

    public int getRy1() {
        return ry1;
    }

    public int getRx2() {
        return rx2;
    }

    public int getRy2() {
        return ry2;
    }

    public int getRx3() {
        return rx3;
    }

    public int getRy3() {
        return ry3;
    }

    public double rectArea() {
        double sideOne = Math.sqrt((rx2 - rx1) * (rx2 - rx1) + (ry2 - ry1) * (ry2 - ry1));
        double sideTwo = Math.sqrt((rx3 - rx1) * (rx3 - rx1) + (ry3 - ry1) * (ry3 - ry1));
        double ra = sideOne * sideTwo;
        return ra;
    }

    public double rectArea(int x1, int y1, int x2, int y2,int x3, int y3) {
        double sideOne = Math.sqrt((rx2 - rx1) * (rx2 - rx1) + (ry2 - ry1) * (ry2 - ry1));
        double sideTwo = Math.sqrt((rx3 - rx1) * (rx3 - rx1) + (ry3 - ry1) * (ry3 - ry1));
        double ra = sideOne * sideTwo;
        return ra;
    }

    public double rectPerim () {
        double sideOne = Math.sqrt((rx2 - rx1) * (rx2 - rx1) + (ry2 - ry1) * (ry2 - ry1));
        double sideTwo = Math.sqrt((rx3 - rx1) * (rx3 - rx1) + (ry3 - ry1) * (ry3 - ry1));
        double rp = (sideOne + sideTwo) *2;
        return rp;
    }

    public double rectPerim (int x1, int y1, int x2, int y2,int x3, int y3) {
        double sideOne = Math.sqrt((rx2 - rx1) * (rx2 - rx1) + (ry2 - ry1) * (ry2 - ry1));
        double sideTwo = Math.sqrt((rx3 - rx1) * (rx3 - rx1) + (ry3 - ry1) * (ry3 - ry1));
        double rp = (sideOne + sideTwo) *2;
        return rp;
    }
}
