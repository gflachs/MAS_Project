
try{
let order = execution.getVariable("order");



contentType =  "application/json;charset=UTF-8";
    var con = new java.net.URL("https://projectmas.herokuapp.com/api/v1/orderVersendet" + order.orderID).openConnection();



    con.requestMethod = "GET";
    var inReader = new java.io.BufferedReader(new java.io.InputStreamReader(con.getInputStream()));
    var inputLine;
    var response = new java.lang.StringBuffer();

    while ((inputLine = inReader.readLine()) != null) {
           response.append(inputLine);
    }
    inReader.close();


} catch (error) {
    execution.setVariable("error", "error");
}