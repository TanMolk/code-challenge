package mass;

import utils.RandomUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

class ShortJobFirst {
    public static void main(String[] args) {

        System.out.println(averageWaitTime(
                RandomUtils.randomIntArr(10, 100),
                RandomUtils.randomIntArr(10, 100)
        ));
    }

    static double averageWaitTime(int[] req, int[] dur) {
        /*
         *       Firstly, the whole algorithm should follow the sequence of request time,
         *           if a task request CPU, and no task is running, it will get scheduled right now.
         *           Otherwise, it will but put into the pool of task waiting for being scheduled.
         *       When choose next task, if the pool contains some tasks, it will choose the minimum duration time to execute.
         * */

        //record current time
        long currentTime = 0;

        //record if a task has been executed.
        boolean[] scheduledStateArr = new boolean[req.length];

        //store the total waiting time;
        double sumOfWaitingTime = 0;

        //get the next task
        int nextTasks = getNextTaskIndex(req, dur, scheduledStateArr, currentTime);

        while (nextTasks != -1) {
            int requestTime = req[nextTasks];
            int durationTime = dur[nextTasks];

            sumOfWaitingTime += Math.max((currentTime - requestTime), 0);

            //update currentTime
            if (currentTime < requestTime) {
                currentTime = requestTime;
            }
            currentTime += durationTime;

            //get next task
            nextTasks = getNextTaskIndex(req, dur, scheduledStateArr, currentTime);
        }


        return sumOfWaitingTime / req.length;
    }

    static int getNextTaskIndex(int[] req, int[] dur, boolean[] scheduleState, long currentTime) {

        // The time pool for next task
        List<Integer> nextRequestTimes = new ArrayList<>();

        //temporary store index
        AtomicInteger indexCounter = new AtomicInteger();

        //get the close task request time
        int nextRequestTime = Arrays.stream(req)
                .filter((r) -> !scheduleState[indexCounter.getAndIncrement()])
                .min()
                .orElse(-1);

        //get the maximum request time for the next task
        Arrays.stream(req)
                .filter(r -> r <= Math.max(nextRequestTime, currentTime))
                .forEach(nextRequestTimes::add);

        //get all probably tasks
        List<Integer> nextTaskIndex = new ArrayList<>();
        for (int i = 0; i < req.length; i++) {
            if (nextRequestTimes.contains(req[i]) && !scheduleState[i]) {
                nextTaskIndex.add(i);
            }
        }

        //return no task;
        if (nextTaskIndex.isEmpty()) {
            return -1;
        }

        //sort by duration time
        nextTaskIndex.sort(Comparator.comparingInt(r -> dur[r]));

        //get the shortest one
        Integer nextIndex = nextTaskIndex.get(0);
        scheduleState[nextIndex] = true;

        return nextIndex;
    }
}