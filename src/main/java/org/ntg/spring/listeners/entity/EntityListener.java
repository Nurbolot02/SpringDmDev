package org.ntg.spring.listeners.entity;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EntityListener {
    @EventListener
    public void acceptEvent(EntityEvent entityEvent){
        System.out.println("Entity: " + entityEvent);
    }
}
