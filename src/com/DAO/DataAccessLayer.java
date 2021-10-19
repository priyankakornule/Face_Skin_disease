package com.DAO;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.math3.util.NumberTransformer;

import com.model.DietPlan;
import com.model.Food;
import com.model.HealthForm;
import com.model.ImageModel;
import com.model.Nutrientinfo;
import com.model.Quantity;
import com.model.Register;
import com.model.Appoinment;;






public class DataAccessLayer {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/skin_disease?autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASS = "root";

	public static Connection makeConnection() {
		Connection con = null;
		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(DB_URL, USER, PASS);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}
	

	public static int getInsertRegistration(Register register) {
		//uid, fname, lname, contact, email, pass
	   Connection con=makeConnection();
	   int i=0;
	   PreparedStatement pstm=null;
	   String sql="insert into register(fname,lname,contact,email,pass) values (?,?,?,?,?)";
	   try {
		pstm=con.prepareStatement(sql);
		pstm.setString(1, register.getFname());
		pstm.setString(2, register.getLname());
		pstm.setString(3, register.getContact());
		pstm.setString(4, register.getEmail());
		pstm.setString(5, register.getPass());
		
		i=pstm.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   return i;
	}


	public static int getCheckEmail(String email, String pass) {
		Register reg=new Register();
		Connection con=makeConnection();
		int i=0;
		String sql="select * from register where email='" +email+ "' and pass='" +pass+ "'";
	    try {
	    	ResultSet rs=con.createStatement().executeQuery(sql);
			while(rs.next()){
				reg.setEmail(rs.getString("email"));
				reg.setPass(rs.getString("pass"));
				reg.setUid(rs.getInt("uid"));
				i=rs.getInt("uid");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		return i;
	}


	public static Register getEmail(Register register) {
		Register reg=new Register();
		Connection con=makeConnection();
		String sql="select * from register where email='" +register.getEmail()+ "'";
		try {
			ResultSet rs=con.createStatement().executeQuery(sql);
			while(rs.next()){
				
				reg.setUid(rs.getInt("uid"));
				reg.setEmail(rs.getString("email"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reg;
	}


	public static int insertHealthForm(Register health) {
		int i=0;
		//hid, age, gender, height, cms, weight, activeness,uid
		 Connection con=makeConnection();
		   PreparedStatement pstm=null;
		   String sql="insert into register(age, gender, height, cms, weight, activeness,uid) values (?,?,?,?,?,?,?)";
		   try {
			pstm=con.prepareStatement(sql);
		     pstm.setInt(1, health.getAge());
		     pstm.setString(2, health.getGender());
		     pstm.setString(3, health.getHeight());
		     pstm.setDouble(4, health.getCms());
			 pstm.setDouble(5, health.getWeight());
			 pstm.setString(6, health.getActiveness());
			 pstm.setInt(7, health.getUid());
			 
			
		     
			i=pstm.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	
	public static Register getHealthFormInfo(int id)
	{
		Register health=new Register();
		Connection con=makeConnection();
		String sql="select * from register where uid=?";
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			pstm=con.prepareStatement(sql);
			pstm.setInt(1, id);
			rs=pstm.executeQuery();
			while(rs.next())
			{
				//uid, fname, lname, contact, email, pass, age, gender, height, cms, weight, activeness, bmi, mean, calorie
				
				health.setFname(rs.getString("fname"));
				health.setLname(rs.getString("lname"));
				health.setContact(rs.getString("contact"));
				health.setEmail(rs.getString("email"));
				health.setPass(rs.getString("pass"));
				
				
				/*health.setAge(rs.getInt("age"));
				health.setGender(rs.getString("gender"));
				health.setHeight(rs.getString("height"));
				health.setCms(rs.getDouble("cms"));
				health.setWeight(rs.getDouble("weight"));
				health.setActiveness(rs.getString("activeness"));
				health.setBmi(rs.getFloat("bmi"));
				health.setMean(rs.getString("mean"));
				health.setCalorie(rs.getDouble("calorie"));*/
			}
			
			/*String gender=health.getGender();
			
			if(gender.equals("0"))
			{
				health.setGender("Male");
			}
			else
			{
				health.setGender("Female");	
			}	*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pstm!=null)
			{
				try {
					pstm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs!=null)
			{
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return health;
	}

/*	public static int getUpdatePass(String pass2) {
		int i=0;
		Register reg=new Register();
		Connection con=makeConnection();
		
		String sql="Update register set email where pass='" +pass2+ "'";
		try {
			ResultSet rs=con.createStatement().executeQuery(sql);
			
			while(rs.next()){
				
				reg.setUid(rs.getInt("uid"));
				reg.setEmail(rs.getString("email"));
				reg.setPass(rs.getString("pass"));
				i=rs.getInt("uid");
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}*/
	
	
	public static int getUpdatePass(Register reg,String pass) {
        int i=0;  
        try{  
            Connection con=makeConnection();
            PreparedStatement ps=con.prepareStatement(  
                         "update register set pass=? where email=?");  
           System.out.println("Update Query");
                        
            ps.setString(1, pass);
            ps.setString(2, reg.getEmail());
            System.out.println(reg.getEmail());
            
            i=ps.executeUpdate();  
             
            }catch(Exception ex){ex.printStackTrace();}  
          
        return i;  
    }



/*	public static void getHealthUpdate(HealthForm health,int hid) {
		//hid, age, gender, height, cms, weight, activeness, uid
		Statement st = null;
		Connection con=makeConnection();
		String query="Update register SET age='" + health.getAge() + "',gender='" + health.getGender() + "', height='" + health.getHeight() + "',cms='" +health.getCms()+ "',weight='" +health.getWeight()+ "',activeness='" +health.getActiveness()+ "' where hid=? ";
		try {
			st=con.createStatement();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("User Updated");
	}*/
	
	public static int getHealthUpdate(Register health,int uid) {
		int i=0;
		//hid, age, gender, height, cms, weight, activeness, uid
		System.out.println("dao uid"+uid);
	
		PreparedStatement st = null;
		Connection con=makeConnection();
		
		String query="Update register SET age='" + health.getAge() + "',gender='" + health.getGender() + "', height='" + health.getHeight() + "',cms='" +health.getCms()+ "',weight='" +health.getWeight()+ "',activeness='" +health.getActiveness()+ "' where uid="+uid;
		
		System.out.println("Update register SET age='" + health.getAge() + "',gender='" + health.getGender() + "', height='" + health.getHeight() + "',cms='" +health.getCms()+ "',weight='" +health.getWeight()+ "',activeness='" +health.getActiveness()+ "' where uid="+uid);
		try {
			st=con.prepareStatement(query);
		
		 i= st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("User Updated");
		return i;
	}

	public static Boolean AddUser(HealthForm health) {
		Boolean userRegistered = false;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		System.out.println("Successfully loaded driver");
		Connection con;
		try {
			con = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Successfully connetced");

			pstm = con.prepareStatement(
					"insert into register(age, gender, height, cms, weight, activeness,uid) values (?,?,?,?,?,?,?)");
			
			
			pstm.setString(1, health.getAge());
		     pstm.setString(2, health.getGender());
		     pstm.setString(3, health.getHeight());
		     pstm.setString(4, health.getCms());
			 pstm.setString(5, health.getWeight());
			 pstm.setString(6, health.getActiveness());
			 pstm.setInt(7, health.getUid());
			 

			int i = pstm.executeUpdate();

			System.out.println(i + "row inserted");
			System.out.println("Data Inserted c");
			userRegistered = true;

		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException ex) {

				}
			}
		}
		return userRegistered;

	}


	public static Boolean uploadImage(int userId, InputStream is) {
	
		boolean flag=false;
		Connection con=makeConnection();
		String sql= "insert into user_uploaded_images(user_id,image,prediction,date,time) "
				+ "values (?,?,?,curdate(),curtime())";
		System.out.println(sql);
		
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setInt(1,userId);
			pstm.setBlob(2, is);
			pstm.setString(3, "TEST");
			
			int i=pstm.executeUpdate();
			if(i==1){
				flag=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return flag;
	}


	private static char[] setBlob(int i, InputStream is) {
		// TODO Auto-generated method stub
		return null;
	}


	/*public static void getHealthUpdate(HealthForm health, int uid) {
		Statement st = null;
		Connection con=makeConnection();
		String query="Update register SET age='" + health.getAge() + "',gender='" + health.getGender() + "', height='" + health.getHeight() + "',cms='" +health.getCms()+ "',weight='" +health.getWeight()+ "',activeness='" +health.getActiveness()+ "' where uid=?";
		try {
			st=con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("User Updated");
		
	}
*/

	public static boolean uploadGrayImage(int iid,BufferedImage grayImage) throws IOException
	{
		boolean flag=false;
		Connection con= makeConnection();
		String sql= "insert into user_uploaded_images(file_id,GrayImage) "
				+ "values (?,?))";
		System.out.println(sql);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(grayImage, "jpg", baos);
		InputStream is = new ByteArrayInputStream(baos.toByteArray());
		try {
			PreparedStatement pstm= con.prepareStatement(sql);
			pstm.setInt(1, iid);
			System.out.println("Image id in DAL: "+iid);
			pstm.setBlob(2, is);
			int i=pstm.executeUpdate();
			if(i==1)
			{
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return flag;
	}

	
	public static int getImgId()
	{

		System.out.println("getImgId()");
		String sql = "select file_id from user_uploaded_images order by file_id desc limit 0,1 " ;
		System.out.println(sql);
		Connection con = makeConnection();
		ResultSet rs = null;
		PreparedStatement pstm=null;
		ImageModel d=null;
		int id=0;

		try {
			System.out.println("In try of getImgId");


			pstm = con.prepareStatement(sql);
			//pstm.setInt(1,id);
			rs = pstm.executeQuery();

			d=new ImageModel();


			while(rs.next())
			{
				System.out.println("In rs.next()");

				id=rs.getInt("file_id");
				d.setId(rs.getInt("file_id"));
				System.out.println(rs.getInt("file_id"));


			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return id;



	}
	//Code to fetch gray image
	public static BufferedImage fetchGrayImages(int iid) throws IOException {

		BufferedImage grayBuffer ;
		BufferedImage buffer =null;
		Connection con = makeConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		//Image im=new Image();
		String sql = "select * from user_uploaded_images where file_id=?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, iid);
			rs = pstm.executeQuery();
			while (rs.next()) {
				/*byte[] bytearray = new byte[1048576];
				int size = 0;
				//im=new Image();

				InputStream images= rs.getBinaryStream("image");
				buffer=ImageIO.read(images);*/
				InputStream images= rs.getBinaryStream("image");
				System.out.println("images"+images);
				buffer=ImageIO.read(images);


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		/*	System.out.println(buffer);*/



		//grayBuffer=ProcessImage.convertToGrayScale(buffer);

		return buffer;

	}

	
	
	public static String fetchGrayImages2(int iid) throws IOException {

		String name="";
		Connection con = makeConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		//Image im=new Image();
		String sql = "select * from user_uploaded_images where file_id=?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, iid);
			rs = pstm.executeQuery();
			while (rs.next()) {
				/*byte[] bytearray = new byte[1048576];
				int size = 0;
				//im=new Image();

				InputStream images= rs.getBinaryStream("image");
				buffer=ImageIO.read(images);*/
				 name= rs.getString("prediction");
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		/*	System.out.println(buffer);*/



		//grayBuffer=ProcessImage.convertToGrayScale(buffer);

		return name;

	}

	public static int insertBmi(Register reg, int uid, double result) {
		
		int i=0;
		//uid, fname, lname, contact, email, pass, age, gender, height, cms, weight, activeness, bmi, mean, calorie
		System.out.println("dao uid"+uid);
	    System.out.println("Dao result : "+result);
		PreparedStatement st = null;
		Connection con=makeConnection();
		
		String query="Update register SET bmi='"+reg.getBmi()+"', mean='"+reg.getMean()+"', calorie='"+result+"' where uid="+uid;
		System.out.println("query"+query);
		try {
			st=con.prepareStatement(query);
		
		 i= st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("User Updated");
		
		return i;
		
	}

	public static com.model.Food foodmutiply(String foodname, int count) {
	    Connection con=makeConnection();
			
		com.model.Food fd=new com.model.Food();
			
		
			String sql="select sum(energy) as total_energy, sum(Calcium) as total_calcium, sum(protein) as total_protein,"
					+ " sum(calories) as total_calories ,sum(fat) as total_fat ,sum(fiber) as "
					+ "total_fiber ,sum(sugar) as total_sugar ,sum(vitaminA) as  total_vitaminA ,"
					+ "sum(vitaminC) as total_vitaminC, "
					+"sum(iron) as total_iron"
					+ " from nutrientinfo where"
					+ " name in ('"+foodname+"') ";
			
			System.out.println(sql);
			PreparedStatement pstm;
			try {
				pstm = con.prepareStatement(sql);

				ResultSet rs=pstm.executeQuery();
				while(rs.next()){
					fd.setEnergy(rs.getInt("total_energy") * count);
					fd.setCalcium(rs.getFloat("total_calcium") * count );
					System.out.println("calcium "+fd.getCalcium()  * count);
					fd.setProtein(rs.getFloat("total_protein") * count);
					fd.setCalories(rs.getInt("total_calories") * count);
					fd.setFat(rs.getFloat("total_fat") * count);
					fd.setFat(rs.getFloat("total_fiber") * count);
					fd.setSugar(rs.getFloat("total_sugar") * count);
					fd.setVitaminA(rs.getInt("total_vitaminA") * count);
					fd.setVitaminC(rs.getInt("total_vitaminC") * count);
					fd.setIron(rs.getInt("total_iron") * count);
					
				}
			
		}catch (SQLException e) {
			
		    e.printStackTrace();
	        }
			return fd;
	       
	        }

	/*public static Nutrientinfo getNutrientInfo(String foodname) {
		 Connection con=makeConnection();
			
			Nutrientinfo nu=new Nutrientinfo();
				
			//id1, name, energy, protein, sugar, fat, fiber, Calcium, Calories, vitaminA, vitaminC, iron, description, foodname
				String sql="select * from nutrientinfo where foodname="+foodname;
				
				System.out.println(sql);
			
				PreparedStatement statement;
			  
				
				
				try {
					statement = con.prepareStatement(sql);
					//statement.setString(1, foodname);    
					ResultSet rs = statement.executeQuery();
					
					while(rs.next()){
						nu.setEnergy(rs.getInt("energy"));
						nu.setCalcium(rs.getFloat("Calcium"));
						System.out.println("Calcium "+nu.getCalcium());
						nu.setProtein(rs.getFloat("protein"));
						nu.setCalories(rs.getInt("Calories"));
						nu.setFat(rs.getFloat("fat"));
						nu.setFat(rs.getFloat("fiber"));
						nu.setSugar(rs.getFloat("sugar"));
						nu.setVitaminA(rs.getInt("vitaminA"));
						nu.setVitaminC(rs.getInt("vitaminC"));
						nu.setIron(rs.getInt("iron"));
						
					}
				
			    }catch (SQLException e) {
				
			    e.printStackTrace();
		        }
				return nu;
		        
		
	}
		
*/		
	
	
	
	public static Nutrientinfo getNutrientInfo(String foodname) {
		 Connection con=makeConnection();
			int i=0;
			Nutrientinfo nu=new Nutrientinfo();
				//id1, name, Calories, foodname
				String sql="select * from nutrientinfo where name=?";
				
				System.out.println(sql);
			
				PreparedStatement statement=null;
			  
				
				try {
					statement = con.prepareStatement(sql);
					statement.setString(1, foodname);    
					ResultSet rs = statement.executeQuery();
					
					while(rs.next()){
						
						nu.setCalories(rs.getInt("Calories"));
						System.out.println(rs.getInt("Calories"));
						
						
					}
				
			    }catch (SQLException e) {
				
			    e.printStackTrace();
		        }
				return nu;
	}
	
	
	
public static void main(String[] args) {
	//getNutrientInfo("POHA");
	getInfo(1);
	requestAccept();
}	

public static List<Food> morningfood(int morning1, int morning2) {
		
		Connection con=makeConnection();
		java.util.List<Food> morninglist=new ArrayList<Food>();
		
		String sql="select * from dietchart where calories between "+morning1+" and "+morning2+" and diet='veg' and foodtype='morning'" ;
		System.out.println("sql is --> "+sql);
		PreparedStatement pstm;
		try {
			pstm = con.prepareStatement(sql);
			
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				Food mfood= new Food();
				mfood.setFoodname(rs.getString("foodname"));
				mfood.setUnit(rs.getString("unit"));
				System.out.println("morning--->"+rs.getString("unit"));
				mfood.setCalories(rs.getInt("calories"));
				mfood.setFoodtype(rs.getString("foodtype"));
				mfood.setDiet(rs.getString("diet"));
				morninglist.add(mfood);
				  }
		        } catch (SQLException e) {
			
			    e.printStackTrace();
		        }
		return morninglist;
	}

	public static java.util.List<Food> fruitsneed(int fruits1, int fruits2) {
		
		Connection con=makeConnection();
		java.util.List<Food> fruitlist=new ArrayList<Food>();
		
		String sql="select * from dietchart where calories between "+fruits1+" and "+fruits2+" and diet='veg' and foodtype='fruits'" ;
		System.out.println("sql is --> "+sql);
		PreparedStatement pstm;
		try {
			pstm = con.prepareStatement(sql);
			
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				Food mfood= new Food();
				mfood.setFoodname(rs.getString("foodname"));
				mfood.setUnit(rs.getString("unit"));
				mfood.setCalories(rs.getInt("calories"));
				mfood.setFoodtype(rs.getString("foodtype"));
				mfood.setDiet(rs.getString("diet"));
				fruitlist.add(mfood);
				  }
		        } catch (SQLException e) {
			
			    e.printStackTrace();
		        }
		return fruitlist;
	}

	public static java.util.List<Food> breakfast(int breakfast2, int breakfast1) {
		
		
		Connection con=makeConnection();
		java.util.List<Food> breakfastlist=new ArrayList<Food>();
		
		String sql="select * from dietchart where calories between "+breakfast2+" and "+breakfast1+" and foodtype='breakfast'" ;
		System.out.println("sql is --> "+sql);
		PreparedStatement pstm;
		try {
			pstm = con.prepareStatement(sql);
			
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				Food mfood= new Food();
				mfood.setFoodname(rs.getString("foodname"));
				mfood.setUnit(rs.getString("unit"));
				mfood.setCalories(rs.getInt("calories"));
				mfood.setFoodtype(rs.getString("foodtype"));
				mfood.setDiet(rs.getString("diet"));
				breakfastlist.add(mfood);
				  }
		        } catch (SQLException e) {
			
			    e.printStackTrace();
		        }
		return breakfastlist;
	}

	public static java.util.List<Food> lunchitem(int lunchitem1, int lunchitem2) {
		// TODO Auto-generated method stub
		Connection con=makeConnection();
		java.util.List<Food> lunchlist=new ArrayList<Food>();
		
		String sql="select * from dietchart where calories between "+lunchitem1+" and "+lunchitem2+" and foodtype='lunch'" ;
		System.out.println("sql is --> "+sql);
		PreparedStatement pstm;
		try {
			pstm = con.prepareStatement(sql);
			
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				Food mfood= new Food();
				mfood.setFoodname(rs.getString("foodname"));
				mfood.setUnit(rs.getString("unit"));
				mfood.setCalories(rs.getInt("calories"));
				mfood.setFoodtype(rs.getString("foodtype"));
				mfood.setDiet(rs.getString("diet"));
				lunchlist.add(mfood);
				  }
		        } catch (SQLException e) {
			
			    e.printStackTrace();
		        }
		return lunchlist;
	}

	public static java.util.List<Food> dinnerdiet(int dinner1, int dinner2) {
		// TODO Auto-generated method stub
		Connection con=makeConnection();
		java.util.List<Food> lunchlist=new ArrayList<Food>();
		
		String sql="select * from dietchart where calories between "+dinner1+" and "+dinner2+" and foodtype='dinner'" ;
		System.out.println("sql is --> "+sql);
		PreparedStatement pstm;
		try {
			pstm = con.prepareStatement(sql);
			
			ResultSet rs=pstm.executeQuery();
			while(rs.next()){
				Food mfood= new Food();
				mfood.setFoodname(rs.getString("foodname"));
				mfood.setUnit(rs.getString("unit"));
				mfood.setCalories(rs.getInt("calories"));
				mfood.setFoodtype(rs.getString("foodtype"));
				mfood.setDiet(rs.getString("diet"));
				lunchlist.add(mfood);
				  }
		        } catch (SQLException e) {
			
			    e.printStackTrace();
		        }
		return lunchlist;
	}




public static List<DietPlan> getDietplan1(int age) {
    int i=0;
    Connection con=makeConnection();
	List<DietPlan> dt=new ArrayList<>();
	String sql="select * from dietplan where age=20" ;
	System.out.println("sql is --> "+sql);
	PreparedStatement pstm;
	try {
		pstm = con.prepareStatement(sql);
		
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			//DietId, EarlyMorning, Breakfast, PreLunch, Lunch, EveningSancks, Dinner, BeforeBed, age
			DietPlan diet=new DietPlan();
			diet.setEarlyMorning(rs.getString("EarlyMorning"));
			diet.setBreakfast(rs.getString("Breakfast"));
			diet.setPreLunch(rs.getString("PreLunch"));
			diet.setLunch(rs.getString("Lunch"));
			diet.setEveningSancks(rs.getString("EveningSancks"));
			diet.setDinner(rs.getString("Dinner"));
			diet.setBeforeBed(rs.getString("BeforeBed"));
			dt.add(diet);
			  }
	        } catch (SQLException e) {
		
		    e.printStackTrace();
	        }
	return dt;
}
public static List<DietPlan> getDietplan2(int age) {
    int i=0;
    Connection con=makeConnection();
	List<DietPlan> dt=new ArrayList<>();
	String sql="select * from dietplan where age=30" ;
	System.out.println("sql is --> "+sql);
	PreparedStatement pstm;
	try {
		pstm = con.prepareStatement(sql);
		
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			//DietId, EarlyMorning, Breakfast, PreLunch, Lunch, EveningSancks, Dinner, BeforeBed, age
			DietPlan diet=new DietPlan();
			diet.setEarlyMorning(rs.getString("EarlyMorning"));
			diet.setBreakfast(rs.getString("Breakfast"));
			diet.setPreLunch(rs.getString("PreLunch"));
			diet.setLunch(rs.getString("Lunch"));
			diet.setEveningSancks(rs.getString("EveningSancks"));
			diet.setDinner(rs.getString("Dinner"));
			diet.setBeforeBed(rs.getString("BeforeBed"));
			dt.add(diet);
			  }
	        } catch (SQLException e) {
		
		    e.printStackTrace();
	        }
	return dt;
}	

public static List<DietPlan> getDietplan3(int age) {
    int i=0;
    Connection con=makeConnection();
	List<DietPlan> dt=new ArrayList<>();
	String sql="select * from dietplan where age=40" ;
	System.out.println("sql is --> "+sql);
	PreparedStatement pstm;
	try {
		pstm = con.prepareStatement(sql);
		
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			//DietId, EarlyMorning, Breakfast, PreLunch, Lunch, EveningSancks, Dinner, BeforeBed, age
			DietPlan diet=new DietPlan();
			diet.setEarlyMorning(rs.getString("EarlyMorning"));
			diet.setBreakfast(rs.getString("Breakfast"));
			diet.setPreLunch(rs.getString("PreLunch"));
			diet.setLunch(rs.getString("Lunch"));
			diet.setEveningSancks(rs.getString("EveningSancks"));
			diet.setDinner(rs.getString("Dinner"));
			diet.setBeforeBed(rs.getString("BeforeBed"));
			dt.add(diet);
			  }
	        } catch (SQLException e) {
		
		    e.printStackTrace();
	        }
	return dt;
}	

public static List<DietPlan> getDietplan4(int age) {
    int i=0;
    Connection con=makeConnection();
	List<DietPlan> dt=new ArrayList<>();
	String sql="select * from dietplan where age=50" ;
	System.out.println("sql is --> "+sql);
	PreparedStatement pstm;
	try {
		pstm = con.prepareStatement(sql);
		
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			//DietId, EarlyMorning, Breakfast, PreLunch, Lunch, EveningSancks, Dinner, BeforeBed, age
			DietPlan diet=new DietPlan();
			diet.setEarlyMorning(rs.getString("EarlyMorning"));
			diet.setBreakfast(rs.getString("Breakfast"));
			diet.setPreLunch(rs.getString("PreLunch"));
			diet.setLunch(rs.getString("Lunch"));
			diet.setEveningSancks(rs.getString("EveningSancks"));
			diet.setDinner(rs.getString("Dinner"));
			diet.setBeforeBed(rs.getString("BeforeBed"));
			dt.add(diet);
			  }
	        } catch (SQLException e) {
		
		    e.printStackTrace();
	        }
	return dt;
}	
public static List<DietPlan> getDietplan5(int age) {
    int i=0;
    Connection con=makeConnection();
	List<DietPlan> dt=new ArrayList<>();
	String sql="select * from dietplan where age=60" ;
	System.out.println("sql is --> "+sql);
	PreparedStatement pstm;
	try {
		pstm = con.prepareStatement(sql);
		
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			//DietId, EarlyMorning, Breakfast, PreLunch, Lunch, EveningSancks, Dinner, BeforeBed, age
			DietPlan diet=new DietPlan();
			diet.setEarlyMorning(rs.getString("EarlyMorning"));
			diet.setBreakfast(rs.getString("Breakfast"));
			diet.setPreLunch(rs.getString("PreLunch"));
			diet.setLunch(rs.getString("Lunch"));
			diet.setEveningSancks(rs.getString("EveningSancks"));
			diet.setDinner(rs.getString("Dinner"));
			diet.setBeforeBed(rs.getString("BeforeBed"));
			dt.add(diet);
			  }
	        } catch (SQLException e) {
		
		    e.printStackTrace();
	        }
	return dt;
}	
public static List<DietPlan> getDietplan6(int age) {
    int i=0;
    Connection con=makeConnection();
	List<DietPlan> dt=new ArrayList<>();
	String sql="select * from dietplan where age=70" ;
	System.out.println("sql is --> "+sql);
	PreparedStatement pstm;
	try {
		pstm = con.prepareStatement(sql);
		
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			//DietId, EarlyMorning, Breakfast, PreLunch, Lunch, EveningSancks, Dinner, BeforeBed, age
			DietPlan diet=new DietPlan();
			diet.setEarlyMorning(rs.getString("EarlyMorning"));
			diet.setBreakfast(rs.getString("Breakfast"));
			diet.setPreLunch(rs.getString("PreLunch"));
			diet.setLunch(rs.getString("Lunch"));
			diet.setEveningSancks(rs.getString("EveningSancks"));
			diet.setDinner(rs.getString("Dinner"));
			diet.setBeforeBed(rs.getString("BeforeBed"));
			dt.add(diet);
			  }
	        } catch (SQLException e) {
		
		    e.printStackTrace();
	        }
	return dt;
}	
public static List<DietPlan> getDietplan7(int age) {
    int i=0;
    Connection con=makeConnection();
	List<DietPlan> dt=new ArrayList<>();
	String sql="select * from dietplan where age=80" ;
	System.out.println("sql is --> "+sql);
	PreparedStatement pstm;
	try {
		pstm = con.prepareStatement(sql);
		
		ResultSet rs=pstm.executeQuery();
		while(rs.next()){
			//DietId, EarlyMorning, Breakfast, PreLunch, Lunch, EveningSancks, Dinner, BeforeBed, age
			DietPlan diet=new DietPlan();
			diet.setEarlyMorning(rs.getString("EarlyMorning"));
			diet.setBreakfast(rs.getString("Breakfast"));
			diet.setPreLunch(rs.getString("PreLunch"));
			diet.setLunch(rs.getString("Lunch"));
			diet.setEveningSancks(rs.getString("EveningSancks"));
			diet.setDinner(rs.getString("Dinner"));
			diet.setBeforeBed(rs.getString("BeforeBed"));
			dt.add(diet);
			  }
	        } catch (SQLException e) {
		
		    e.printStackTrace();
	        }
	return dt;
}	

public static List<ImageModel> getWholeDayCalorie(int uid, String startTime) {
	Connection con=makeConnection();
	List<ImageModel> n=new ArrayList<>();
	PreparedStatement pstm = null;
	ResultSet rs = null;
	//file_id, user_id, image, prediction, date, time, quantity
	String sql="select * from user_uploaded_images where user_id="+uid+" and date='"+startTime+"'";
	System.out.println(sql);
	try {
		pstm = con.prepareStatement(sql);
		rs = pstm.executeQuery();
		while (rs.next()) {
		//file_id, user_id, image, prediction, date, time, quantity
			ImageModel nu=new ImageModel();
			
			String othr=rs.getString("prediction");
			nu.setPrediction(rs.getString("prediction"));
			nu.setQuantity(rs.getInt("quantity"));
			if(othr.equals(" OTHER ")){
				System.out.println("Other");
				continue;
			}
			else{
				System.out.println("nU");
			    n.add(nu);
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	System.out.println("n=====>"+n.toString());
	System.out.println("n=====>"+n.size());
	return n;

	
}


public static int getWholeActualCalorie(List<String> food) {
	int calarie=0;
	
	Connection con = makeConnection();
	Statement pstm = null;
	//ResultSet rs = null;
	List<Nutrientinfo> nu=new ArrayList<>();
	System.out.println("Fd ===>"+food);
	for(String s:food){
		//id1, name, Calories, foodname
	String sql = "select Calories from nutrientinfo where foodname='"+s+"'";
		System.out.println(sql);
	
	try {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			System.out.println("While loop");
		
			int cal=rs.getInt("Calories");
			calarie=calarie+cal;
			
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	System.out.println("Cal=="+calarie);
	return calarie;
	
}


public static int getWholeActualCalorie1(List<String> food) {
	int cal=0;
	
	Connection con = makeConnection();
	Statement pstm = null;
	//ResultSet rs = null;
	List<Nutrientinfo> nu=new ArrayList<>();
	System.out.println("Fd ===>"+food);
	for(String s:food){
		//id1, name, Calories, foodname
	String sql = "select Calories from nutrientinfo where foodname='"+s+"'";
		System.out.println(sql);
	
	try {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			System.out.println("While loop");
			
			cal=rs.getInt("Calories");
		
			System.out.println("Cal====>"+cal);
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

	return cal;
	
}


public static int getInsertQuantity(ImageModel qu) {
	
		int i=0;
		
		//System.out.println("dao uid"+food);
	
		PreparedStatement st = null;
		Connection con=makeConnection();
		//file_id, user_id, image, prediction, date, time, quantity
		String query="Update user_uploaded_images SET quantity='" + qu.getQuantity() + "'order by file_id desc limit 1";
		try {
			st=con.prepareStatement(query);
		
		 i= st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("User Updated");
		return i;
}

public static Register getInfo(int uid) {
	Register reg=new Register();
	Connection con=makeConnection();
	String sql="select * from register where uid=?";
	PreparedStatement pstm=null;
	ResultSet rs=null;
	try {
		pstm=con.prepareStatement(sql);
		pstm.setInt(1, uid);
		
		
		rs=pstm.executeQuery();
		while(rs.next())
		{
		//	uid, fname, lname, contact, email, pass, age, gender, height, cms, weight, activeness, bmi, mean, calorie
			reg.setFname(rs.getString("fname"));
			System.out.println("fname"+reg.getFname());
			reg.setLname(rs.getString("lname"));
			System.out.println("Lname"+reg.getLname());
			reg.setEmail(rs.getString("email"));
			System.out.println("email"+reg.getEmail());
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(pstm!=null)
		{
			try {
				pstm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	return reg;
	
	
}

public static int insertAppoinment(int uid, Register reg) {
	
	
	Connection con = makeConnection();
	
int i = 0;
	try {
	
		//aId, uid, fname, lname, dis, status
		String sql = "insert into appoinment(uid, fname, lname, dis, status) values(?,?,?,?,?)";
		
		System.out.println("After sql");
		PreparedStatement pstm = con.prepareStatement(sql);
		System.out.println("Prepared statement executed");
		
		System.out.println("Before getter");

		pstm.setInt(1, uid);
		pstm.setString(2, reg.getFname());
		pstm.setString(3, reg.getLname());
		pstm.setString(4, reg.getDis());
		pstm.setString(5, "Not Accepted");
		
		System.out.println("Get parameters");
		i = pstm.executeUpdate();
		System.out.println("After execute update");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}

public static List<Appoinment> requestAccept() {
	 
	List<Appoinment> ap=new ArrayList<>();
	String sql = "select * from appoinment";
	System.out.println(sql);
	Connection con = makeConnection();
	ResultSet rs = null;
	PreparedStatement pstm=null;
	
	int id=0;
	
	try {
		System.out.println("In try of prescription");
		
				
		pstm = con.prepareStatement(sql);
		//pstm.setInt(1,id);
		rs = pstm.executeQuery();
	
	
		
	while(rs.next())
		{
		Appoinment d=new Appoinment();
		
			System.out.println("In rs.next()");
			
			d.setDis(rs.getString("dis"));
			System.out.println("disss=="+d.getDis());
			d.setStatus(rs.getString("status"));
			d.setFname(rs.getString("fname"));
			d.setLname(rs.getString("lname"));
			ap.add(d);
			
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	return ap;
	
		

}
public static int insertFixtimeDate(Appoinment app, int uid) {

	Connection con = makeConnection();
	String  status="Accepted Request";
	int i = 0;
	
		System.out.println("dao uid"+uid);
	
		PreparedStatement st = null;
		//aId, uid, fname, lname, dis, status, date, time, place
		String query="Update appoinment SET fname='" + app.getFname() + "',lname='" + app.getLname() + "', dis='" + app.getDis() + "',status='" +status+ "',date='" +app.getDate()+ "',time='" +app.getTime()+ "',place='" +app.getPlace()+ "' where uid="+uid;
		
		try {
			st=con.prepareStatement(query);
		
		 i= st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("User Updated");
		return i;

	
}

}














