### JAX-RS with Jersey
Simple example using Jersey for create a REST web services.

#### Converting the object to XML
Add this dependency in pom.xml:
```
<dependency>
  <groupId>xstream</groupId>
  <artifactId>xstream</artifactId>
  <version>1.2.2</version>
</dependency>
```
In class that is necessary convert to XML:
```
  public String toXML() {
    return new XStream().toXML(this);
  }
```

#### Converting the object to Json
Add this dependency in pom.xml:
```
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.8.5</version>
</dependency>
```
In class that is necessary convert to Json:
```
public String toJSON() {
	return new Gson().toJson(this);
}
```


#### Using Grizzly to start server with web services
Add this dependency in pom.xml:
```
<dependency>
  <groupId>org.glassfish.jersey.containers</groupId>
  <artifactId>jersey-container-grizzly2-http</artifactId>
  <version>2.23.2</version>
</dependency>
```
Start the Http server with this code:
```
public static void main(String[] args) {
	try {
		ResourceConfig config = new ResourceConfig().packages("com.company");
		URI uri = URI.create("http://localhost:8080/");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		System.out.println("Server is running");
		System.in.read();
		server.shutdown();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
```


