package test;

import tree.TreeMap;
import 接口.Set;

import java.util.ArrayList;

public class TestTreeMap {
    public static void main(String[] args) {
        TreeMap<String,Integer> map= new TreeMap<>();
        ArrayList<String> words=new ArrayList<>();
        //FileOperation.readFile("pride-and-prejudice.txt",words);
        for (String word:words){
            if (!map.contains(word)){
                map.put(word,1);
            }else {
                map.set(word,map.get(word)+1);
            }
        }
        System.out.println("总单词个数："+map.size());
        Set<String> set=map.keySet();
        for (String word:set){
            System.out.println(word+":"+map.get(word));
        }
    }
}
