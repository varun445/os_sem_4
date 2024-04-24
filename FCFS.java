import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FCFS {
    public static void main(String[] args) {
        int[][] arrivalTimeAndBurstTime = {
            {2, 2},
            {5, 6},
            {0, 4},
            {0, 7},
            {7, 4},
            {3, 5},
            {1, 10}
        };

        Arrays.sort(arrivalTimeAndBurstTime, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        // for(int i = 0; i < arrivalTimeAndBurstTime.length; i++) {
        //     System.out.println("Arrival Time: " + arrivalTimeAndBurstTime[i][0] + " Burst Time: " + arrivalTimeAndBurstTime[i][1]);
        // }

        // finish time
        ArrayList<Integer> finishTime = new ArrayList<>();
        int a = 0;
        int b = arrivalTimeAndBurstTime[0][1];
        finishTime.add(b);
        for(int i = 1; i < arrivalTimeAndBurstTime.length; i++) {
            a = b;
            b = a + arrivalTimeAndBurstTime[i][1];
            finishTime.add(b);
        }
        int averageFinishTime = b / finishTime.size();
        // System.out.println("Finish Time: " + finishTime);
        // System.out.println("Average Finish Time: " + averageFinishTime);
    
        // Turnaround time
        ArrayList<Integer> turnaroundTime = new ArrayList<>();
        int someNum = 0;
        for(int i = 0; i < arrivalTimeAndBurstTime.length; i++) {
            someNum += finishTime.get(i) - arrivalTimeAndBurstTime[i][0]; 
            turnaroundTime.add(finishTime.get(i) - arrivalTimeAndBurstTime[i][0]);
        }
        // System.out.println("Turn around Time: " + turnaroundTime);
        // System.out.println("Average Turn around time: " + someNum/turnaroundTime.size());

        // Waiting time
        ArrayList<Integer> waitTime = new ArrayList<>();
        float someNewNumber = 0;
        for(int i = 0; i < arrivalTimeAndBurstTime.length; i++) {
            someNewNumber += turnaroundTime.get(i) - arrivalTimeAndBurstTime[i][1];
            waitTime.add(turnaroundTime.get(i) - arrivalTimeAndBurstTime[i][1]);
        }
        // System.out.println("Wait time: " + waitTime);
        // System.out.println("Average wait time: " + someNewNumber/waitTime.size());
    
    
        System.out.println("Index | Arrival Time | Burst Time | Finish Time | Turnaround Time | Wait Time");
        System.out.println("------|--------------|------------|-------------|-----------------|----------");
        for (int i = 0; i < arrivalTimeAndBurstTime.length; i++) {
            System.out.printf("%5d | %12d | %10d | %11d | %15d | %8d\n", i, arrivalTimeAndBurstTime[i][0], arrivalTimeAndBurstTime[i][1], finishTime.get(i), turnaroundTime.get(i), waitTime.get(i));
        }
        System.out.println("------|--------------|------------|-------------|-----------------|----------");
        System.out.printf("Avg   |              |            | %11d | %15d | %8.2f\n", averageFinishTime, someNum/turnaroundTime.size(), someNewNumber/waitTime.size());
    } 
}
