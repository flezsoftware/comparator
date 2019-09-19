package pl.flez.comparator.model;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.validation.Valid;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentComparator <ID,S extends KeyHolder<ID>,T extends KeyHolder<ID>> {

    private final ConcurrentHashMap<ID, Pair<ID,S,T>> map = new ConcurrentHashMap<>();

    public synchronized Boolean addLeft(S left){
    //    System.out.println(left);
        if(!map.containsKey(left.getId())) {
            Pair<ID,S,T> pair = Pair.of(left,null);
            map.put(pair.getId(), pair);
        } else{
            final Pair<ID,S,T> pair =  map.get(left.getId());
            pair.setLeft(left);
            return  cleanCacheIfEquals(pair);
        }
        return false;
    }

    public synchronized  Boolean addRight(T right){
    //    System.out.println(right);
        if(!map.containsKey(right.getId())) {
            Pair<ID,S,T> pair  = Pair.of(null,right);
            map.put(pair.getId(), pair);
        } else{
            final Pair<ID,S,T> pair = map.get(right.getId());
            pair.setRight(right);
            return  cleanCacheIfEquals(pair);
        }
        return false;
    }

    private  synchronized boolean cleanCacheIfEquals(@Valid Pair<ID,S,T> pair){
        if(pair.exactlyEquals()){
        //    System.out.println("Matches " + pair);
            map.keySet().remove(pair.getId());
            return true;
        }
        return  false;
    }

    public synchronized int count(){
        return map.size();
    }

    public synchronized void clearMap(){
        map.clear();
    }
    public void displayMap(){
        System.out.println(map);
    }
}

