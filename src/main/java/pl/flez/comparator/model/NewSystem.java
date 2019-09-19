package pl.flez.comparator.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
public class NewSystem implements KeyHolder<Integer> {

    private Integer id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if(getClass() == o.getClass()){
            NewSystem oldSystem = (NewSystem) o;
            return Objects.equals(this.getId(), oldSystem.getId());
        }
        if(OldSystem.class == o.getClass()){
            OldSystem newSystem = (OldSystem) o;
            return Objects.equals(this.getId(), newSystem.getId());
        }
        return  false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}
