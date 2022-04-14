package com.github.jsofosu;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day2 {
    /**
     * scan every box and produce a list of the likely candidates (your puzzle input).
     * pick a string check the characters to see which one appears more than once.
     */


//    public List<Character> countBoxIdContainingExactlyTwoOfAnyLetter(String boxId) {
//        List<Character> listOfLettersRepeatingTwice = new ArrayList<>();
//
//        for (int i = 0; i < boxId.length(); i++) {
//            int increment = 1;
//            if (!listOfLettersRepeatingTwice.contains(boxId.charAt(i))) {
//                for (int j = i + 1; j < boxId.length() - 1; j++) {
//                    if (boxId.charAt(i) == boxId.charAt(j)) {
//                        increment += 1;
//                    }
//                }
//            }
//            if (increment == 2) {
//                listOfLettersRepeatingTwice.add(boxId.charAt(i));
//            }
//        }
//        return listOfLettersRepeatingTwice;
//    }

    public int checkSum(List<String> listOfBoxId){
        int numberOfBoxIDThatContainsALetterThatAppearsTwice = 0;
        int numberOfBoxIDThatContainsALetterThatAppearsThrice = 0;
        for (String s : listOfBoxId) {
            numberOfBoxIDThatContainsALetterThatAppearsTwice = countBoxIdContainingExactlyTwiceOfAnyLetter(s).isEmpty() ? numberOfBoxIDThatContainsALetterThatAppearsTwice : numberOfBoxIDThatContainsALetterThatAppearsTwice + 1;
            numberOfBoxIDThatContainsALetterThatAppearsThrice = countBoxIdContainingExactlyThreeOfAnyLetter(s).isEmpty() ? numberOfBoxIDThatContainsALetterThatAppearsThrice : numberOfBoxIDThatContainsALetterThatAppearsThrice + 1;
        }

        return numberOfBoxIDThatContainsALetterThatAppearsTwice*numberOfBoxIDThatContainsALetterThatAppearsThrice;
    }

    public List<Character> countBoxIdContainingExactlyThreeOfAnyLetter(String boxId) {
        Stream<Character> characterStream = boxId.chars().mapToObj(c -> (char) c);
        Map<Character, Long> list= characterStream.collect(Collectors.groupingBy(Character::charValue, Collectors.counting()));
        return list.keySet()
                .stream()
                .filter(i -> list.get(i) == 3)
                .collect(Collectors.toList());
    }

    public List<Character> countBoxIdContainingExactlyTwiceOfAnyLetter(String boxId) {
        Stream<Character> characterStream = boxId.chars().mapToObj(c -> (char) c);
        Map<Character, Long> list= characterStream.collect(Collectors.groupingBy(Character::charValue, Collectors.counting()));
        return list.keySet()
                .stream()
                .filter(i -> list.get(i) == 2)
                .collect(Collectors.toList());
    }

}
