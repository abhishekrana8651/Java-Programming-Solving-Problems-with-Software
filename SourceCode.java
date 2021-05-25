/**
 * Write a description of finalproject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class finalproject {
    
    public void babybirth(){
        int totalbirth = 0;
        int totalboybirth= 0;
        int totalgirlbirth = 0;
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord record : parser)
        {
           int birth = Integer.parseInt(record.get(2));
           totalbirth = totalbirth + birth;
           if(record.get(1).equals("M"))
           {
              int boybirth = Integer.parseInt(record.get(2));
              totalboybirth = totalboybirth + boybirth;
            
            }
            else
            {
                 int girlbirth = Integer.parseInt(record.get(2));
                 totalgirlbirth = totalgirlbirth + girlbirth;
            
            
            }
        
        }     System.out.println("total birth of the boys and the girl is " + totalbirth);
          System.out.println("total boy birth is " + totalboybirth);
          System.out.println("tota girl birth is  " + totalgirlbirth);
    
    }
    public int getRank(int year, String name, String gender) {
        
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        int rank = 0;
        int number = 0;
        for (CSVRecord record : parser) {
            if (record.get(1).equals(gender)) {
                rank = rank + 1;
                if (record.get(0).equals(name)) {
                    number = 1;
                    break;
                }
            }
        }
        if (number == 1) return rank;
        else return -1;
    }
    
    public void testgetRank() {
        int rank = getRank(2012, "Mason", "M");
        System.out.println(rank);
    }
    
    
    public String getName(int year, int rank, String gender)
    {
        int n = 0;
        String name = null;
      FileResource fr = new FileResource();
      CSVParser parser = fr.getCSVParser(false);
      for(CSVRecord record : parser)
      {
        if(record.get(1).equals(gender))
        {
            
            n = n + 1;
            
            if (rank == n)
             {
                
               
                name = record.get(0);
                break;
                
                }
        }
        
        }  if(rank == n)
        {
           return name;
          
        
        }
        
        else 
        {
           return "NO NAME";
        }
    
    
    
    }
    
    public void testgetName()
    {
       String name = getName(2014, 4, "F");
       System.out.println(name);
    }
    
    
   public void whatnameisyear(String name, int year, int newyear , String gender)
   {  int a = 0;
       int n = 0;
       String name1 = null;
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
         
        FileResource frnew = new FileResource();
        CSVParser parsernew = frnew.getCSVParser(false);
        
        for(CSVRecord record : parser)
        {  if(record.get(1).equals(gender))
             a =a +1;
             if(record.get(0).equals(name))
             {
                break;
                }
        
        }
        
        for(CSVRecord recordnew : parsernew)
        {
             if(recordnew.get(1).equals(gender))
             
        {
        
            n = n + 1;
            
            
        }
        
        if( n == a)
        {
            name1 = recordnew.get(0);
            break;
        }
        }
        System.out.println(name);
        System.out.println(" born in " + year);
        System.out.println(" would be " + name1);
        System.out.println(" in year "  + newyear); 
       
    }
   public void testwhatnameisyear()
   {
      whatnameisyear("Isabella", 2014 , 2013 ,"F"); 
    
    
    
    }

    
    
    
    
    public String yearOfHighestRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        int newrank = 0;
        int rank = 0;
        int find = 0;
        String name1 = null;
        String newname = null;
        
        
        for (File f: dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            CSVParser parser= fr.getCSVParser(false);
            for(CSVRecord record: parser)
            {
               if(record.get(1).equals(gender))
               {   rank = rank + 1;
                }
                   if(record.get(0).equals(name))
                   {
                         find = 1;
                         name1 = f.getName();
                         break;
                    
                    }
            
            }
           
    
    
    
         
    
    if(find ==1)
    {
       if(newrank == 0)
       {
           newrank =rank;
           newname = name1;
        }
    
    
    if(newrank > rank)
    {   newname = name1;
    }    
     
rank = 0; // very impoertant to intialize the value of rank to zero f the iteration of loop is start again
        
}

}

if( find == 0)
{
     return "-1";
}
 if (find == 1)
{ return newname.substring(3,7);}  
 
 return "-1";
}        
        
        

    public void testyearOfHighestRank() {
        String ranktonow = yearOfHighestRank("Mason", "M");
        System.out.println("Highest year is "+ ranktonow);
    }


     public double getaverageofrank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        int newrank = 0;
        int rank = 0;
        int find = 0;
       int n = 0;
 
        
        
        for (File f: dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            CSVParser parser= fr.getCSVParser(false);
            for(CSVRecord record: parser)
            {
               if(record.get(1).equals(gender))
               {   rank = rank + 1;
                }
                   if(record.get(0).equals(name))
                   {
                         find = 1;
                         
                         break;
                    
                    }
            
            }
           
    
    
    
         
    
    if(find ==1)
    {
       if(newrank == 0)
       {
           newrank =rank;
           
        }
    
    
    if(newrank > rank  || newrank < rank)
    {   newrank = newrank + rank;
    }    
 n = n + 1;    
rank = 0; // very impoertant to intialize the value of rank to zero f the iteration of loop is start again
        
}

}

if( find == 0)
{
     return -1;
}
 if (find == 1)
{ double average = (newrank + rank)/n ;
    return average; }  
 
 return -1;
}        
    
  public void testgetaverageofrank()
  {
    System.out.println(getaverageofrank("Mason", "M"));
    
    }
    
  
    public int getTotalBirthsRankedHigher(int year, String name, String gender) 
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        int find = 0;
        int sum = 0;
        for (CSVRecord record: parser) {
            if (record.get(1).equals(gender))
            
            {
                
               sum += Integer.parseInt(record.get(2));
                 
                if (record.get(0).equals(name))
                {
                    find = 1;
                    break;
                }
               
            }
        }
        if (find == 1)
        {return sum;}
        else 
       { return -1;  }
    }
    
    public void testgetTotalBirthsRankedHigher() {
        int sum = getTotalBirthsRankedHigher(2012, "Ethan", "M");
        System.out.println("The total briths higher is "+sum);
    }
    
    
}

    
    
   
