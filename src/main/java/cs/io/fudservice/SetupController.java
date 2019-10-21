package cs.io.fudservice;

import cs.io.fudservice.chef.AppRoleRepository;
import cs.io.fudservice.chef.AppUserRepository;
import cs.io.fudservice.entity.AppRole;
import cs.io.fudservice.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/setup")
public class SetupController {

    @Autowired
    private AppRoleRepository appRoleRepository;

    @Autowired
    private AppUserRepository appUserRepository;

    @RequestMapping("/init")
    @Transactional
    public String createTestData() {
        clearTestData();
        AppRole appAdmin = new AppRole("Admin");
        appRoleRepository.save(appAdmin);

        AppRole appChef = new AppRole("Chef");
        appRoleRepository.save(appChef);

        AppRole appCustomer = new AppRole("Customer");
        appRoleRepository.save(appCustomer);

        AppUser deviChef = new AppUser("Devi", "Vasantha", "3451 Chapel Oaks drive", "1903", "Coppell", "Texas", "United states", "vasanthadeiveehan@gmail.com", "vasanthadeiveehan@gmail.com");

        appUserRepository.save(deviChef);

        AppUser priyaChef = new AppUser( "Priya", "Srivatsan", "3451 Chapel Oaks drive", "1602", "Irving", "Texas", "United states", "priyasrivatsan@gmail.com", "priyasrivatsan@gmail.com");
        appUserRepository.save(priyaChef);

        AppUser jayashreeChef = new AppUser("Jayashree", "Nagaprabhu", "3451 Chapel Oaks drive", "1602", "Irving", "Texas", "United states", "jayashree@gmail.com", "jayashree@gmail.com");
        appUserRepository.save(jayashreeChef);


        AppUser keerthanaAdmin = new AppUser("Keerthana", "Deiveehan", "3451 Chapel Oaks drive", "1602", "Irving", "Texas", "United states", "keerthi@gmail.com", "keerthi@gmail.com");
        appUserRepository.save(keerthanaAdmin);

        AppUser deiveeCustomer = new AppUser("Deiveehan", "Nallazhagappan", "3451 Chapel Oaks drive", "1602", "Irving", "Texas", "United states", "deiveehan@gmail.com", "deiveehan@gmail.com");
        appUserRepository.save(deiveeCustomer);

//        AppUser deiveeCustomer = new AppUser("Deiveehan", "Nallazhagappan", "3451 Chapel Oaks drive", "1904", "Coppell", "Texas", "United states", "deiveehan@gmail.com");
//        appUserRepository.save(deiveeCustomer);

        return "Initial Setup data created.";
    }

    @RequestMapping("/clear")
    @Transactional
    public String clearTestData() {
        appUserRepository.deleteAll();
        appRoleRepository.deleteAll();
        return "Data cleared..";
    }

}
