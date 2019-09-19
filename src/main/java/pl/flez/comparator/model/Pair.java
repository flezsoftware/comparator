package pl.flez.comparator.model;

import lombok.Generated;
import lombok.NonNull;

import java.security.Key;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
@PairNotNull
public final class Pair<ID,S extends KeyHolder<ID>,T extends KeyHolder<ID>> {

    private  S left;
    private  T right;
    public static <ID,S extends KeyHolder<ID>, T extends KeyHolder<ID>> Pair<ID,S, T> of(S left, T right) {
        return new Pair(left, right);
    }
    
    public S getLeft() {
        return this.left;
    }

    public T getRight() {
        return this.right;
    }

    public void setLeft(S left) {
        this.left = left;
    }

    public void setRight(T right) {
        this.right = right;
    }

    public ID getId(){
        if(left!=null && left.getId()!=null){
            return  left.getId();
        }
        if(right!=null && right.getId()!=null){
            return right.getId();
        }
        return  null;
    }
    public static<ID,S extends KeyHolder<ID>, T extends KeyHolder<ID>>  Collector<Pair<ID,S, T>, ?, Map<S, T>> toMap() {
        return Collectors.toMap(Pair::getLeft, Pair::getRight);
    }

    @Generated
    public String toString() {
        return "Pair(left=" + this.getLeft() + ", right=" + this.getRight() + ")";
    }
/*
    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Pair)) {
            return false;
        } else {
            Pair<?, ?> other = (Pair)o;
            Object this$left = this.getLeft();
            Object other$left = other.getLeft();
            if (this$left == null) {
                if (other$left != null) {
                    return false;
                }
            } else if (!this$left.equals(other$left)) {
                return false;
            }

            Object this$right = this.getRight();
            Object other$right = other.getRight();
            if (this$right == null) {
                if (other$right != null) {
                    return false;
                }
            } else if (!this$right.equals(other$right)) {
                return false;
            }

            return true;
        }
    }

    @Generated
    public int hashCode() {
        int PRIME = 1;
        int result = 1;
        Object $left = this.getLeft();
        result = result * 59 + ($left == null ? 43 : $left.hashCode());
        Object $right = this.getRight();
        result = result * 59 + ($right == null ? 43 : $right.hashCode());
        return result;
    }
*/


    @Override
    public int hashCode() {
        //if(left.g)
        return 1;
    }

    @Generated
    private Pair(S left, T right) {
        if (left == null && right == null) {
            throw new IllegalArgumentException("left or right cannot be a null");
        } {
            this.left = left;
            this.right = right;
        }
    }

    public boolean notNull(){
        if (this.left != null && right != null){
            return  true;
        }
        return  false;
    }

    public boolean exactlyEquals(){
        return  (notNull() && left.equals(right));
    }

}
