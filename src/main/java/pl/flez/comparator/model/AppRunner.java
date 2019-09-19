package pl.flez.comparator.model;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppRunner implements CommandLineRunner {
    private final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private  final ComparatorService comparatorService;
    @Override
    public void run(String... args) throws Exception {
        logger.info(String.valueOf(comparatorService.addLeft(createNewSystem(1))) + " size =" + comparatorService.count());
        logger.info(String.valueOf(comparatorService.addLeft(createNewSystem(1))) + " size =" + comparatorService.count());
        logger.info(String.valueOf(comparatorService.addRight(createOldSystem(2))) + " size =" + comparatorService.count());
        logger.info(String.valueOf(comparatorService.addRight(createOldSystem(1))) + " size =" + comparatorService.count());
        logger.info(String.valueOf(comparatorService.addLeft(createNewSystem(4))) + " size =" + comparatorService.count());
        logger.info(String.valueOf(comparatorService.addLeft(createNewSystem(2))) + " size =" + comparatorService.count());
        logger.info(String.valueOf(comparatorService.addRight(createOldSystem(2))) + " size =" + comparatorService.count());
        logger.info(String.valueOf(comparatorService.addLeft(createNewSystem(3))) + " size =" + comparatorService.count());
        logger.info(String.valueOf(comparatorService.addRight(createOldSystem(5))) + " size =" + comparatorService.count());
        logger.info(String.valueOf(comparatorService.addRight(createOldSystem(3))) + " size =" + comparatorService.count());
        logger.info(String.valueOf(comparatorService.addRight(createOldSystem(4))) + " size =" + comparatorService.count());

        Integer singeThreadCount = comparatorService.count();
        comparatorService.displayMap();
        comparatorService.clearMap();;

        Runnable[] runners = new Runnable[11];
        Thread[] threads = new Thread[11];
        runners[0] = new MultiThreadJob(true,1,comparatorService);
        runners[1] = new MultiThreadJob(true,1,comparatorService);
        runners[2] = new MultiThreadJob(false,2,comparatorService);
        runners[3] = new MultiThreadJob(false,1,comparatorService);
        runners[4] = new MultiThreadJob(true,4,comparatorService);
        runners[5] = new MultiThreadJob(true,2,comparatorService);
        runners[6] = new MultiThreadJob(false,2,comparatorService);
        runners[7] = new MultiThreadJob(true,3,comparatorService);
        runners[8] = new MultiThreadJob(false,5,comparatorService);
        runners[9] = new MultiThreadJob(false,3,comparatorService);
        runners[10] = new MultiThreadJob(false,4,comparatorService);
        for(int i=0; i<11; i++) {
            threads[i] = new Thread(runners[i]);
        }

        for(int i=0; i<11; i++) {
            Thread.sleep(5);
            threads[i].start();
        }
        Thread.sleep(3000);
        logger.info(String.valueOf(singeThreadCount.equals(comparatorService.count())));
        comparatorService.displayMap();
    }
    public static NewSystem createNewSystem(Integer id){
        final NewSystem obj = new NewSystem();
        obj.setId(id);
        return  obj;
    }

    public static OldSystem createOldSystem(Integer id){
        final OldSystem obj = new OldSystem();
        obj.setId(id);
        return  obj;
    }


}
