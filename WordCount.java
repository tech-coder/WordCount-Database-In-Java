import java.sql.*;		
import java.util.Scanner;
		import java.util.HashMap;
		import java.util.Map;
public class WordCount{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the String :");
		String line= sc.nextLine();
		String l_arr[]=line.toLowerCase().split(" ");
		System.out.println("Enter words  to count :");
		String words=sc.nextLine();
		String arr[]=words.toLowerCase().split(" ");
		Map<String,Integer> store=new HashMap<String,Integer>();
		for(int i=0;i<arr.length;i++)
		store.put(arr[i],0);
		//System.out.println(store);
		for(String l_word:l_arr){
		if(store.get(l_word)==null){
		continue;
		}else{
		int val=store.get(l_word);
		store.put(l_word,val+1);
		}

	}
		System.out.println(store);
		
		      try {
		    	 Connection con=ConnectionSql.getConnection();
				String query = " insert into assign values(?,?)";
			      PreparedStatement preparedStmt = con.prepareStatement(query);
			  
			      for ( String keyword : store.keySet() ) {
			    	  preparedStmt.setString(1,keyword);
			    	  preparedStmt.setInt(2,store.get(keyword));
			    	  preparedStmt.execute();
			    	}
				System.out.println("Stored the keywords in database successfully ...");
				  con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
		    
	}
}
