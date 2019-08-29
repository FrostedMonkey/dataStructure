package map;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @ClassName Soluction
 * @Author chenchen
 * @Date 2019/8/4 20:44
 * @Version 1.0
 **/
public class Soluction {
    public int[] intersection(int[] nums1, int[] nums2) {
/*        TreeSet<Integer> set=new TreeSet<>();
        for(int num:nums1){
            set.add(num);
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int num:nums2){
            if(set.contains(num)){
                list.add(num);
                set.remove(num);
            }
        }
        int[] result=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i]=list.get(i);
        }
        return result;*/

        TreeMap<Integer,Integer> treeMap=new TreeMap();
        for (int num:nums1) {
            if(!treeMap.containsKey(num)){
                treeMap.put(num,1);
            }else{
                treeMap.put(num, treeMap.get(num)+1);
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        for (int num:nums2) {
            if(treeMap.containsKey(num)){
                if(treeMap.containsKey(num)){
                    list.add(num);
                    treeMap.put(num, treeMap.get(num)-1);
                    if(treeMap.get(num)==0){
                        treeMap.remove(num);
                    }
                }
            }
        }
        int[] result=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i]=list.get(i);
        }
        return result;
    }
}
