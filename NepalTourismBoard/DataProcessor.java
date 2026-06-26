package NepalTourismBoard;
import java.util.List;
public interface DataProcessor 
{
  public List<String> process(List<String> rawData) throws DataProcessingException;
  public static void main(String[] args) { }
    
}
class DataProcessingException extends DataSourceAccessException
{
    public DataProcessingException(String message)
    {
        super(message);
    }
}