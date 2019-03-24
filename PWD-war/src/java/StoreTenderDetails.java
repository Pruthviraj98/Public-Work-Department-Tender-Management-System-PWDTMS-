
import java.util.Date;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pruthviraj Patil
 */
class MyException extends Exception 
{ 
    public MyException(String s) 
    { 
        // Call constructor of parent Exception 
        super(s); 
    } 
} 
  
interface tender1{
    void DisplayTender(contractor obj, Tender[] objects);
    void getTenderDetails(contractor obj, Tender object, int n);
    void getAuth(Tender[] objects, int tenderNumber);
}

class Tender{
    String constructionType;
    int budget;
    String place;
    String start;
    String end;
    String approved;//used only by the PWD and Senior officers  
    int TenderNumber;
}

class contractor extends Tender implements tender1{
    String name;
    String phno;
    String City;
    int nTenders=0;
    int []tenderNumbers=new int[100];
    
    void getDetails(String nam){
      Scanner sc=new Scanner(System.in);
      System.out.println("FILL THE FORM:");
      name=nam;
      System.out.println("Enter the phno:");
      phno=sc.next();
      System.out.println("Enter the City:");
      City=sc.next();
    }
    
    public void getTenderDetails(contractor obj, Tender object, int tenderNumber){
        
        tenderNumbers[nTenders]=tenderNumber;
        nTenders+=1;
        Scanner sc=new Scanner(System.in);
        
        System.out.println("ENTER THE TYPE OF TENDER");
        String type=new String();        
        type=sc.next();
        object.constructionType=type;
        
        System.out.println("ENTER THE BUDGET");
        int money=sc.nextInt();
//        obj.budget=money;
        object.budget=money;
        
        System.out.println("ENTER THE PLACE OF CONSTRUCTION");
        String pl=sc.next();
        object.place=pl;
        
        
        System.out.println("ENTER THE START DATE OF CONSTRUCTION");
        String st=sc.next();
        object.start=st;
        
        System.out.println("ENTER THE ESTIMATED END DATE OF CONSTRUCTION");
        String en=sc.next();
        object.end=en;
    }

    @Override
    public void DisplayTender(contractor obj, Tender[] objects) {

        for(int i=0;i<obj.nTenders;i++){      
                System.out.println("-------------------THE DETAILS OF THE PROJECS -----------------\n ");
                System.out.println("THE TYPE: ");
                System.out.println(objects[i].constructionType);
                System.out.println("THE BUDGET OF THE PROJECT: ");
                System.out.println(objects[i].budget);
                System.out.println("THE PLACE OF THE PROJECT: ");
                System.out.println(objects[i].place);
                System.out.println("THE START DATE OF THE PROJECT: ");
                System.out.println(objects[i].start);
                System.out.println("THE END DATE OF THE PROJECT: ");
                System.out.println(objects[i].end);
                System.out.println("THE APPROVAL STATE OF THE PROJECT: ");
                System.out.println(objects[i].approved);
        }
    }

    @Override
    public void getAuth(Tender[] objects, int tenderNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    void getContractorDetails(contractor object){
                System.out.println("THE PLACE OF THE CONTRACTOR: ");
                System.out.println(object.City);
                System.out.println("THE NAME OF THE CONTRACTOR: ");
                System.out.println(object.name);
                System.out.println("TO CONTACT: ");
                System.out.println(object.phno);
        
    }
}

class PWD extends Tender implements tender1{


    @Override
    public void DisplayTender(contractor obj, Tender[] objects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getTenderDetails(contractor obj, Tender object, int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getAuth(Tender[] objects, int tenderNumber) {
        objects[tenderNumber].approved="APPROVED";
    }
}

public class StoreTenderDetails {
    public static void main(String[]args){      
        int stopKey=0;
        int n=0;
        int tenderN=0;
        contractor[] objects=new contractor[1000];
        Tender[] obj=new Tender[1000];
        while(stopKey==0){
            System.out.println("Number of contractors: "+n+"Number of Tenders: "+tenderN);
            System.out.println("------WELCOME TO THE PUBLIC WORK DEPARTMENT SECTION--------\n CHOOSE ACTION"
                    + "\n 1. Add Contractor"
                    + "\n 2. Add Tender"
                    + "\n 3. View Tender"
                    + "\n 4. View Contractors"
                    + "\n 5. Exit");
            Scanner sc=new Scanner(System.in);
            int Choice=sc.nextInt();
            if(Choice==1){//working
                System.out.println("Enter the name for lookup");
                String name=sc.next();
                if(n!=0){
                    objects[n]=new contractor();
                    try{
                    Boolean a=false;
                        for(int i=0;i<n;i++){
                            a=(objects[i].name).equalsIgnoreCase(name);
                        }
                        if(a==true){
                           throw new MyException("CONTRACTOR NAME NOT ACCEPTED RETRY AGAIN");
                        }else{
                           objects[n].getDetails(name);
                           n=n+1;
                           continue;
                        }
                    
                    }catch(Exception e){
                        System.out.println("Caught error!!! ...");
                        System.out.println(e);
                        continue;
                    }
                }else{
//                    objects[n] subobj=new ;
                    objects[n]=new contractor();
                    objects[n].getDetails(name);
                    n=n+1;
                }
            }else if(Choice==2){//working
                String name;
                System.out.println("Enter the Contractor name:");
                name=sc.next();
                Boolean a=false;
                int i;
                for( i=0;i<n;i++){
                    a=(objects[i].name).equalsIgnoreCase(name);
                    if(a==true){
                        break;
                    }
                }    
                    if(a==true){
                       obj[tenderN]=new Tender();
                       System.out.println("YOU'LL BE ADDING DETAILS FOR TENDER NUMBER:"+ tenderN);
                       objects[i].getTenderDetails(objects[i], obj[tenderN], tenderN);
                       PWD objectPWD=new PWD();
                       objectPWD.getAuth(obj, tenderN);
                       tenderN+=1;
                    }else{
                       System.out.println("Contractor Not found. First Create this Contractor and then enter the "
                                + "Tender details");
                       continue;
                    }
                
            }else if(Choice==3){
                String name;
                System.out.println("Enter the Contractor name:");
                name=sc.next();
                for(int i=0;i<n;i++){
                    Boolean a=name.equalsIgnoreCase(objects[i].name);
                    if(a==true){
                        objects[i].DisplayTender(objects[i], obj);
                    }
                }
            }else if(Choice==4){//working
                System.out.println("Input the name");
                String name=sc.next();
                for(int i=0;i<n;i++){
                    Boolean a=name.equalsIgnoreCase(objects[i].name);
                    if(a==true){
                        objects[i].getContractorDetails(objects[i]);                        
                    }
                }
            }else{//working
                System.out.println("----THANK YOU---");
                stopKey=1;
            }
        }
    }
}
