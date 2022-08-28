package SeminarsJavaCore.HomeWork6;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    private Map<String, Pair<Double, Double>> journeyData = new HashMap<>();
    private Map<Integer, Pair<String, Integer>> checkInData = new HashMap<>();

    public UndergroundSystem() {
    }

    public void checkIn(int id, String stationName, int t) {
        checkInData.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInDataForId = checkInData.get(id);

        String startSt = checkInDataForId.getKey();
        Integer checkInTime = checkInDataForId.getValue();

        String routeKey = getStationsKey(startSt, stationName);

        Pair<Double, Double> routeStats = journeyData.getOrDefault(routeKey, new Pair<>(0.0, 0.0));

        Double totalTripTime = routeStats.getKey();
        Double totalTrips = routeStats.getValue();

        // Updating travel time data
        double tripTime = t - checkInTime;
        journeyData.put(routeKey, new Pair<>(totalTripTime + tripTime, totalTrips + 1));

        // Removing check-in info for the id
        checkInData.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        // Counting, measuring the total time.
        String routeKey = getStationsKey(startStation, endStation);
        Double totalTime = journeyData.get(routeKey).getKey();
        Double totalTrips = journeyData.get(routeKey).getValue();
        // Calculating the average
        return totalTime / totalTrips;
    }

    private String getStationsKey(String startStation, String endStation) {
        return "from " + startStation + "to" + endStation;
    }
}

