package com.kula.conferencetrack.slot;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Factory class for Slot creatin
 */
public class SlotFactory {

    private static Map<SlotType, Supplier<Slot>> slotTypesSupplierMap = new HashMap<>();
    static {
        slotTypesSupplierMap.put(SlotType.MORNING,MorningSlot::new);
        slotTypesSupplierMap.put(SlotType.LUNCH,LunchSlot::new);
        slotTypesSupplierMap.put(SlotType.AFTERNON, AfternoonSlot::new);
        slotTypesSupplierMap.put(SlotType.NETWORK,NetworkingSlot::new);
    }

    public static Slot getSlot(SlotType slotType){
        Supplier<Slot> slotSupplier = slotTypesSupplierMap.get(slotType);
        if(slotSupplier != null){
            return slotSupplier.get();
        }
        return null;
    }




}
