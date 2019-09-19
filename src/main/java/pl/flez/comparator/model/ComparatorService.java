package pl.flez.comparator.model;

import org.springframework.stereotype.Service;

@Service
public class ComparatorService extends ConcurrentComparator<Integer,NewSystem,OldSystem> {
}
