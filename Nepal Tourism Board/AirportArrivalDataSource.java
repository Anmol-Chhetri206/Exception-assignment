public class AirportArrivalDataSource extends TouristDataSource
{
    public AirportArrivalDataSource(String srcName)
    {
        super(srcName);
    }
}
class ConnectionLostException extends DataSourceAccessException
{
    public ConnectionLostException(String message)
    {
        super(message);
    }
}
