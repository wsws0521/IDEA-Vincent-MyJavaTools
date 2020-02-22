package cn.tomcatjdbc.dao;

import cn.tomcatjdbc.pojo.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class CommandLineCrudRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(CommandLineCrudRunner.class);

    @Autowired
//    private final CustomerRepository repository;

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
//        repository.save(new Customer("John", "Doe"));
//        repository.save(new Customer("Jennifer", "Wilson"));
//
//        logger.info("Customers found with findAll():");
//        repository.findAll().forEach(c -> logger.info(c.toString()));
//
//        logger.info("Customer found with findById(1L):");
//        Customer customer = repository.findById(1L)
//                .orElseGet(() -> new Customer("Non-existing customer", ""));
//        logger.info(customer.toString());
//
//        logger.info("Customer found with findByLastName('Wilson'):");
//        repository.findByLastName("Wilson").forEach(c -> {
//            logger.info(c.toString());
//        });
    }
}
