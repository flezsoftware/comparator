package pl.flez.comparator.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PairValidator <ID,S extends KeyHolder<ID>,T extends KeyHolder<ID>> implements ConstraintValidator<PairNotNull,Pair<ID,S ,T>> {

    @Override
    public boolean isValid(Pair<ID, S, T> value, ConstraintValidatorContext context) {
        return false;
    }

    @Override
    public void initialize(PairNotNull constraintAnnotation) {

    }
}