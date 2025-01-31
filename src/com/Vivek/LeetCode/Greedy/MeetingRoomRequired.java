package com.Vivek.LeetCode.Greedy;

import java.util.Scanner;

public class MeetingRoomRequired {

    static class Pair{
        int start; int end;
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    static void meetingRoom(Pair[] meetings){
        Pair[] room = new Pair[meetings.length];
        int roomRequired = 0;
        if(meetings.length != 0){
            room[0] = meetings[0];
            roomRequired++;
        }else{
            System.out.println("There are no meetings.");
        }

        for(int currMeeting = 1; currMeeting < meetings.length; currMeeting++){
            if(room[currMeeting - 1].end > meetings[currMeeting].start){
                // Giving meeting a new room.
                room[currMeeting] = meetings[currMeeting];
                roomRequired++;
            }else{
                // We are giving a new room but not counting as previous meeting is over for this case.
                room[currMeeting] = meetings[currMeeting];
            }
        }
        System.out.println("Total room required " + roomRequired);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("How many meetings??");
        int n = input.nextInt();
        Pair[] meetings = new Pair[n];
        System.out.println("Insert each meeting: a b");
        for(int i = 0; i < n; i++){
            int f = input.nextInt();
            int s = input.nextInt();
            Pair p = new Pair(f, s);
            meetings[i] = p;
        }
        meetingRoom(meetings);
    }
}
