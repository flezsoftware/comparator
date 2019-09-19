package pl.flez.comparator.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class OldSystem implements KeyHolder<Integer>  {

    private Integer id;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if(getClass() == o.getClass()){
            OldSystem oldSystem = (OldSystem) o;
            return Objects.equals(this.getId(), oldSystem.getId());
        }
        if(NewSystem.class == o.getClass()){
            NewSystem newSystem = (NewSystem) o;
            return Objects.equals(this.getId(), newSystem.getId());
        }
       return  false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}
