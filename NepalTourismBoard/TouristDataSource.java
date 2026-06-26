package NepalTourismBoard;
import java.util.List;
public abstract class TouristDataSource
{
    String sourceName;
    public TouristDataSource(String srcName)
    {
        this.sourceName = srcName;
    }
    public abstract List<String> fetchData() throws DataSourceAccessException;
      public static void main(String[] args) 
    {
        
    } 
}
class DataSourceAccessException extends Exception
{
    public DataSourceAccessException(String message)
    {
        super(message);
    }
}
