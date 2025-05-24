package co.edu.umanizales.myfirstapi.service;

import co.edu.umanizales.myfirstapi.model.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ParameterService {

    private List<Parameter> parameters = new ArrayList<>();

    @Value("${typeDocument_filename}")
    private String typeDocumentFile;

    @Value("${typeProduct_filename}")
    private String typeProductFile;

    @Value("${product_filename}")
    private String productFile;

    @PostConstruct
    public void getAllData() throws IOException {
        getTypeDocumentsFromCSV();
        getTypeProductsFromCSV();
        getProductsFromCSV();
    }

    private void getTypeDocumentsFromCSV() throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(new ClassPathResource(typeDocumentFile).getFile()))) {
            reader.skip(1); // Skip header
            String[] row;
            while ((row = reader.readNext()) != null) {
                TypeDocument document = new TypeDocument(row[0], row[1]);
                parameters.add(document);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException("Error reading type document file", e);
        }
    }

    private void getTypeProductsFromCSV() throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(new ClassPathResource(typeProductFile).getFile()))) {
            reader.skip(1);
            String[] row;
            while ((row = reader.readNext()) != null) {
                TypeProduct type = new TypeProduct(row[0], row[1]);
                parameters.add(type);
            }
        } catch (CsvValidationException e) {
            throw new RuntimeException("Error reading type product file", e);
        }
    }

    private void getProductsFromCSV() throws IOException {
        try (CSVReader reader = new CSVReader(new FileReader(new ClassPathResource(productFile).getFile()))) {
            reader.skip(1);
            String[] row;
            while ((row = reader.readNext()) != null) {
                Product product = new Product(
                        row[0],
                        row[1],
                        Double.parseDouble(row[2]),
                        getParameterByCode(row[3]) // Link to TypeProduct
                );
                parameters.add(product);
            }
        } catch (CsvValidationException | NumberFormatException e) {
            throw new RuntimeException("Error reading product file", e);
        }
    }

    public void addParameter(Parameter parameter) {
        parameters.add(parameter);
    }

    public List<Parameter> getAllParameters() {
        return parameters;
    }

    public List<Parameter> getParametersByType(int type) {
        List<Parameter> result = new ArrayList<>();
        for (Parameter p : parameters) {
            if (type == 1 && p instanceof TypeDocument) result.add(p);
            if (type == 2 && p instanceof TypeProduct) result.add(p);
            if (type == 3 && p instanceof Product) result.add(p);
        }
        return result;
    }

    public Parameter getParameterByCode(String code) {
        for (Parameter p : parameters) {
            if (p.getCode().equals(code)) {
                return p;
            }
        }
        return null;
    }

}


