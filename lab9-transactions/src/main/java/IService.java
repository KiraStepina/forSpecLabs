
public interface IService {
	Product getProduct(String name);

	Product getProduct(String name, String barName);

	void insertProduct(Product product);

	void updateProduct(Product product);
}
