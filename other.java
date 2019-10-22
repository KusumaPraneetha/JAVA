package wrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;


import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;




public class other {

	private static final String PATH = "/Users/kusumapraneetha/Documents/WEBSC/Project/library_data.csv";
	public ArrayList<String>List, tranID,book,personName,personCategory,personID,issue,Return,studyRoom,meetingRoom,emailList;
	private void Read()
	{
		int x = 0;
		List = new ArrayList<>();
		tranID = new ArrayList<>(); 
		book = new ArrayList<>();
		personName = new ArrayList<>();
		personCategory = new ArrayList<>();
		personID = new ArrayList<>();
		issue = new ArrayList<>();
		Return = new ArrayList<>();
		studyRoom = new ArrayList<>();
		meetingRoom = new ArrayList<>();
		emailList = new ArrayList<>();
	   File file = new File(PATH);
				if(file.exists())
		{
			try 
			{
			FileReader fileRead = new FileReader(file);
			BufferedReader reader = new BufferedReader(fileRead);
			String read = "";
			while((read = reader.readLine())!=null) 
			{
				List.add(read);
	
					String temp[] = List.get(x).split(",");
					for(int i=0;i<temp.length;i++) {
						if(i==0) {
							tranID.add(temp[i]);
						}
						if(i==1) {
							book.add(temp[i]);
						}
						if(i==2) {
							personName.add(temp[i]);
						}
						if(i==3) {
							
							personCategory.add(temp[i]);
						}
						if(i==4) {
							personID.add(temp[i]);
						}
						if(i==5) {
							issue.add(temp[i]);
						}
						if(i==6) {
							Return.add(temp[i]);
						}
						if(i==7){
							studyRoom.add(temp[i]);
						}
						if(i==8) {
							meetingRoom.add(temp[i]);
						}
						if(i==9) {
							emailList.add(temp[i]);
						}
					}
				x++;
			}
			}
			catch(IOException io) {
				io.printStackTrace();
			}
		}
		else {
			System.out.println("missing file");
		}
	}
	
	
	
	public void createModel() throws FileNotFoundException{
		Model mymodel = ModelFactory.createDefaultModel();
		
		Property Transaction_ID = mymodel.createProperty("http://www.LibrarySystem.org/property/hasTransactionID");
		Property Person_ID = mymodel.createProperty("http://www.LibrarySystem.org/property/hasPersonID");
		Property hasBorrowed = mymodel.createProperty("http://www.LibrarySystem.org/property/hasBorrowed");
		Property issueDate = mymodel.createProperty("http://www.LibrarySystem.org/property/hasIssueDate");
		Property returnDate = mymodel.createProperty("http://www.LibrarySystem.org/property/hasReturnDate");	
		Property bookedStudyRoom=mymodel.createProperty("http://www.LibrarySystem.org/property/bookedStudyRoom");
		Property bookedMeetingRoom=mymodel.createProperty("http://www.LibrarySystem.org/property/bookedMeetingRoom");
	    Property hasCategory=mymodel.createProperty("http://www.LibrarySystem.org/property/hasCategory");
	    Property hasEmailContact=mymodel.createProperty("http://www.LibrarySystem.org/property/hasEmailContact");
		
		for(int i = 1;i<List.size();i++)
		{
			Resource Book = mymodel.createResource("http://www.LibrarySystem.org/Book/"+book.get(i) );
			Resource Person = mymodel.createResource("http://www.LibrarySystem.org/Person/"+personName.get(i));
			Resource StudyRoom = mymodel.createResource("http://www.LibrarySystem.org/Study_Room/"+studyRoom.get(i));
			Resource MeetingRoom = mymodel.createResource("http://www.LibrarySystem.org/Meeting_Room/"+meetingRoom.get(i));
				
			    Person.addProperty(Transaction_ID,tranID.get(i) );
				Person.addProperty(Person_ID,personID.get(i) );
				Person.addProperty(hasEmailContact, emailList.get(i));
				Person.addProperty(hasCategory,personCategory.get(i));
				Person.addProperty(issueDate, issue.get(i));
				Person.addProperty(returnDate, Return.get(i));
				Person.addProperty(hasBorrowed, Book);
				Person.addProperty(bookedStudyRoom, StudyRoom);
				Person.addProperty(bookedMeetingRoom, MeetingRoom);
				mymodel.write(System.out,"TURTLE");
				
			}
//		int counter=0;
//		StmtIterator iter=mymodel.listStatements();
//		while(iter.hasNext()) {
//			Statement stmt=iter.next();
//			Resource s = stmt.getSubject();
//			Property p=stmt.getPredicate();
//			RDFNode o = stmt.getObject();
//			
//			counter++;
//			
//			System.out.print(counter+".  ");
//			System.out.print("<"+s.toString()+"> ");
//			System.out.print("<"+ p.toString() + "> ");
//			if(o instanceof Resource)
//			{
//				System.out.println("<"+o.toString()+">");
//			}else {
//				System.out.print(" \""+o.toString()+"\"");
//			}
//			System.out.println(" .");
//
//	}
//		PrintStream o=new PrintStream(new File("/Users/kusumapraneetha/Documents/WEBSC/Project/rdf.txt"));
//		PrintStream console=System.out;
//		System.setOut(o);
//		System.setOut(console);
		
		try { 
			Writer wr=new FileWriter("/Users/kusumapraneetha/Documents/WEBSC/Project/test.ttl");
		    mymodel.write(wr,"TURTLE");
		 } 
		 catch (IOException e) { // TODO Auto-generated
		 e.printStackTrace(); 
		 }
		
			
	}

	public static void main(String[] args) throws FileNotFoundException {
		other obj = new other();//creating a new module
		obj.Read();
		obj.createModel();
	}
}



