
var json = execution.getVariable("orderLineItems");
var parsed = JSON.parse(json);

var resourceURL = new java.net.URL("https://projectmas.herokuapp.com/api/v1/accounts/exists/" + parsed.email);
resourceURL.requestMethod = "GET";
var urlConnection = resourceURL.openConnection();
var inputStream = new java.io.InputStreamReader(urlConnection
        .getInputStream());
var bufferedReader = new java.io.BufferedReader(inputStream);
var inputLine ="";
var exists= "";
inputLine = bufferedReader.readLine();
while (inputLine != null) {
exists+= inputLine;			
inputLine = bufferedReader.readLine();
			}
bufferedReader.close();

execution.setVariable("accountExists", exists);
execution.setVariable("email", parsed.email);