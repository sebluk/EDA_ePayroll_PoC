package org.acme;
import org.acme.model.Epayroll;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Date;
import java.time.LocalDate;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.*;

@Path("/epayroll")
public class EpayrollResource {

    private Set<Epayroll> epayrolls = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public EpayrollResource() {
        epayrolls.add(new Epayroll(1, "12345678" ,"john doe",LocalDate.of(2014, 9, 12),LocalDate.of(2015, 9, 12),"fired","mike",123456789,"abc123",60000.0,20000.0,5000.0,1000.0,1000.0,500.0));
        epayrolls.add(new Epayroll(2, "23456789" ,"mike doe",LocalDate.of(2014, 10, 11),LocalDate.of(2020, 9, 21),"fired","john",123456799,"adfd123",60000.0,20000.0,5000.0,1000.0,1000.0,500.0));
        epayrolls.add(new Epayroll(3, "34567891" ,"ashish doe",LocalDate.of(2019, 9, 8),LocalDate.of(2021, 9, 2),"active","doe",153456789,"abc134",60000.0,20000.0,5000.0,1000.0,1000.0,500.0));
        epayrolls.add(new Epayroll(4, "45678912" ,"doe",LocalDate.of(2010, 9, 1),LocalDate.of(2018, 9, 4),"fired","john",125456789,"abth3",60000.0,20000.0,5000.0,1000.0,1000.0,500.0));
        epayrolls.add(new Epayroll(5, "56789123" ,"john",LocalDate.of(2008, 2, 2),LocalDate.of(2014, 2, 1),"active","john doe",173456789,"ab3453",60000.0,20000.0,5000.0,1000.0,1000.0,500.0));
    }


    @GET
    public Set<Epayroll> list() {
        return epayrolls;
    }
    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }


}