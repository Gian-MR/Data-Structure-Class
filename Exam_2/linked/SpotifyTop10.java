package Exam_2.linked;

import java.util.*;

public class SpotifyTop10 {
    public static void main(String[] args) {

        LinkedList<String> top10 = new LinkedList<>();

        top10.add("Blinding Lights - The Weeknd");
        top10.add("Shape of You - Ed Sheeran");
        top10.add("Dance Monkey - Tones and I");
        top10.add("Someone You Loved - Lewis Capaldi");
        top10.add("As It Was - Harry Styles");
        top10.add("Rockstar - Post Malone");
        top10.add("One Dance - Drake");
        top10.add("Closer - The Chainsmokers");
        top10.add("Sunflower - Post Malone");
        top10.add("Bad Guy - Billie Eilish");

        System.out.println("Top 10 canciones más populares en Spotify:");
        for (String song : top10) {
            System.out.println(song);
        }

        System.out.println("\nDespués del salto circular");

        //? temps
        String first = top10.getFirst();
        String last = top10.getLast();
        
        top10.removeFirst();
        top10.removeLast();
        top10.addFirst(last);
        top10.addLast(first);
        
        for (String song : top10) {
            System.out.println(song);
        }

    }
}