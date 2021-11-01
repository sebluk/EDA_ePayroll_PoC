// package org.acme.repositories;
// import java.time.LocalDate;
// import java.util.*;
// import java.util.stream.Collectors;
// import org.acme.model.Epayroll;


// import javax.annotation.PostConstruct;
// import javax.enterprise.context.ApplicationScoped;

// @ApplicationScoped
// public class EpayrollRepository {

//     private Set<Epayroll> epayrolls = new HashSet<>();

//     public EpayrollRepository() {
//         add(new Epayroll(123456789, "paydac", "John Smith","new hire","John doe",234567891,"1",50000.0,10000.0,500.0,200.0,100.0,300.0));
//         add(new Epayroll(123456788, "paydac2", "John Smith2","new hire","John doe2",234567892,"2",60000.0,20000.0,600.0,300.0,400.0,300.0));
//     }

//     public Epayroll add(Epayroll epayroll) {
//         //epayroll.setId((long) (employees.size() + 1));
//         epayrolls.add(epayroll);
//         return epayroll;
//     }


//     public Set<Epayroll> findAll() {
//         return epayrolls;
//     }

// }