import java.util.List;
public abstract class TouristDataSource
{
    String sourceName;
    public TouristDataSource(String srcName)
    {
        this.sourceName = srcName;
    }
     public abstract void fetchData(List<String> data) throws DataSourceAccessException;
class DataSourceAccessException extends Exception
{
    public DataSourceAccessException(String message)
    {
        super(message);
    }
}
}