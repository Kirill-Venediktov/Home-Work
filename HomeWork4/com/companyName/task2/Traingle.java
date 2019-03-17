package HomeWork4.com.companyName.task2;

public class Traingle {
    private int tx1;
    private int ty1;
    private int tx2;
    private int ty2;
    private int tx3;
    private int ty3;

    public Traingle() {

    }

    public Traingle(int tx1, int ty1, int tx2, int ty2, int tx3, int ty3) {
        this.tx1 = tx1;
        this.ty1 = ty1;
        this.tx2 = tx2;
        this.ty2 = ty2;
        this.tx3 = tx3;
        this.ty3 = ty3;
    }

    public void setTx1(int tx1) {
        this.tx1 = tx1;
    }

    public void setTy1(int ty1) {
        this.ty1 = ty1;
    }

    public void setTx2(int tx2) {
        this.tx2 = tx2;
    }

    public void setTy2(int ty2) {
        this.ty2 = ty2;
    }

    public void setTx3(int tx3) {
        this.tx3 = tx3;
    }

    public void setTy3(int ty3) {
        this.ty3 = ty3;
    }

    public int getTx1() {
        return tx1;
    }

    public int getTy1() {
        return ty1;
    }

    public int getTx2() {
        return tx2;
    }

    public int getTy2() {
        return ty2;
    }

    public int getTx3() {
        return tx3;
    }

    public int getTy3() {
        return ty3;
    }

    public double trainglePerim() {
        double sideOne = Math.sqrt((tx2 - tx1) * (tx2 - tx1) + (ty2 - ty1) * (ty2 - ty1));
        double sideTwo = Math.sqrt((tx3 - tx1) * (tx3 - tx1) + (ty3 - ty1) * (ty3 - ty1));
        double sideThree = Math.sqrt((tx3 - tx2) * (tx3 - tx2) + (ty3 - ty2) * (ty3 - ty2));
        double perimeter = sideOne + sideTwo + sideThree;
        return perimeter;
    }

    public double trainglePerim(int x1, int y1, int x2, int y2, int x3, int y3) {
        double sideOne = Math.sqrt((tx2 - tx1) * (tx2 - tx1) + (ty2 - ty1) * (ty2 - ty1));
        double sideTwo = Math.sqrt((tx3 - tx1) * (tx3 - tx1) + (ty3 - ty1) * (ty3 - ty1));
        double sideThree = Math.sqrt((tx3 - tx2) * (tx3 - tx2) + (ty3 - ty2) * (ty3 - ty2));
        double perimeter = sideOne + sideTwo + sideThree;
        return perimeter;
    }

    public double traingleArea() {
        double sideOne = Math.sqrt((tx2 - tx1) * (tx2 - tx1) + (ty2 - ty1) * (ty2 - ty1));
        double sideTwo = Math.sqrt((tx3 - tx1) * (tx3 - tx1) + (ty3 - ty1) * (ty3 - ty1));
        double sideThree = Math.sqrt((tx3 - tx2) * (tx3 - tx2) + (ty3 - ty2) * (ty3 - ty2));
        double halfPer = (sideOne + sideTwo + sideThree) * 0.5;
        double area = Math.sqrt(halfPer * (halfPer - sideOne) * (halfPer - sideTwo) * (halfPer - sideThree));
        return area;
    }

    public double traingleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double sideOne = Math.sqrt((tx2 - tx1) * (tx2 - tx1) + (ty2 - ty1) * (ty2 - ty1));
        double sideTwo = Math.sqrt((tx3 - tx1) * (tx3 - tx1) + (ty3 - ty1) * (ty3 - ty1));
        double sideThree = Math.sqrt((tx3 - tx2) * (tx3 - tx2) + (ty3 - ty2) * (ty3 - ty2));
        double halfPer = (sideOne + sideTwo + sideThree) * 0.5;
        double area = Math.sqrt(halfPer * (halfPer - sideOne) * (halfPer - sideTwo) * (halfPer - sideThree));
        return area;
    }

}


