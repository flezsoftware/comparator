package pl.flez.comparator.model;


import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.validation.Valid;

public abstract class Comparator<ID,S extends KeyHolder<ID>,T extends KeyHolder<ID>> {

    private final MultiValueMap<ID, Pair<ID,S,T>> map = new LinkedMultiValueMap<>();

    public synchronized Boolean addLeft(S left){
   //     System.out.println(left);
        if(!map.containsKey(left.getId())) {
            map.add(left.getId(), Pair.of(left,null));
        } else{
            final Pair<ID,S,T> pair =  map.getFirst(left.getId());
            pair.setLeft(left);
            return  cleanCacheIfEquals(pair);
        }
        return false;
    }

    public synchronized  Boolean addRight(T right){
      //  System.out.println(right);
        if(!map.containsKey(right.getId())) {
            map.add(right.getId(), Pair.of(null,right));
        } else{
            final Pair<ID,S,T> pair = map.getFirst(right.getId());
            pair.setRight(right);
            return  cleanCacheIfEquals(pair);
        }
        return false;
    }

    private synchronized boolean cleanCacheIfEquals(@Valid Pair<ID,S,T> pair){
        if(pair.exactlyEquals()){
       //     System.out.println("Matches " + pair);
            map.keySet().remove(pair.getId());
           // map.remove(pair);
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

}
