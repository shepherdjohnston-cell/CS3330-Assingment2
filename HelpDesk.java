public class HelpDesk {
    private Map<Integer, SupportRequest> requestsById;
    private Map<Technician, List<SupportRequest>> assignments;

    public HelpDesk(){
        this.requestsById = new HashMap<>();
        this.assignments = new HashMap<>();
    }

    public void addRequest(SupportRequest request){
        if (requestsById.containsKey(request.getId())) throw new IllegalArgumentException("Duplicate Id is already in help desk.");
        requestsById.put(request.getId(), request);
    }

    public SupportRequest findRequest(int id){
        if (requestsById.containsKey(id)) return requestsById.get(id);
        return null;
    }

    public void assignRequest(Technician technician, int requestId){
        SupportRequest request = findRequest(requestId);

        if (request == null)  throw new IllegalArgumentException("Request does not exist.");

        if (technician == null) throw new IllegalArgumentException("Technician cannot be null.");

        List<SupportRequest> techAssignments = assignments.get(technician);        
        if (techAssignments == null){
            techAssignments = new ArrayList<>();
            assignments.put(technician, techAssignments);
        }

        //Enforcing no duplicate id's assigned to one technican rule
        if (techAssignments.contains(request)){
            throw new IllegalArgumentException("Request ID is already in technician's assingment list.");
        }

        techAssignments.add(request);
    }

    public int resolveRequest(Technician technician, int requestId){
        SupportRequest request = findRequest(requestId);

        if (request == null) throw new IllegalArgumentException("RequestId is not in list.");
    

        if (technician == null) throw new IllegalArgumentException("Technician canot be null.");

        if (!(assignments.containsKey(technician))) throw new IllegalArgumentException("Technician is not in assignment list.");

        if (!(assignments.get(technician).contains(request))) throw new IllegalArgumentException("Request is not assigned to technician.");

        return request.resolveFor(technician);
    }

    public void printAllRequests(){
        for (SupportRequest request : requestsById.values()){
            System.out.println(request.toString());
        }
    }

    public void printAssignmentsFor(Technician technician){
        if (technician == null) throw new IllegalArgumentException("Technician cannot be null.");
        if (!(assignments.containsKey(technician))) throw new IllegalArgumentException("Technician is not in assignment list.");

        System.out.println(technician.getName());
        for (SupportRequest request : assignments.get(technician)){
            System.out.println(request.toString());
        }
    }
}