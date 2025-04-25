package co.edu.umanizales.myfirstapi.service;

import co.edu.umanizales.myfirstapi.model.Location;
import co.edu.umanizales.myfirstapi.model.Seller;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;


import java.io.IOException;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class SellerService {

    private final LocationService locationService;

    @Autowired
    public SellerService(LocationService locationService) {
        this.locationService = locationService;
    }


    @Getter
    private List<Seller> sellers;

    @Value("${sellers_filename}")
    private String sellerFilename;

    @PostConstruct
    public void readLocationsFromCSV()  {
        sellers = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(
                new InputStreamReader(new ClassPathResource(sellerFilename).getInputStream()))) {

            String[] line;
            csvReader.skip(1); // Omitir cabecera si aplica

            while ((line = csvReader.readNext()) != null) {
                sellers.add(new Seller(
                        line[0], // identification
                        line[1], // name
                        line[2], // lastName
                        line[3].charAt(0), // gender
                        Byte.parseByte(line[4] ),// age
                        (Location) locationService.getLocationByCode(line[5])));
            }

        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("Error leyendo el archivo CSV", e);
        }
    }

}