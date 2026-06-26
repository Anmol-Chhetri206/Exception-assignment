import java.util.ArrayList;
import java.util.List;

public class TourismReportGenerator {
    public static void generateOverallReport(List<TouristDataSource> dataSources, DataProcessor processor){
        System.out.println("Generating overall tourism report...");
        for (TouristDataSource dataSource : dataSources) {
            List<String> rawData = null;

            try{
                rawData = dataSource.fetchData();
            }
            catch(DataSourceAccessException e){
                System.out.println("Could not fetch data from " + dataSource.sourceName + ": " + e.getMessage() + ". Skipping this source.");
                System.out.println("Cause: " + e.getCause());
                continue;
            }

            try{
                List<String> output = processor.process(rawData);
                for (String op : output) {
                    System.out.println(" Report from " + dataSource.sourceName + ": " + op);
                }
            }
            catch(DataProcessingException e){
                System.out.println("Error processing data from " + dataSource.sourceName + ": " + e.getMessage() + ". Skipping this data.");
            }
            finally{
                System.out.println("Data handling from " + dataSource.sourceName + " completed.");
            }
        }
    }

    public static void main(String[] args) {
        List<TouristDataSource> sources = new ArrayList<>();
        sources.add(new AirportArrivalDataSource());
        sources.add(new HotelRegistrationsDataSource());
        DataProcessor processor = new UniqueVisitorCounter();
        generateOverallReport(sources, processor);
    }
}
