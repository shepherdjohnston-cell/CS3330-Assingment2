public abstract class AbstractSupportRequest implements SupportRequest{
    private final int id;
    private final String title;
    private final int basePoints;
    private boolean resolved;

    public AbstractSupportRequest(int id, String title, int basePoints){
        if (id <= 0) {
            throw new IllegalArgumentException("Request ID must be greater than 0.")
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be null or blank.")
        }
        if (basePoints <= 0){
            throw new IllegalArgfumentException("Base Points must be greater than 0.")
        }
        this.id = id;
        this.title = title;
        this.basePoints = basePoints;
        this.resolved = false;
    }

    protected void markResolved() {
        if (this.resolved){
            throw new IllegalStateException("Request ID: " + id + " is already marked as resolved.")
        }
    }

    @Override
    public int getId(){
        return id;
    }

    @Override
    public String getTitle(){
        return title;
    }

    @Override
    public int getBasePoints(){
        return basePoints;
    }

    @Override
    public boolean isResolved(){
        return resolved;
    }

    @Override
    public String toString(){
        return String.format("ID: %d | Title: \"%s\" | Base Points: %d | Resolved: %s", id, title, basePoints, resolved ? "Yes" : "No");
    }
}