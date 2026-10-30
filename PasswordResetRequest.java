public class PasswordResetRequest extends AbstractSupportRequest {
    private final String accountName

    public PasswordResetRequest(int id, String title, int basePoints, String accountName){
        super(id, title, basePoints);

        if (accountName == NULL || accountName.isBlank()){
            throw new IllegalArgumentException("Account name cannot be null or blank.")
        }

        this.accountName = accountName;
    }

    @Override
    public int resolveFor(Technician technician){
        markResolved();

        int points = getBasePoints();
        technician.addPoints(points);
        return points;
    }

    public String getAccountName() {
        return accountName;
    }
}