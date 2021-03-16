package hu.nive.ujratervezes.zarovizsga.digitscounter;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DigitsCounter {

    private static final List<Character> NOTES = List.of('0','1','2','3','4','5','6','7','8','9');

    public int getCountOfDigits(String s){
        if(s == null || s.isEmpty()){
            return 0;
        }
        Set<Integer> intsInString = new HashSet<>();
        for(Character c : s.toCharArray()){
            if(NOTES.contains(c)){
                intsInString.add(Integer.parseInt(Character.toString(c)));
            }
        }
        return intsInString.size();
    }






}
