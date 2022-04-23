package com.product;

import java.util.List;    
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;    
@Controller    
public class productController {    
    @Autowired    
    productDAo dao;   
        
    
    @RequestMapping("/productform")    
    public String showform(Model m){    
        m.addAttribute("command", new Product());  
        return "productform";   
    }    
 
    @RequestMapping(value="/save",method = RequestMethod.POST)    
    public String save(@ModelAttribute("product") Product product){    
        dao.save(product);    
        return "redirect:/viewproduct";    
    }    
       
    @RequestMapping("/viewproduct")    
    public String viewproduct(Model m){    
        List<Product> list=dao.getProducts();    
        m.addAttribute("list",list);  
        return "viewproduct";    
    }    
    
    @RequestMapping(value="/editproduct/{id}")    
    public String edit(@PathVariable int id, Model m){    
        Product product=dao.getproductbyid(id);    
        m.addAttribute("command",product);  
        return "producteditform";    
    }    
       
    @RequestMapping(value="/editsave",method = RequestMethod.POST)    
    public String editsave(@ModelAttribute("product") Product product){    
        dao.update(product);    
        return "redirect:/viewproduct";    
    }    
     
}  

