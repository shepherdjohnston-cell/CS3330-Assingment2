public class NetworkIssueRequest extends AbstractSupportRequest {
    private final int affectedUsers

    public NetworkIssueRequest(int id, String title, int basePoints, int affectedUsers) {
        super(id, title, basePoints);

        if (affectedUsers <= 0){
            throw new IllegalArgumentException("Affected users must be positive.");
        }        

        this.affectedUser = affectedUsers;
    }

    @Override
    public int resolvesFor(Technician technician){
        int points = getBasePoints() + (affectedUsers * 2); //Weighted rule, so affected users matters more than base points
        technician.addPoints(points);
        return points;
    }

    public int getAffectedUsers(){
        return affectedUsers;
    }
}