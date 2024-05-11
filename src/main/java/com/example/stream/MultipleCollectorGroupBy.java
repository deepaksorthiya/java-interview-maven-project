package com.example.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MultipleCollectorGroupBy {
    public static void main(String[] args) {
        List<Country> allCountries = getAllCountries();

/*
        Map<String, List<City>> map = allCountries.stream()
                .collect(Collectors
                        .groupingBy(Country::countryName, Collectors
                                .flatMapping(country -> country.states().stream(), Collectors
                                        .flatMapping(state -> state.cities().stream(), Collectors
                                                .toList()))));
*/

/*
            Map<String, List<City>> map = allCountries.stream().flatMap(country -> country.states.stream())
        .collect(Collectors
                .groupingBy(state -> state.stateName, Collectors.flatMapping(state ->state.cities.stream(), Collectors.toList())));
*/


/*
            Map<String, List<State>> map = allCountries.stream()
                .collect(Collectors
                        .groupingBy(Country::countryName, Collectors
                                .flatMapping(country -> country.states().stream(), Collectors.toList())));
*/

/*
        Map<String, List<List<State>>> map = new HashMap<>();
        allCountries.forEach(country -> {
            List<State> states = country.states();
            map.computeIfAbsent(country.countryName(), k -> new ArrayList<>()).add(states);
        });*/

        Map<String, Map<String, List<City>>> map = allCountries.stream()
                .collect(Collectors.groupingBy(country -> country.countryName(), Collectors
                        .flatMapping(country -> country.states().stream(), Collectors
                                .groupingBy(state -> state.stateName(), Collectors
                                        .flatMapping(o -> o.cities().stream(), Collectors
                                                .toList())))));

        printMap(map);
    }

    private static List<Country> getAllCountries() {
        //@formatter:off
        List<City> gujCities = List.of(
                new City(1,"Ahmedabad"),
                new City(2,"Vadodara"),
                new City(3,"Rajkot"),
                new City(4,"Bhuj")
        );
        List<City> mhCities = List.of(
                new City(5,"Mumbai"),
                new City(6,"Pune"),
                new City(7,"Nagpur"),
                new City(8,"Aurangabad")
        );
        List<City> upCities = List.of(
                new City(9,"Lucknow"),
                new City(10,"Prayagraj"),
                new City(11,"Ayodhya"),
                new City(12,"Raebareli")
        );

        List<State> indStates = List.of(
                new State(1, "Gujarat", gujCities),
                new State(2,"Maharashtra", mhCities),
                new State(3,"Uttar Pradesh", upCities)
        );

        List<City> californiaCities = List.of(
                new City(13,"Los Angeles"),
                new City(14,"San Diego"),
                new City(15,"San Jose"),
                new City(16,"Santa Barbara")
        );

        List<City> washingCities = List.of(
                new City(17,"Seattle"),
                new City(18,"Spoken"),
                new City(19,"Kent"),
                new City(20,"Yakima")
        );

        List<State> usStates = List.of(
                new State(4, "California", californiaCities),
                new State(5,"Washington", washingCities)
        );

        List<Country> allCountries = List.of(
                new Country(1,"INDIA", indStates),
                new Country(2,"USA", usStates)
        );
        //@formatter:on
        return allCountries;
    }

    private static void printMap(Map<?, ?> map) {
        System.out.println("#########################################");
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " :::: " + entry.getValue());
        }
        System.out.println("#########################################");
    }

    private record Country(int id, String countryName, List<State> states) {
        @Override
        public String toString() {
            return "{" +
                    "countryName='" + countryName + '\'' +
                    '}';
        }
    }

    private record State(int id, String stateName, List<City> cities) {
        @Override
        public String toString() {
            return "{" +
                    "stateName='" + stateName + '\'' +
                    '}';
        }
    }

    private record City(int id, String cityName) {
        @Override
        public String toString() {
            return "{" +
                    "cityName='" + cityName + '\'' +
                    '}';
        }
    }
}
