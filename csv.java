package wrapper;

	import java.io.BufferedReader;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.Writer;
	import java.util.ArrayList;
	import org.apache.jena.rdf.model.Model;
	import org.apache.jena.rdf.model.ModelFactory;
	import org.apache.jena.rdf.model.Property;
	import org.apache.jena.rdf.model.Resource;
	public class csv {

		    public ArrayList<String>List, actors,movies, countries;
			public static String Path = "/Users/kusumapraneetha/Documents/WEBSC/data.csv";
         		public static void main(String[] args) {
				csv actor = new csv();
				actor.Read();
				actor.Convert();
			}

			private void Read() 
			{
				int x = 0;
				List = new ArrayList<>(); 
				actors = new ArrayList<>();
				movies = new ArrayList<>();
				countries = new ArrayList<>();
			   File file = new File(Path);
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
								actors.add(temp[i]);
								}
								if(i==1) {
									movies.add(temp[i]);
								}
								if(i==2) {
									countries.add(temp[i]);
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
			private void Convert()
			{
				Model graphModel = ModelFactory.createDefaultModel();
				Property movie = graphModel.createProperty("http://ex.org/property/movie");
				Property country = graphModel.createProperty("http://ex.org/property/country"); 
				for(int i = 1;i<List.size();i++)
				{
					Resource actor = graphModel.createResource("http://ex.org/property/"+actors.get(i));
					actor.addProperty(movie, movies.get(i));
					actor.addProperty(country, countries.get(i));
				}
				graphModel.write(System.out, "N-Quads");
				try {
					Writer wr = new FileWriter("/Users/kusumapraneetha/Documents/WEBSC/output.ttl");
					graphModel.write(wr,"N-Quads");
					}
				catch(Exception e) 
				{
					e.printStackTrace();
				}
			}
		}


