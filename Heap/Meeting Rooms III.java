// https://leetcode.com/problems/meeting-rooms-iii/description/

// | Metric                | Code 1 (PriorityQueue)   | Code 2 (Linear Scan)   |
// | --------------------- | ------------------------ | ---------------------- |
// | Time Complexity       | **O(m log m + m log n)** | **O(m log m + m × n)** |
// | Space Complexity      | O(n)                     | O(n)                   |
// | Performance (large n) | ✅ Better                 | ❌ Slower               |
// | Code Simplicity       | Medium (PQ logic)        | ✅ Simple               |
import java.util.*;
class Solution {
    public int mostBooked(int n, int[][] meetings) {

        Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));

        int roomUsedCount[] = new int[n];


        // [endtime of meeting,  room number]
        var usedRooms = new PriorityQueue<long[]>(  
            (a,b) -> a[0] != b[0] ? 
            Long.compare(a[0],b[0]) :
            Long.compare(a[1], b[1])
        ); // min heap but agar end time same to eske room par sort ho jayeee

        // var unUsedRooms = new PriorityQueue<Integer>();// by default min hi hoti hai
        PriorityQueue<Integer> unUsedRooms = new PriorityQueue<>();

        for(int room = 0; room < n ;room++){
            unUsedRooms.add(room); // initially to sare unUsed me hongaaa
        }


        for(int meet[] : meetings){
            int st = meet[0];
            int end = meet[1];

            //used queue me jo meetings hongi or unki ending esase st me pahele hogi un sab ko pop kar dengee....... or unko unUsedRoom Vale queue me put kar dnege....
            while(!usedRooms.isEmpty() && usedRooms.peek()[0] <= st){
                int room = (int)usedRooms.poll()[1]; // sare meeting jinking st time less hogi sab room ka room number nikal lengee
                unUsedRooms.add(room); //or unko hum add kar lenge unUsedRoom vali array me
            }

            if(!unUsedRooms.isEmpty()){
                int room = (int)unUsedRooms.poll();
                usedRooms.add(new long[]{end, room});
                roomUsedCount[room]++;
            }
            else{
                // sare es time bar busy hai then dekhene pahele konsa finish hogaaaa
                // jo top me hoga usedRoom vale queue me 
                // long temp[] = usedRooms.poll();
                // int room = (int)temp[1];
                int room = (int)usedRooms.peek()[1];
                
                long endTime = usedRooms.poll()[0] ;

                //add akr diyaa esko fir se add
                usedRooms.add(new long[]{endTime + (end - st), room});
                roomUsedCount[room]++;
            }
        }

        // last approach ki tarh same
        int resultRoom = -1;
        int maxUse = 0;
        for(int room = 0; room < n; room++){
            if(roomUsedCount[room] > maxUse){
                maxUse = roomUsedCount[room];
                resultRoom = room;
            }
        }

        return resultRoom;
    }
}

// class Solution {
//     public int mostBooked(int n, int[][] meetings) {
//         // Array ko sort kar ko
//         Arrays.sort(meetings, (a,b) -> Integer.compare(a[0], b[0]));

//         int roomUsedCount [] = new int[n];
        
//         long roomAvailableAt []= new long[n];

//         for(int meet[] : meetings){
//             int st = meet[0];
//             int end = meet[1];

//             boolean found = false;

//             int earlyEndRoom = 0; // room number
//             long earlyEndRoomTime = Long.MAX_VALUE;



//             //find the first available meeting
//             for(int room = 0 ; room < n ; room++){

//                 if(roomAvailableAt[room] <= st ) {
//                     // initial ke 0 to usame st hamesa jada hoga to easily assign kar dengee
//                     found = true;
//                     roomAvailableAt[room] = end;
//                     roomUsedCount[room]++;
//                     break;
//                 }


//                 // early end ka bhi yahi calculate karo loo
//                 if(roomAvailableAt[room] < earlyEndRoomTime){
//                     earlyEndRoomTime = roomAvailableAt[room]; // uska timee
//                     earlyEndRoom = room; // room number kon sa hogaa 
//                 }
//             }


//             if(!found){
//                 roomAvailableAt[earlyEndRoom] += (end - st);
//                 roomUsedCount[earlyEndRoom]++;
//             }
//         }

//         int resultRoom = -1;
//         int maxUse = 0;

//         for(int room = 0 ; room < n ; room++){
//             if(roomUsedCount[room] > maxUse){
//                 maxUse = roomUsedCount[room];
//                 resultRoom = room;
//             }
//         }

//         return resultRoom;
//     }
// }