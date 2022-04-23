package com.product;

import java.sql.ResultSet;    
import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;    
    
public class productDAo {    
JdbcTemplate template;    
    
public void setTemplate(JdbcTemplate template) {    
    this.template = template;    
}    
public int save(Product p){    
    String sql="insert into eproduct(name,price) values('"+p.getName()+"',"+p.getPrice()+")";    
    return template.update(sql);    
}    
public int update(Product p){    
    String sql="update eproduct set name='"+p.getName()+"', price="+p.getPrice()+" where id="+p.getId()+"";    
    return template.update(sql);    
}    

public Product getproductbyid(int id){    
    String sql="select * from eproduct where id=?";    
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Product>(Product.class));    
}    
public List<Product> getProducts(){    
    return template.query("select * from eproduct",new RowMapper<Product>(){    
        public Product mapRow(ResultSet rs, int row) throws SQLException {    
            Product e=new Product();    
            e.setId(rs.getInt(1));    
            e.setName(rs.getString(2));    
            e.setPrice(rs.getInt(3));    
            e.setDate(rs.getString(4));    
            return e;    
        }    
    });    
}    
}   

