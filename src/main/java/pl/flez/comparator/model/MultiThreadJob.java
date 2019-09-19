package pl.flez.comparator.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MultiThreadJob implements Runnable {
    private final boolean left;
    private final Integer id;
    private final ComparatorService comparatorService;

    @Override
    public void run() {
        if(left) {
        System.out.println(String.valueOf(comparatorService.addLeft(AppRunner.createNewSystem(id))) + " size =" + comparatorService.count());
        } else {
            System.out.println(String.valueOf(comparatorService.addRight(AppRunner.createOldSystem(id))) + " size =" + comparatorService.count());
        }
    }
}
