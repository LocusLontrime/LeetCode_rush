package SeminarsJavaCore.HomeWork6;

class ParkingSystem {
    private int[] carsCapacity;

    public ParkingSystem(int... carsCapacity) {
        this.carsCapacity = carsCapacity;
    }

    public boolean addCar(int carType) {
        if (carsCapacity[carType - 1] >= 1) {
            carsCapacity[carType - 1] -= 1;
            return true;

        } else return false;
    }
}