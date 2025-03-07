package oc.epiccrafters.journey.blocks;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BlockFactory {

    final static Logger logger = LogManager.getLogger(BlockFactory.class);

    static public Set<IBlock> createBlocks(final int quantity, final Supplier<IBlock> blockSupplier) {
        Set<IBlock> blocks = new HashSet<IBlock>();
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

        List<Callable<IBlock>> tasks = new ArrayList<>(quantity);
        for (int i = 0; i < quantity; i++) {
            tasks.add(() -> blockSupplier.get());
        }

        try {
            List<Future<IBlock>> results = executorService.invokeAll(tasks);

            results.forEach(result -> {
                try {
                    blocks.add(result.get());
                } catch (InterruptedException | ExecutionException e) {
                    logger.error("Error while creating blocks");
                }
            });

        } catch (InterruptedException e) {
            logger.error("Error while creating blocks");
        }

        executorService.shutdown();

        return blocks;
    };
}