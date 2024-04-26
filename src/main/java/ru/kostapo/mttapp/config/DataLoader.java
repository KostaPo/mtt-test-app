package ru.kostapo.mttapp.config;

import com.github.javafaker.Faker;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.kostapo.mttapp.entity.Address;
import ru.kostapo.mttapp.entity.AddressType;
import ru.kostapo.mttapp.entity.Director;
import ru.kostapo.mttapp.entity.Organization;
import ru.kostapo.mttapp.service.OrganizationService;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Component
public class DataLoader implements ApplicationRunner {

    private final OrganizationService organizationService;
    private final Faker faker;
    private final Random random;

    public DataLoader(OrganizationService organizationService, Faker faker) {
        this.organizationService = organizationService;
        this.faker = faker;
        this.random = new Random();
    }

    @Override
    public void run(ApplicationArguments args) {
        List<Organization> organizationList = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            Organization organization = generateOrganization();
            if (i % 5 == 0) {
                List<Organization> branches = new ArrayList<>();
                int randomNumber = random.nextInt(5) + 1;
                for (int j = 0; j < randomNumber; j++) {
                    branches.add(generateOrganization());
                }
                organization.setBranches(branches);
            }
            organizationList.add(organization);
        }
        organizationService.saveAll(organizationList);
    }


    private Organization generateOrganization() {
        Director director = new Director();
        director.setFirstName(faker.name().firstName());
        director.setLastName(faker.name().lastName());
        director.setFatherName(faker.name().lastName());
        director.setDob(faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

        Address postAddress = new Address();
        postAddress.setAddress(faker.address().fullAddress());
        postAddress.setType(AddressType.POST);

        Address factAddress = new Address();
        factAddress.setAddress(faker.address().fullAddress());
        factAddress.setType(AddressType.FACT);

        Organization organization = new Organization();
        String fullName = faker.company().name();
        String shortName = fullName.substring(fullName.indexOf(" ") + 1);
        organization.setFullName(fullName);
        organization.setShortName(shortName);
        organization.setInn(faker.number().digits(10));
        organization.setOgrn(faker.number().digits(13));
        organization.setPost(postAddress);
        organization.setFact(factAddress);
        organization.setDirector(director);

        return organization;
    }
}