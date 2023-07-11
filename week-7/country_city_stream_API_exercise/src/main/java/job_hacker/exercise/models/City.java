package job_hacker.exercise.models;

public class City {
    private final int id;
    private final String name;
    private final int population;
    private final String countryCode;

    public City(CityBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.population = builder.population;
        this.countryCode = builder.countryCode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public static class CityBuilder {
        private int id;
        private String name;
        private int population;
        private String countryCode;

        public CityBuilder() {
        }

        public CityBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public CityBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public CityBuilder setPopulation(int population) {
            this.population = population;
            return this;
        }

        public CityBuilder setCountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }
        public City build() {
            return new City(this);
        }
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
