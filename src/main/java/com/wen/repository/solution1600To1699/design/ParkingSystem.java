package com.wen.repository.solution1600To1699.design;

public class ParkingSystem {

    private int[] left;

    public ParkingSystem(int big, int medium, int small) {
        left = new int[3];
        left[0] = big;
        left[1] = medium;
        left[2] = small;
    }

    public boolean addCar(int carType) {
        if (carType < 1 || carType > 3) {
            return false;
        }
        carType--;
        if (left[carType] > 0) {
            left[carType]--;
            return true;
        }
        else {
            return false;
        }
    }
}
