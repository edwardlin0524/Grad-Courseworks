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
1. **Open-Closed**
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
1. Liskov Substitution
1. Interface Segregation
1. Dependency Inversion

   
 
