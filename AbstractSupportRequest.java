public abstract class AbstractSupportRequest implements SupportRequest{
    private int id;
    private String title;
    private int basePoints;
    private boolean resolved;

    public AbstractSupportRequest(int id, String title, int basePoints){
        if (id <= 0) {
            throw new IllegalArgumentException("Request ID must be greater than 0.")
        }
        if (title == NULL || title.isBlank()) {
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


    @Override
    public int getId(){
        return this.id;
    }

    @Override
    public String getTitle(){
        return this.title;
    }

    @Override
    public int getBasePoints(){
        return this.basePoints;
    }

}