class slip13_1 extends Thread
{  
  public void run()
{  
   System.out.println("running...");  
  }  
 public static void main(String args[])
{  
  slip13_1 t1=new slip13_1();  
  slip13_1 t2=new slip13_1();  
  System.out.println("Name of t1:"+t1.getName());  
  System.out.println("Name of t2:"+t2.getName());  
   
  t1.start();  
  t2.start();  
  
}    
}  