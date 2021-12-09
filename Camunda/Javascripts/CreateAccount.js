let lastName = execution.getVariable("lastName");
let firstName = execution.getVariable("sureName");
let taxNumber = execution.getVariable("taxid");
let street = execution.getVariable("street");
let bankaccount = execution.getVariable("bankaccount");
let email = execution.getVariable("email");
let contactPhone = execution.getVariable("contactTelefon");
let generalPhone = execution.getVariable("generalTelefon");
let zipCode = execution.getVariable("zipCode");
let houseNumber = execution.getVariable("number");
let city = execution.getVariable("city");
let country = execution.getVariable("country");
let companyname = execution.getVariable("name");

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


contentType =  "application/json";
    var con = new java.net.URL("https://projectmas.herokuapp.com/api/v1/accounts").openConnection();

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

execution.setVariable("res",response.toString());