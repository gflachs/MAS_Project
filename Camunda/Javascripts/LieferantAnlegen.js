
try{
let lastName = execution.getVariable("lastname");
let firstName = execution.getVariable("surename");
let taxNumber = execution.getVariable("ustID");
let street = execution.getVariable("street");
let bankaccount = execution.getVariable("bankaccount");
let email = execution.getVariable("lieferantemail");
let contactPhone = execution.getVariable("contactPhone");
let generalPhone = execution.getVariable("telefon");
let zipCode = execution.getVariable("zipCode");
let houseNumber = execution.getVariable("houseNumber");
let city = execution.getVariable("city");
let country = execution.getVariable("country");
let companyname = execution.getVariable("firmenname");

var accountInfo = {
    "firmenname" : companyname,
    "accountEmail": email,
    "ustID" : taxNumber,
    "telefon" : generalPhone,
    "contactPerson" : {
        "surname" : firstName,
        "lastname" : lastName,
        "telefonNumber" : contactPhone
    },
    "deliveryAdress" : {
        "street" : street,
        "houseNumber" : houseNumber,
        "zipCode" : zipCode,
        "city" : city,
        "country" : country
    },
    "bankaccount" : bankaccount
};


contentType =  "application/json;charset=UTF-8";
    var con = new java.net.URL("https://projectmas.herokuapp.com/api/v1/supplier").openConnection();



    con.requestMethod = "POST";
    con.setRequestProperty("Content-Type", contentType);

    // Send post request
    con.setDoOutput(true);

var wr = new java.io.DataOutputStream(con.getOutputStream());




wr.writeBytes(JSON.stringify(accountInfo));
 wr.flush();
    wr.close();
    var inReader = new java.io.BufferedReader(new java.io.InputStreamReader(con.getInputStream()));
    var inputLine;
    var response = new java.lang.StringBuffer();

    while ((inputLine = inReader.readLine()) != null) {
           response.append(inputLine);
    }
    inReader.close();

 var conMail = new java.net.URL("https://projectmas.herokuapp.com/api/v1/sendMail").openConnection();
    
    conMail.requestMethod = "POST";
 conMail.setRequestProperty("Content-Type", contentType);
 conMail.setDoOutput(true);
var mailBody = {"from" : "Partnermanagement", "to" : email, "subject" : "Herzlich Willkommen bei der Naturnah GmbH", "text" : "Guten Tag,\nSie haben sich erfolgreich bei der NaturNah GmbH registiert. Ab jetzt koennen Sie sich mit Ihrer Emailadresse anmelden"};
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
} catch (error) {
    execution.setVariable("error", "error");
}