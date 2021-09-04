package com.tradeup.addbook.controller;

import com.tradeup.addbook.api.Person;
import com.tradeup.addbook.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PersonController {
    //Not writing db code here because it's a presentation layer and, we have to only write presentation related code here
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String showAddressList(Model model) {
        //call the service method which call dao method to get data
        List<Person> addressList = personService.loadAddress();
        // for (Person per : addressList){
        // System.out.println(per);
        // }
        model.addAttribute("address", addressList);

        return "dashboard";
    }

    @RequestMapping(value = "/newAddress", method = RequestMethod.GET)
    public String AddAddress(@ModelAttribute("person") Person person) {
        //this is used to populate data in the form from Person class.
        return "add_address";
    }

    @RequestMapping(value = "/save-Address", method = RequestMethod.POST)
    public String savetodb(@ModelAttribute Person person, Model model) {
        //submitted newAddress will come here and the values are stored in person class.(Model)
        //System.out.println(person);
        //Make a call to service layer which next make to dao to save data to database

        //Using same method for new and update form. For new, id == 0, and update have an id;

        if (person.getId() == 0) {
            personService.savetodb(person);
            model.addAttribute("msg","Address inserted into database successfully");
        } else {
            personService.update(person);
            model.addAttribute("msg","Details updated successfully");
        }

        //Now data sent to service which forward to dao, where we can write db query and insert/update into db
        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/updateForm", method = RequestMethod.GET)
    public String UpdateAddress(@RequestParam("id") int id, @ModelAttribute("person") Person person) {
        Person pre = personService.getPerson(id);
        person.setId(pre.getId());
        person.setName(pre.getName());
        person.setEmail(pre.getEmail());
        person.setGender(pre.getGender());
        person.setAddress(pre.getAddress());
        person.setCity(pre.getCity());

        return "add_address";
    }

    @RequestMapping(value = "/DeleteAddress", method = RequestMethod.GET)
    public String DeleteAddress(@RequestParam("id") int id) {
        personService.delete(id);
        return "redirect:/dashboard";
    }
}
