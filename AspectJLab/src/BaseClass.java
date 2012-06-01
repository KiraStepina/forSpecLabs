
public class BaseClass {
	private void sayHello(){
		System.out.print("Hello ");
	}
	
	private void sayBuy(){
		System.out.print("Astalavista");
	}
	
	public static void main(String[] argc){
		BaseClass baseClass = new BaseClass();
		
		
		baseClass.sayHello();
		
		baseClass.sayBuy();
	}
	
}
