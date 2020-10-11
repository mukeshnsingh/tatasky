package com.sspl.master.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConsolidate 
{
	
	public static void main(String[] args) throws SQLException 
	{
		int uploadID=111;
		boolean x=aRConsolidate(uploadID);
		
		System.out.println("Consolidation Sucess True or False  :" +x);
		if(!x)
		{
			System.out.println("Consolidation failed Will delete all records");
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=bank;", "sa", "maxadmin");

			Statement statement = connection.createStatement();
			
			//Download all  error now
			
			//Download all GL failed for consolidate with upload id
			ResultSet errorGL = statement.executeQuery("select * from brs_glcorrect where mainstatus='ConsolidationFailed' and UploadID="+uploadID+"");
			ResultSetMetaData rsmd = errorGL.getMetaData();
			int countErrorGL = rsmd.getColumnCount();
			System.out.println(" Correct GL table Error records start");
			while(errorGL.next())
				{
					for(int i=1; i<countErrorGL; i++ )
					{
						System.out.print(errorGL.getString(i) + " | ");
					}
					System.out.println();
				}
			System.out.println("GL Error records ends");
			
			
			//Download all GL failed for consolidate with upload id completed
			
			//Download all AR failed for consolidate with upload id
			ResultSet errorAR = statement.executeQuery("select * from brs_arcorrect where mainstatus='ConsolidationFailed' and UploadID="+uploadID+"");
			ResultSetMetaData rsmd2 = errorAR.getMetaData();
			int countErrorAR = rsmd2.getColumnCount();
			System.out.println("AR Error Records starts");
			while(errorAR.next())
				{
					for(int i=1; i<countErrorAR; i++ )
					{
						System.out.print(errorAR.getString(i) + " | ");
					}
					
					System.out.println();
				}
			System.out.println("AR Error Records ends");
			
			
			//Download all GL failed for consolidate with upload id completed
			
			
			//delete correct GL
                        
			String deleteCorrectGL = "delete from brs_glcorrect where uploadid="+uploadID;
                        
			//delete correct AR
			
                        String deleteCorrectAR = "delete from brs_arcorrect where uploadid="+uploadID;
			//delete correct AP
			
                        String deleteCorrectAP= "delete from brs_apcorrect where uploadid="+uploadID;
			//update status in info table
                        
                        String updateInfoTable = "update brs_uploadinfo set ui_status='ConsolidationFailed' where ui_uploadid="+uploadID;
			
			statement.close();
			errorGL.close();
			connection.close();
		}
		
		else
		{
			System.out.println("In else all things are fine Lets go to check AP consolidation");
			//Also can update table upload info  //if ap is already done then code to copy data in shadow and Unreconcilled GL
			
                        String updateInfoTable = "update brs_uploadinfo set ui_status='ConsolidationSuccess' where ui_uploadid="+uploadID;
			//code to copy gl to unreconcilled gl for that upload id  MIS/AP/AR
			
					//INSERT INTO unreco_gl SELECT * FROM correctgl
			
			//Code to copy gl to shadow GL for that upload id
			
			//code to copy ar to ar shadow table for that upload id
			
			//code to copy ap to ap shadow for that upload id
			
			
			//delete success data now from correct table
			
				//delete from correct gl for that upload id 
			
				//delete from correct AP for that upload id
			
				//delete from correct AR for that upload id 
			
                        /*
                        //delete correct GL
                        
			String deleteCorrectGL = "delete from brs_glcorrect where uploadid="+uploadID;
                        
			//delete correct AR
			
                        String deleteCorrectAR = "delete from brs_arcorrect where uploadid="+uploadID;
			//delete correct AP
			
                        String deleteCorrectAP= "delete from brs_apcorrect where uploadid="+uploadID;
                        */
		}
		
		
		
	}

	public static boolean aRConsolidate(int uploId)
	{
		
		int uploadID= uploId;
		//System.out.println(">>>>>>>>>>>>>>>>>>>>"+uploadID);
		
		boolean successAR=true;
		try 
		{
                    
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=bank;", "sa", "maxadmin");

			Statement statement = connection.createStatement();
			
			String getGLTable ="select Account,JournalID,sum(Debit) Total from brs_glcorrect where Source='AR' and UploadID="+uploadID+" group by journalid,account";
			
                        connection.setAutoCommit(false);
			ResultSet rs = statement.executeQuery(getGLTable);	
			
			
			
			while (rs.next())
			{
				
				System.out.println("Lets check for this id :"+rs.getString("JournalID"));

				Statement statement2 = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

				
				String getARTable = "select  Item_Acc_Account, Item_Acc_JournalID, sum (Item_Act_ActivityAmount) TotalAR from brs_arcorrect where Item_Act_EntryType='PYMNT'  and Item_Acc_JournalID = '"+rs.getString("JournalID")+"' and Item_Acc_Account='"+rs.getString("Account")+"' and UploadID="+uploadID+" group by Item_Acc_JournalID,Item_Acc_Account";
				ResultSet rsARTable = statement2.executeQuery(getARTable);
				if(rsARTable.next())
				{
					if(rs.getFloat("Total") == rsARTable.getFloat("TotalAR"))
					{
						System.out.println("Amount match !!!!! ####  we have to change the rows :)");
						//@@ if amount match set status of GL and AR both All records to ConsolidateSuccess@@
						
						//--------GL Correct Update Start
						String s="UPDATE brs_glcorrect SET mainstatus='ConsolidationSuccess' WHERE journalid='"+rs.getString("JournalID")+"' and Account='"+rs.getString("account")+"' and source='AR' and UploadID="+uploadID+"";
						//System.out.println(s);
						PreparedStatement ps = connection.prepareStatement(s);
						ps.executeUpdate();
						
						//--------GL Correct Update End
						//--------AR Correct Update Start
						
						String s2="UPDATE brs_arcorrect SET mainstatus='ConsolidationSuccess' WHERE Item_Acc_JournalID='"+rs.getString("JournalID")+"' and Item_Acc_Account='"+rs.getString("account")+"' and Item_Act_EntryType='PYMNT' and UploadID="+uploadID+"";
						//System.out.println(s2);
						
						
						PreparedStatement ps2 = connection.prepareStatement(s2);
						ps2.executeUpdate();
						
						
						//--------AR Correct Update ends
						
						
					}
					
					else
					{
						System.out.println("Amount do not match !!!");
						String s="UPDATE brs_glcorrect SET mainstatus='ConsolidationFailed' WHERE journalid='"+rs.getString("JournalID")+"' and Account='"+rs.getString("account")+"' and source='AR' and UploadID="+uploadID+"";
						//System.out.println(s);
						PreparedStatement ps= connection.prepareStatement(s);
						ps.executeUpdate();
						successAR = false;
					}
				
				
				}
				
				else
				{
					System.out.println("No related data in AR we should set status failded for this or not match");
					String s="UPDATE brs_glcorrect SET mainstatus='ConsolidationFailed' WHERE journalid='"+rs.getString("JournalID")+"' and Account='"+rs.getString("account")+"' and source='AR' and UploadID="+uploadID+"";
					//System.out.println(s);
					PreparedStatement ps= connection.prepareStatement(s);
					ps.executeUpdate();
					successAR = false;
				}

			
				
			}
			
			
			// Commit Changes
			//System.out.println("Commiting all changes #######################################");
			connection.commit();
			connection.close();
			System.out.println("Connection close successfully ");
			
		} 
		
		catch (SQLException e) 
		{			
			successAR = false;
                        
			System.out.println(""+e.getMessage());
		}
		return successAR;
	}
}
