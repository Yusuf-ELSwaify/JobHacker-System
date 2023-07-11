package job_hacker.exercise.repositories;

import job_hacker.exercise.models.City;
import job_hacker.exercise.models.Country;

import java.util.*;

public class CountryRepository {
    private Map<String, Country> countryMap = new HashMap<>();
    List<City> capitalCities = new LinkedList<>();
    public void addCountry(Country country) {
        countryMap.put(country.getCode(), country);
    }
    public List<Country> getCountries() {
        return new ArrayList<>(countryMap.values());
    }
    public void addCity(City city) {
        Country country = countryMap.get(city.getCountryCode());
        if (country == null)
            System.out.println("error   "+city);
        if (country.getCapital()==city.getId())
            capitalCities.add(city);
        country.add(city);
    }

    public List<City> getCapitalCities() {
        return capitalCities;
    }
}
