import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FCFS {
    public static void main(String[] args) {
        // int[] burstTime = {6, 2, 3, 1, 2};
        // int[] arrivalTime = {0, 1, 1, 2, 2};

        int[][] arrivalTimeAndBurstTime = {
            {0, 6},
            {1, 2},
            {1, 3},
            {2, 1},
            {2, 2}
        };

        Arrays.sort(arrivalTimeAndBurstTime, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for(int i = 0; i < arrivalTimeAndBurstTime.length; i++) {
            System.out.println("Arrival Time: " + arrivalTimeAndBurstTime[i][0] + " Burst Time: " + arrivalTimeAndBurstTime[i][1]);
        }

        // finish time
        ArrayList<Integer> finishTime = new ArrayList<>();
        int a = 0;
        int b = arrivalTimeAndBurstTime[0][1];
        System.out.println(b);
        finishTime.add(b);
        for(int i = 1; i < arrivalTimeAndBurstTime.length; i++) {
            a = b;
            b = a + arrivalTimeAndBurstTime[i][1];
            finishTime.add(b);
        }
        int averageFinishTime = b / finishTime.size();
        System.out.println(finishTime);
        System.out.println(averageFinishTime);
    
        // Turnaround time
        ArrayList<Integer> turnaroundTime = new ArrayList<>();
        int someNum = 0;
        for(int i = 0; i < arrivalTimeAndBurstTime.length; i++) {
            someNum += finishTime.get(i) - arrivalTimeAndBurstTime[i][0]; 
            turnaroundTime.add(finishTime.get(i) - arrivalTimeAndBurstTime[i][0]);
        }
        System.out.println(turnaroundTime);
        System.out.println(someNum/turnaroundTime.size());

        // Waiting time
        ArrayList<Integer> waitTime = new ArrayList<>();
        float someNewNumber = 0;
        for(int i = 0; i < arrivalTimeAndBurstTime.length; i++) {
            someNewNumber += turnaroundTime.get(i) - arrivalTimeAndBurstTime[i][1];
            waitTime.add(turnaroundTime.get(i) - arrivalTimeAndBurstTime[i][1]);
        }
        System.out.println(waitTime);
        System.out.println(someNewNumber/waitTime.size());
    } 
}
