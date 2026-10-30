package com.helpdesk;

import java.util.List;
import java.util.ArrayList;

public final class HelpDeskUtil {

    private HelpDeskUtil(){
        throw new UnsupportedOperationException("Utility class cannot be instantiated.");
    }

    public static <T> void printAll(List<T> items){
        if (items == null) return;

        for (T item : items) {
            System.out.println(item);
        }
    }

    public static int sumPoints(List<? extends Technician> technicians){
        if (technicians == null) return 0;

        int total = 0;
        for (Technician technician : technicians){
            if (technician != null) total = total + technician.getServicePoints();
        }

        return total;
    }
}
