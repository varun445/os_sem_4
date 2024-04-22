import java.util.Arrays;
import java.util.Comparator;

public class SJF {
    public static void main(String[] args) {
        int[][] arrivalTimeAndBurstTime = {
                { 0, 10 },
                { 0, 6 },
                { 0, 2 },
                { 0, 4 },
                { 0, 8 },
        };

        Arrays.sort(arrivalTimeAndBurstTime, Comparator.comparingInt(o -> o[1]));

        int totalTime = 0;
        int n = arrivalTimeAndBurstTime.length;
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] completionTime = new int[n];

        // Calculate waiting time, turnaround time, and completion time for each process
        for (int i = 0; i < n; i++) {
            if (arrivalTimeAndBurstTime[i][0] > totalTime) {
                totalTime = arrivalTimeAndBurstTime[i][0];
            }
            waitingTime[i] = totalTime - arrivalTimeAndBurstTime[i][0];
            completionTime[i] = totalTime + arrivalTimeAndBurstTime[i][1];
            totalTime += arrivalTimeAndBurstTime[i][1];
            turnaroundTime[i] = waitingTime[i] + arrivalTimeAndBurstTime[i][1];
        }

        // Print results
        System.out.println("Process\tBurst Time\tArrival Time\tWaiting Time\tTurnaround Time\tFinish Time");
        for (int i = 0; i < n; i++) {
            System.out
                    .println((i + 1) + "\t\t" + arrivalTimeAndBurstTime[i][1] + "\t\t" + arrivalTimeAndBurstTime[i][0] +
                            "\t\t" + waitingTime[i] + "\t\t" + turnaroundTime[i] + "\t\t" + completionTime[i]);
        }

        // Calculate average waiting time and turnaround time
        double avgWaitingTime = Arrays.stream(waitingTime).average().orElse(0);
        double avgTurnaroundTime = Arrays.stream(turnaroundTime).average().orElse(0);

        System.out.println("\nAverage Waiting Time: " + avgWaitingTime);
        System.out.println("Average Turnaround Time: " + avgTurnaroundTime);
    }
}
