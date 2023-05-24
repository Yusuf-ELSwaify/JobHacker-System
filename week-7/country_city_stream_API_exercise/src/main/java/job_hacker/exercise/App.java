package job_hacker.exercise;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import job_hacker.exercise.services.AppServices;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    private static final String COUNTRIES_CSV = "/Countries.csv";
    private static final String CITIES_CSV = "/Cities.csv";
    public static void main( String[] args )
    {
        AppServices appServices = new AppServices();
        File countryCSVFile = new File(App.class.getResource(COUNTRIES_CSV).getFile());
        try (CSVReader reader = new CSVReader(new FileReader(countryCSVFile))) {
            String[] line;

            while ((line = reader.readNext()) != null) {

                appServices.addCountry(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

        File citiesCSVFilePath = new File(App.class.getResource(CITIES_CSV).getFile());

        try (CSVReader reader = new CSVReader(new FileReader(citiesCSVFilePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                appServices.addCity(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

//        System.out.println("The highest populated city in each country:\n" + appServices.getHighestPopulatedCityInCountries());
//        System.out.println("______________________________________");
        System.out.println("The highest populated city in each country:\n" + appServices.getMapOfHighestPopulatedCityInEachCountry());
        System.out.println("______________________________________");
        System.out.println("______________________________________");

//        System.out.println("The highest populated city in each continent:\n"+appServices.getHighestPopulatedCityInContinents());
//        System.out.println("______________________________________");
        System.out.println("The highest populated city in each continent:\n" + appServices.getMapOfHighestPopulatedCityInEachContinentUsingGroupBy());
        System.out.println("______________________________________");
        System.out.println("______________________________________");

//        System.out.println("The highest populated capital city:\n" + appServices.getHighestPopulatedCapitalCity());
//        System.out.println("______________________________________");
        System.out.println("The highest populated capital city:\n" + appServices.getHighestPopulatedCapitalCityWithStreamFiltering());
        System.out.println("______________________________________");

        //System.out.println(appServices.getHighestPopulatedCityInContinent("Africa"));
        //System.out.println(appServices.getHighestPopulatedCityInContinent2("Europe"));
    }
}
