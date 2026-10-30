package com.helpdesk;

import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        System.out.println("Creating technicians");
        Technician tech1 = new Technician("Ryan");
        Technician tech2 = new Technician("Jeff");
        Technician tech3 = new Technician("Lucy");
        Technician tech4 = new Technician("Lucy");

        List<Technician> techRoster = new ArrayList<>();
        techRoster.add(tech1);
        techRoster.add(tech2);
        techRoster.add(tech3);
        techRoster.add(tech4);

        System.out.println("Creating both Password Reset Requests");
        SupportRequest req1 = new PasswordResetRequest(101, "Reset Portal Password", 10, "jsmith");
        SupportRequest req2 = new PasswordResetRequest(102, "Reset Portal Password", 15, "preal");

        System.out.println("Creating both Network Issue Requests");
        SupportRequest req3 = new NetworkIssueRequest(103, "Router 4 down", 60, 25);
        SupportRequest req4 = new NetworkIssueRequest(104, "Switch 2 down", 30, 15);

        System.out.println("Creating both Device Setup Requests");
        SupportRequest req5 = new DeviceSetupRequest(105, "New Laltop Setup", 20, 1);
        SupportRequest req6 = new DeviceSetupRequest(106, "Computer Lab Setup", 70, 15);
        
        HelpDesk helpDesk = new HelpDesk();

        System.out.println("Adding Requests to help desk.");
        helpDesk.addRequest(req1);
        helpDesk.addRequest(req2);
        helpDesk.addRequest(req3);
        helpDesk.addRequest(req4);
        helpDesk.addRequest(req5);
        helpDesk.addRequest(req6);

        System.out.println("Attempting to add duplicate request id to help desk.");
        try {
            helpDesk.addRequest(req1);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught duplicate id insertion attempt.");
        }

        System.out.println("Assigning technicians to requests.");
        helpDesk.assignRequest(tech1, req5.getId());
        helpDesk.assignRequest(tech1, req2.getId());
        helpDesk.assignRequest(tech2, req4.getId());
        helpDesk.assignRequest(tech3, req6.getId());

        System.out.println("Resolving 3 requests.");
        helpDesk.resolveRequest(tech1, req2.getId());
        helpDesk.resolveRequest(tech2, req4.getId());
        helpDesk.resolveRequest(tech3, req6.getId());

        System.out.println("Printing All Requests: ");
        helpDesk.printAllRequests();

        System.out.println("Printing All Assignments");
        helpDesk.printAssignmentsFor(tech1);
        helpDesk.printAssignmentsFor(tech2);
        helpDesk.printAssignmentsFor(tech3);
        helpDesk.printAssignmentsFor(tech4);

        System.out.println("Printing Technicians total service points: ");
        System.out.println(tech1.getName() + ": " + tech1.getServicePoints());
        System.out.println(tech2.getName() + ": " + tech2.getServicePoints());
        System.out.println(tech3.getName() + ": " + tech3.getServicePoints());
        System.out.println(tech4.getName() + ": " + tech4.getServicePoints());


        System.out.println("Printing total service points in system across all technicians: ");
        System.out.println("Total points: " + HelpDeskUtil.sumPoints(techRoster));
    }
}
