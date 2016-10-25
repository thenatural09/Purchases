package com.theironyard;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.persistence.ManyToOne;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Troy on 10/24/16.
 */
@Controller
public class PurchasesController {
    @Autowired
    CustomerRepository customers;

    @Autowired
    PurchaseRepository purchases;

    @PostConstruct
    public void init() throws FileNotFoundException {
        if (customers.count() == 0) {
            File f = new File("customers.txt");
            Scanner fileScanner = new Scanner(f);
            fileScanner.nextLine();
            while(fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] columns = line.split(",");
                String name = columns[0];
                String email = columns[1];
                Customer customer = new Customer(name,email);
                customers.save(customer);
            }
        }

        if (purchases.count() == 0) {
            File file = new File("purchases.txt");
            Scanner fileScanner = new Scanner(file);
            fileScanner.nextLine();
            while(fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] columns = line.split("\\,");
                String date = columns[1];
                String creditCard = columns[2];
                String cvv = (columns[3]);
                String category = columns[4];
                Customer customer = customers.findOne(Integer.valueOf(columns[0]));
                Purchase purchase = new Purchase(date,creditCard,Integer.valueOf(cvv),category,customer);
                purchases.save(purchase);
            }
        }
    }

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String home(Model model,String category) {
        Iterable<Purchase> plist;
        Iterable<Customer> clist = customers.findAll();

        if (category != null) {
            plist = purchases.findByCategory(category);
        }
        else {
            plist = purchases.findAll();
        }
        model.addAttribute("customers",clist);
        model.addAttribute("purchases",plist);
        return "home";
    }
}
