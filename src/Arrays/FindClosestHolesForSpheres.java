package Arrays;

/*
While exploring an ancient tomb for treasure, you've come across a room with magical spheres, each a different color. You see a number of color-coded holes. To advance to the next room, you need to carry each sphere to one of the holes of the same color. You can only hold one sphere at a time, and you'd like to carry them as short a distance as possible.

For example, let's look at the following room layout:
room1 = ..b.r..r.R.B...b

- Capital letters represent spheres.
- Lower-case letters represent holes.
- Periods represent empty spaces without holes or spheres.

In this case, the red sphere at position 9 can be taken to either 4 or 7, and the blue sphere at 11 can be taken to 2 or 15.

 Move R sphere 2 spaces left to r
              +---+
              v   |
. . b . r . . r . R . B . . . b
                      |       ^
                      +-------+
        Move B sphere 4 spaces right to b

To minimize the time holding the spheres:
- Carry the red sphere from 9 to 7, a distance of 2
- Carry the blue sphere from 11 to 15, a distance of 4
Total Distance: 6

Write a function that, given a room layout, determines the minimum total distance carrying spheres required to put all the spheres in appropriate holes.

Note: There will only be one sphere of each color, but there may be multiple places to put each sphere. You may only hold one sphere at once, and only distance carrying a sphere is counted.

Additional Input:
room2 = "RBGYygbr"
room3 = ".........."
room4 = "abcbabbcbaAabcabcabbBabbabcabcbbC"
room5 = "rRBGYygbr"

Complexity Variable:
N = size of the room
(Note: Number of spheres would not be constant as we might expand later to consider other symbols)

All Test Cases:
distance(room1) => 6
distance(room2) => 16
distance(room3) => 0 There are no spheres, so no distance is required.
distance(room4) => 5
distance(room5) => 10
*/


import java.io.*;
import java.util.*;

public class FindClosestHolesForSpheres {
    public static void main(String[] argv) {
        String room1 = "..b.r..r.R.B...b";
        System.out.println(room1 + " >> " + calculateDistance(room1));
        String room2 = "RBGYygbr";
        System.out.println(room2 + " >> " + calculateDistance(room2));
        String room3 = "..........";
        System.out.println(room2 + " >> " + calculateDistance(room3));
        String room4 = "abcbabbcbaAabcabcabbBabbabcabcbbC";
        System.out.println(room2 + " >> " + calculateDistance(room4));
        String room5 = "rRBGYygbr";
        System.out.println(room2 + " >> " + calculateDistance(room5));



    }

    private static int calculateDistance (String room) {
        Map<Character, List<Integer>> holesIndex = new HashMap<>();
        int distanceCount = 0;
        for (int i = 0; i < room.length(); i++) {
            char c = Character.toLowerCase(room.charAt(i));
            //System.out.println("room.charAt(i): " + room.charAt(i));
            if (room.charAt(i) >= 'a' && room.charAt(i) <= 'z') {
                //System.out.println("found a hole: " + c);
                //found a hole
                if (null != holesIndex.get(c)) {
                    List<Integer> holesIndices = holesIndex.get(c);
                    holesIndices.add(i);
                } else {
                    List<Integer> holesIndices = new ArrayList<Integer>();
                    holesIndices.add(i);
                    holesIndex.put(room.charAt(i), holesIndices);
                }
            } else if (room.charAt(i) >= 'A' && room.charAt(i) <= 'Z') {
                //System.out.println("found a sphere: " + room.charAt(i));
                //found a sphere
                if (null != holesIndex.get(c)) {
                    //System.out.print("holesIndex found: ");
                    // for (int k = 0; k < holesIndex.get(c).size(); k++) {
                    //   System.out.print(holesIndex.get(c).get(k) + " " );
                    // }
                    //System.out.println();
                    List<Integer> holes = holesIndex.get(c);
                    int currentDistance = i - holes.get(holes.size()-1);
                    // System.out.println("currentDistance: " + currentDistance);
                    int holeToTheRightCount = 0;
                    // System.out.println("finding hole to the right from " + i + " position. room.length(): " + room.length());
                    for (int j = i+1; j < room.length(); j++) {
                        // System.out.println("finding hole to the right: " + Character.toLowerCase(room.charAt(j)) + " >><< " + c);
                        if (Character.toLowerCase(room.charAt(j)) != c) {
                            holeToTheRightCount++;
                        } else {
                            holeToTheRightCount++;
                            // System.out.println("found one at " + j + "position");
                            break;
                        }
                    }
                    // System.out.println("holeToTheRightCount: " + holeToTheRightCount);
                    distanceCount += (holeToTheRightCount == 0 || currentDistance < holeToTheRightCount) ? currentDistance : holeToTheRightCount;
                    // System.out.println("distanceCount: " + distanceCount);
                } else {
                    int holeToTheRightCount = 0;
                    for (int j = i; j < room.length(); j++) {
                        if (room.charAt(j) == c) {
                            break;
                        } else {
                            holeToTheRightCount++;
                        }
                    }
                    distanceCount += holeToTheRightCount;
                }
            }
        }
        return distanceCount;
    }
}

