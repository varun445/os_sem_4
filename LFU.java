import java.util.ArrayList;
import java.util.HashMap;

public class LFU {
    public static int frequency = 0;
    public static void main(String[] args) {
        // int[] arr = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2};
        // int frames = 3;
        
        int[] arr = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
        int frames = 3;

        ArrayList<Integer> frameList = new ArrayList<>(frames);

        int hitCount = 0;
        int missCount = 0;

        ArrayList<String> hitOrMissList = new ArrayList<>();
        
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        int i = 0;
        while (frameList.size() != frames) {
            if(frameList.contains(arr[i])) {
                hitOrMissList.add("Hit");
                hitCount++;
                freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
            } else {
                frameList.add(arr[i]);
                hitOrMissList.add("Miss");
                missCount++;

                freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
            }
            i++;
        }

        while(i < arr.length) {
            if(frameList.contains(arr[i])) {
                hitCount++;
                hitOrMissList.add("Hit");
                freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
            } else {
                int index = getIndexOfLeastFreq(freqMap, frameList);
                int keyToRemoveFromArray = frameList.get(index);
                frameList.remove(index);
                freqMap.put(keyToRemoveFromArray, 0);

                frameList.add(arr[i]);
                freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);

                missCount++;
                hitOrMissList.add("Miss");
            }
            i++;
        }

        System.out.println(frameList);
        System.out.println(hitOrMissList);

        double hitRatio = ((double)hitCount / arr.length) * 100;
        double missRatio = ((double)missCount / arr.length) * 100;

        System.out.println(hitRatio);
        System.out.println(missRatio);
    }

    public static int getIndexOfLeastFreq(HashMap<Integer, Integer> freqMap, ArrayList<Integer> frameList) {
        int minFreq = Integer.MAX_VALUE;
        int indexToReturn = -1;
        for(int i = 0; i < frameList.size(); i++) {
            if(freqMap.get(frameList.get(i)) < minFreq) {
                minFreq = freqMap.get(frameList.get(i));
                indexToReturn = i;
            }
        }
        return indexToReturn;
    }
}
