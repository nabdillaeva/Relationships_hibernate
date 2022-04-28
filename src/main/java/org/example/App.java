package org.example;


import org.example.models.Capital;
import org.example.models.Country;
import org.example.repositories.CapitalRepository;
import org.example.repositories.CountryRepository;

public class App
{
    public static void main( String[] args ) {

        CountryRepository countryRepository = new CountryRepository();
        CapitalRepository capitalRepository = new CapitalRepository();

//        Country country = new Country("Kyrgyzstan","S. Japarov");
//        Country country2 = new Country("Russia","V.Putin");
//        Capital capital = new Capital("Bishkek",199.97,2000000l);
//        Capital capital2 = new Capital("Moscow",20000.22,20000000l);
//
//
//        country2.setCapital(capital2);
//        capital2.setCountry(country2);
//        countryRepository.save(country2);
//        capitalRepository.update(capital2);

        //countryRepository.findAll().forEach(System.out::println);

        //  System.out.println(countryRepository.findById(1l));

        countryRepository.deleteById(1l);



    }
}
