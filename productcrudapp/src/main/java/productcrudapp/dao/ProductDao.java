package productcrudapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productcrudapp.model.Product;

@Component                   //spring itself work on it
public class ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//create
	
	@Transactional                        //enalbles the create-update query
	public void createProduct(Product product)
	{
		//this.hibernateTemplate.save(product);
//handling the sava and update togethr
		
		this.hibernateTemplate.saveOrUpdate(product);
	
	}
	
	// get All products
	public List<Product> getProducts()
	{
		List<Product> products  = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	//delete the single product
	@Transactional
	public void deleteProduct(int pid)
	{                             //the delete fun take the obj as input so first fetch the project , then pass it in delete function
Product p=this.hibernateTemplate.load(Product.class,pid);
	this.hibernateTemplate.delete(p);
	}
	
	//get the single product
	
	public Product getProduct(int pid)
	{
		return this.hibernateTemplate.get(Product.class,pid);
	}
}
