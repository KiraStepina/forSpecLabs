
public aspect BaseAspect {
	
	  pointcut greeting():
          execution(* BaseClass.sayHello(..));
	  
   pointcut printing():
          execution(* BaseClass.sayBuy(..));
   
   after() returning : greeting() {
            System.out.println("World !");
   }
   before() : printing() {
           System.out.print("Before World ");
   }
}
