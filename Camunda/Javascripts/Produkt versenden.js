let trackingid = execution.getVariable("trackingid");
let order = execution.getVariable("order");
let email = execution.getVariable("email");
order = JSON.parse(order);

var conMail = new java.net.URL("https://projectmas.herokuapp.com/api/v1/sendMail").openConnection();
    
    conMail.requestMethod = "POST";
 conMail.setRequestProperty("Content-Type", contentType);
 conMail.setDoOutput(true);
var mailBody = {"from" : "Kundenservice", "to" : email, "subject" : "Bestellung " + order.orderID + " wurde versand", "text" : "Sehr geehrte Damen und Herren,\n die Bestellung " + order.orderID + " wurde versand.\nTrackingid: " + trackingid};
var wr1 = new java.io.DataOutputStream(conMail.getOutputStream());
wr1.writeBytes(JSON.stringify(mailBody));
   
wr1.flush();
wr1.close();

    var inReader1 = new java.io.BufferedReader(new java.io.InputStreamReader(conMail.getInputStream()));
    var inputLine1;
    var response1 = new java.lang.StringBuffer();

    while ((inputLine1 = inReader1.readLine()) != null) {
           response1.append(inputLine1);
    }
    inReader1.close();
execution.setVariable("res",response.toString());