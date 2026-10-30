public abstract class AbstractSupportRequest implements SupportRequest{
    private int id;
    private String title;
    private int basePoints;
    private boolean resolved;

    public AbstractSupportRequest(){
        this.id = id;
        this.title = title;
        this.basePoints = basePoints;
        this.resolved = resolved;
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