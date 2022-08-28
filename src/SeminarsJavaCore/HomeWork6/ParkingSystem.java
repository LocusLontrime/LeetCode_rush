package SeminarsJavaCore.HomeWork6;

class ParkingSystem {
    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        boolean flag = false;

        switch (carType){
            case 3:
                if (big - 1 >= 0){
                    big -= 1;
                    flag = true;
                }
            case 2:
                if (medium - 1 >= 0){
                    medium -= 1;
                    flag = true;
                }
            case 1:
                if (small - 1 >= 0) {
                    small -= 1;
                    flag = true;
                }
        }
        return flag;
    }
}