# Object Oriented Software Development  

Object Oriented Software Development is how we sturcture code solutions to keep it maintainable. We might have to work with others on the same long-term project, everyone benefits from writing the most maintainable and extensible code they can. The better the code and the design is, the easier it is to make changes or additions to the code when requirements are changed or added and the less risky they are.

**Refactoring**  
Change the structure of the code without changing its functionality. Refactoring can increase potential for extensibility and maintainability, remove dependencies and even erase potential bugs.

**SOLID Principles**  
1. **Single Responsibility**:  
   A class/method should do only **one thing** and do it well. 
      **Why using Singel Responsibility?** 
      Because more responsibilities of a class lead to more dependencies, more dependencies lead to more complexities and more complexities lead to more opportunities to break.  

    Take following pseudo code for Example, this is a pseudo class for sending email:
    ```
      public class Email { 
    	public void sendMessage(){ 
    		ServerConnection conn = new ServerConnection(); 
    		conn.open();
    		// imagine more robust code for sending all pieces of the email (to/from/subject, etc.) 
    		for(char c: body) 
    			conn.readChar(c); 
    		conn.close(); 
    	} 
    	public void printMessage(){ 
    		String formattedMessage; 
    		System.out.println(body); 
    	} 
    }
    ```  
    As we can see, there are two things in this class, which are opening up server connections and a method of format of printing. For a sending email class, it should only do one thing, which is sending the email. Therefore, this class violated the principle of Single Responsibility.
    
    **As a very general rule of thumb, the longer a class is, the more likely it violates the SRP.**
1. **Open-Closed**:  
Software Entities (classes, functions, etc.) should be **open for extension, closed for modification**. We should extend the code rather than change the code that already works. Modifying working code may introduce bugs.
   
   The good way to follow open-closed principle is to use **abstraction**.  We create a class based on that abstraction can make us to extend the code.  

   Take following code for example:
    ``` 
        public interface Shape { } 
        class Circle implements Shape { 
        	Circle(int radius) { /* ... */ } 
        } 
        class Rectangle implements Shape { 
        	Rectangle(int height, int width) { /* ... */ } 
        } 
        public class Main { 
        	public static void main (String[] args) { 
        		Shape[] shapes = new Shape[2]; 
        		shapes[0] = new Circle(1); 
        		shapes[1] = new Rectangle(1, 2); 
        		writeShapes(shapes); 
        	} 
        	public static void writeShapes(Shape[] shapes){ 
        		for(Shape shape:shapes){ 
        			if(shape instanceof Circle) System.out.println("Circle"); 
        			else if(shape instanceof Rectangle) System.out.println("Rectangle"); 
        		} 
    	} 
    } 
    ```
    In this case, everything seems OK, but what if we want to add a shape? we have to modify the the writeShapes method. This violates Open-Closed principle.
    
    Hueristics:
    1.Make all member variables private:In this way, we can force all child class add behavior rather than modify it. 
    2.RTTI (Run-time type identification) is dangerous: Method should not depend on specific types (like the above code did).
1. **Liskov Substitution**
    if S is a subtype of T, then objects of type T in a program may be replaced with objects of type S without altering any of the desirable properties of that program. -by Wikipedia

    Take bird and ostrich for example (Credit goes to https://www.jyt0532.com/2020/03/22/lsp/):
   Let's say we have a class Bird:
    ```
    class Bird{
    public void fly(){
        // Fly!
     }
    }
    ```
    Even Ostrich can not fly, it still is one of the birds:
    ```
    class Ostrich extends Bird{
    @Override
    public void fly(){
    // Cannot fly
    throw new RuntimeException();
    }
    }
    ```
    In this case, Ostrich is Bird's **SubClass** because Ostrich uses inheritence; However Ostrich is not Bird's **SubType** because Bird **CAN NOT be replaced** by Ostrich (Ostrich can not fly), this violate the definition of SubType.
    
    Let's look another example- **Rectangle and Square**
    
    ```
    class Rectangle { 
	private double height; 
	private double width; 
	public setHeight(double newHeight) { height = newHeight; } 
	public setWidth(double newWidth) { width = newWidth; } 
	public double getHeight() { return height; } 
	public double getWidth() { return width; } } 
	
	class Square extends Rectangle{
	public setHeight(double newHeight) { height = newHeight; } 
	public setWidth(double newWidth) { width = newWidth; } 
	}
    public class Main { 
	public static void main (String[] args) { 
		Rectangle r = new Rectangle(); 
		setInitialHeightAndWidth(r); 
		Square s = new Square();
		setInitialHeightAndWidth(s); 
	} 
	public static void setInitialHeightAndWidth(Rectangle r){ 
		r.setHeight(5); r.setWidth(10); 
	    } 
    } 
    ```
    In this example, Square is not a SubType of Rectangle Because the method *setInitialHeightAndWidth* only receive class Rectangle as parameter, using Square as parameter would leads program fail.
    
1. **Interface Segregation**
Clients should not be forced to depend upon interfaces that they do not use.

    Example: (Credit goes to https://dzone.com/articles/solid-principles-by-example-interface-segregation)
    Let's say we have a interface called ISmartDevice:
    ```
    interface ISmartDevice
    {
        void Print();
        void Fax();
        void Scan();
    }
    ```
    We have an inplementation of this interface called AllInOnePrinter
    ```
    class AllInOnePrinter : ISmartDevice
    {
        public void Print()
        {
             // Printing code.
        }
        public void Fax()
        {
             // Beep booop biiiiip.
        }
        public void Scan()
        {
             // Scanning code.
        }
    }
    ```

    However, what if we have a printer which basically only do printing?
    ```
    class EconomicPrinter : ISmartDevice
    {
        public void Print()
        {
            //Yes I can print.
        }
        public void Fax()
        {
            throw new NotSupportedException();
        }
        public void Scan()
        {
            throw new NotSupportedException();
        }
    }
    ```
    This violates Interface Segregation. How we solve this? Just break the ISmartDevice into three smaller interfaces, each interface only contains one method. In this way, the class which only does printing can inheritant the IPrinter interface instead of inheritant all methods that it does not need.  

1. **Dependency Inversion**
   High-level modules should not depend on low-level modules. Both should depend on abstractions.

   
 
