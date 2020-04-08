package com.springdatarest.memory.overflow;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.rest.core.mapping.ResourceMappings;
import org.springframework.stereotype.Component;

import java.util.Vector;

@Component
public class AfterStartup {
    private final Vector v = new Vector();
    private final ResourceMappings mappings;

    public AfterStartup(ResourceMappings resourceMappings) {
        this.mappings = resourceMappings;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        snapshotInfo(mappings);

        while(mappings.get().count() > 0){
            consumeMb(1);
            snapshotInfo(mappings);
            System.gc();
        }
    }

    private void snapshotInfo(ResourceMappings mappings){
        Runtime rt = Runtime.getRuntime();
        System.err.println("Spring Data Rest mappings available: " + mappings.get().count() + ", Free memory: " +rt.freeMemory());
    }

    public void consumeMb(int megabytes) {
        System.err.println("Consume " + megabytes + "MB");
        for (int i = 0; i < megabytes; i++) {
            byte b[] = new byte[1048576];
            v.add(b);
        }
    }
}
