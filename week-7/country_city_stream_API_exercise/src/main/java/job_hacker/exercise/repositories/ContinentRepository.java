package job_hacker.exercise.repositories;

import job_hacker.exercise.models.Country;

import java.util.*;

public class ContinentRepository {
    private Map<String, List<Country>> continentMap = new HashMap<>();
    public void addCountry(Country country) {
        continentMap.computeIfAbsent(country.getContinent(), k -> new LinkedList<Country>()).add(country);
    }
    public List<Country> getContinentCountries(String continent) {
        return continentMap.get(continent);
    }

    public Map<String, List<Country>> getContinentMap() {
        return continentMap;
    }
}
