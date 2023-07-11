package job_hacker.exercise.services;

import job_hacker.exercise.models.City;
import job_hacker.exercise.models.Country;
import job_hacker.exercise.repositories.ContinentRepository;
import job_hacker.exercise.repositories.CountryRepository;

import java.util.*;
import java.util.stream.Collectors;


public class AppServices {
    CountryRepository countryRepository = new CountryRepository();
    ContinentRepository continentRepository = new ContinentRepository();
    public void addCountry(String[] line) {

        Country.CountryBuilder builder = new Country.CountryBuilder().setCode(line[0].trim())
                .setName(line[1].trim()).setContinent(line[2].trim()).setSurfaceArea(Double.parseDouble(line[3]))
                .setPopulation((int) Double.parseDouble(line[4])).setGnp(Double.parseDouble(line[5]))
                .setCapital(Integer.parseInt(line[6]));
        Country country = builder.build();

        countryRepository.addCountry(country);
        continentRepository.addCountry(country);
    }
    public void addCity(String[] line) {
        City.CityBuilder builder = new City.CityBuilder().setId(Integer.parseInt(line[0]))
                .setName(line[1].trim()).setPopulation(Integer.parseInt(line[2])).setCountryCode(line[3].trim());
        City city = builder.build();

        countryRepository.addCity(city);
    }

    public List<City> getListOfHighestPopulatedCityInEachCountry(){
        return countryRepository.getCountries().stream()
                .map(country -> country.getCities().stream().max(Comparator.comparingInt(City::getPopulation)))
                .map(city -> city.orElse(null)).collect(Collectors.toList());
    }
    public Map<String, Optional<City>> getMapOfHighestPopulatedCityInEachCountry(){
        return countryRepository.getCountries().stream()
                .collect(
                        Collectors.toMap(
                                country -> country.getCode()+":"+country.getName(),
                                country -> country.getCities()
                                        .stream().max(Comparator.comparingInt(City::getPopulation))
                        ));
    }
    public Map<String, Optional<City>> getMapOfHighestPopulatedCityInEachContinent(){
        return continentRepository.getContinentMap().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .flatMap(country -> country.getCities().stream())
                                .max(Comparator.comparingInt(City::getPopulation))
                ));
    }
    public Map<String, Optional<City>> getMapOfHighestPopulatedCityInEachContinentUsingGroupBy(){
        return countryRepository.getCountries().stream()
                .collect(Collectors.groupingBy(Country::getContinent)).entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .flatMap(country -> country.getCities().stream())
                                .max(Comparator.comparingInt(City::getPopulation))
                ));
    }
    public City getHighestPopulatedCapitalCity(){
        return countryRepository.getCapitalCities().stream()
                .max(Comparator.comparingInt(City::getPopulation)).orElse(null);
    }
    public City getHighestPopulatedCapitalCityWithStreamFiltering(){
        return countryRepository.getCountries().stream()
                .flatMap(country -> country.getCities().stream()
                        .filter(city -> city.getId() == country.getCapital()))
                .max(Comparator.comparingInt(City::getPopulation))
                .orElse(null);
    }
    public City getHighestPopulatedCityInContinent(String continent){
        return continentRepository.getContinentCountries(continent).stream()
                .flatMap(country -> country.getCities().stream())
                .max(Comparator.comparing(City::getPopulation))
                .orElse(null);
    }
    public City getHighestPopulatedCityInContinentWithStreamFiltering(String continent){
        return countryRepository.getCountries().stream()
                .filter(country -> country.getContinent().equals(continent))
                .flatMap(country -> country.getCities().stream())
                .max(Comparator.comparing(City::getPopulation))
                .orElse(null);
    }
}
