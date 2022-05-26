package productcrudapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrudapp.dao.ProductDao;
import productcrudapp.model.Product;

@Controller
public class HomeController {

	@Autowired
	private ProductDao productDao;
	
	
	// showing all objectd from database.
	
	@RequestMapping("/")
	public String home(Model m)
	{
		List<Product> products=productDao.getProducts();
		m.addAttribute("products",products);
		
		return "index";
	}
	
	//adding a single product
	@RequestMapping("/add-product")
	public String addProduct(Model m)
	{
		m.addAttribute("title","ADD PRODUCT RUNTIME");   // will be displayed as the title ,in add-product url ::::   
		return "add_product_form";
	}
	
	//show add -product form
	@RequestMapping(value="/handle-product" , method=RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product,HttpServletRequest request)
	{
		System.out.println(product);
     RedirectView redirectView= new RedirectView();

     // here when we provide the url / it will remove the project name, so need to get the context path using httprequest
      productDao.createProduct(product);
     redirectView.setUrl(request.getContextPath()+"/");
     
     
     return redirectView;
	}
	
	//deleting handler
	
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId") int productId ,HttpServletRequest request)
	{
	//path varible is used to bind the valued passed in url to the varable
		
		this.productDao.deleteProduct(productId);
    RedirectView redirectView= new RedirectView();

    // here when we provide the url / it will remove the project name, so need to get the context path using httprequest
      redirectView.setUrl(request.getContextPath()+"/");
    return redirectView;		
	}
	
	//updateing method
	
	@RequestMapping("/update/{product_id}")    // this is uri id , which will be receoved by @pathvarible at runtime in same name variable 
	public String updateform(@PathVariable("product_id") int pid, Model m)
	{
		//get the product which need to be updated acc to given id
		Product product = this.productDao.getProduct(pid);
		m.addAttribute("product",product);
		
		return "update_form";
	}
	
	
	
	
}
