import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;


public class ServiceImpl implements IService {
	
	private BasicDataSource bds;

	public BasicDataSource getBds() {
		return bds;
	}
	public void setBds(BasicDataSource bds) {
		this.bds = bds;
	}
	public Product getProduct(String name) {
        throw new UnsupportedOperationException();
    }
   public Product getProduct(String name, String barName)  {
        throw new UnsupportedOperationException();
   }
   public void insertProduct(Product  product) {
	   try {
		   bds.getConnection().createStatement().execute("create table \"Product\" (varchar(50) name, varchar(50) price)");  
		bds.getConnection().createStatement().execute(String.format("insert into Product values ('%1$s','%2$s')",product.getName(),product.getPrice()));
	} catch (SQLException e) {
		throw new UnsupportedOperationException();
	}
        //throw new UnsupportedOperationException();
   }
   public void updateProduct(Product  product) {
        throw new UnsupportedOperationException();
   }

}
