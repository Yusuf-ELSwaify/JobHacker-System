package job_hacker.exercise.models;

import java.util.LinkedList;
import java.util.List;

public class Country {
    private final String code;
    private final String name;
    private final String continent;
    private final double surfaceArea;
    private final int population;
    private final double gnp;
    private final int capital;
    private final List<City> cities;

    public Country(CountryBuilder builder) {
        this.code = builder.code;
        this.name = builder.name;
        this.continent = builder.continent;
        this.surfaceArea = builder.surfaceArea;
        this.population = builder.population;
        this.gnp = builder.gnp;
        this.capital = builder.capital;
        cities = new LinkedList<>();
    }
    public void add(City city) {
        cities.add(city);
    }
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getContinent() {
        return continent;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public int getPopulation() {
        return population;
    }

    public double getGnp() {
        return gnp;
    }

    public int getCapital() {
        return capital;
    }

    public List<City> getCities() {
        return cities;
    }

    public static class CountryBuilder {
        private String code;
        private String name;
        private String continent;
        private double surfaceArea;
        private int population;
        private double gnp;
        private int capital;

        public CountryBuilder() {
        }

        public CountryBuilder setCode(String code) {
            this.code = code;
            return this;
        }

        public CountryBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CountryBuilder setContinent(String continent) {
            this.continent = continent;
            return this;
        }

        public CountryBuilder setSurfaceArea(double surfaceArea) {
            this.surfaceArea = surfaceArea;
            return this;
        }

        public CountryBuilder setPopulation(int population) {
            this.population = population;
            return this;
        }

        public CountryBuilder setGnp(double gnp) {
            this.gnp = gnp;
            return this;
        }

        public CountryBuilder setCapital(int capital) {
            this.capital = capital;
            return this;
        }
        public Country build() {
            return new Country(this);
        }
    }
}
