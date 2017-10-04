package OJ;

/**
 * Created by arachis on 2017/10/4.
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 */
public class Gas_Station {
    /**
     *  Imagine we take a tour around this circle, the only condition that we can complete this trip is to have more fuel provided than costed in total. That's what the first loop does.
     If we do have more fuel provided than costed, that means we can always find a start point around this circle that we could complete the journey with an empty tank.
     Hence, we check from the beginning of the array, if we can gain more fuel at the current station, we will maintain the start point,
     else, which means we will burn out of oil before reaching to the next station, we will start over at the next station.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int tank = 0;
        for(int i = 0; i < gas.length; i++)
            tank += gas[i] - cost[i];
        if(tank < 0)
            return - 1;

        int start = 0;
        int accumulate = 0;
        for(int i = 0; i < gas.length; i++){
            int curGain = gas[i] - cost[i];
            if(accumulate + curGain < 0){
                start = i + 1;
                accumulate = 0;
            }
            else accumulate += curGain;
        }

        return start;

    }

}
