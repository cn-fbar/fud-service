package cs.io.fudservice;

import cs.io.fudservice.chef.AdminRepository;
import cs.io.fudservice.chef.ChefRepository;
import cs.io.fudservice.chef.CustomerRepository;
import cs.io.fudservice.entity.Admin;
import cs.io.fudservice.entity.Chef;
import cs.io.fudservice.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/setup")
public class SetupController {

    @Autowired
    private ChefRepository chefRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/init")
    @Transactional
    public String createTestData() {
        clearTestData();
        Admin appaAdmin = new Admin(null, "Nallazhagappan", "Rengasamy", "nazhagappan@gmail.com", "https://drive.google.com/file/d/1FVqPhDNaGm2XauY21GFInJcM2cAUmwoW/view?usp=sharing");
        adminRepository.save(appaAdmin);

        Chef deviChef = new Chef(null, "Devi", "Vasantha", "3451 Chapel Oaks drive", "1903", "Coppell", "Texas", "United states", "good in non-veg, specialities - Chicken khorma, chapathi, dosa batter, soup", 4.5, "vasanthadeiveehan@gmail.com", "https://drive.google.com/open?id=13JqhYnd8Y3br2rW5GlMVnHDCrqw4zH4V");
        chefRepository.save(deviChef);

        Chef priyaChef = new Chef(null, "Priya", "Srivatsan", "3451 Chapel Oaks drive", "1602", "Irving", "Texas", "United states", "veg, specialities - Gobi, panneer, paratha", 3.5, "priyasrivatsan@gmail.com", "https://drive.google.com/file/d/1Pzpa6yDL7rFfQraSqbR-XRZypf6atJbG/view?usp=sharing");
        chefRepository.save(priyaChef);

        Chef jayashreeChef = new Chef(null, "Priya", "Srivatsan", "3451 Chapel Oaks drive", "1602", "Irving", "Texas", "United states", "veg, specialities - Gobi, panneer, paratha", 3.5, "priyasrivatsan@gmail.com", "https://drive.google.com/file/d/1Pzpa6yDL7rFfQraSqbR-XRZypf6atJbG/view?usp=sharing");
        chefRepository.save(priyaChef);

        Customer deiveeCustomer = new Customer(null, "Deiveehan", "Nallazhagappan", "3451 Chapel Oaks drive", "1904", "Coppell", "Texas", "United states", "deiveehan@gmail.com", "https://s3-us-west-1.amazonaws.com/co-directory-images/deiveehan.jpg");
        customerRepository.save(deiveeCustomer);

        return "Initial Setup data created.";
    }

    @RequestMapping("/clear")
    @Transactional
    public String clearTestData() {
        chefRepository.deleteAll();
        customerRepository.deleteAll();
        adminRepository.deleteAll();
        return "Initial Setup data created.";
    }

}
