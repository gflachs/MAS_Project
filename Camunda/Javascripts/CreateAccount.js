let order = execution.getVariable("lieferauftrag");

order = JSON.parse(order);
contentType =  "application/json";
    var con = new java.net.URL("https://hooks.slack.com/services/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").openConnection();

    con.requestMethod = "POST";
    con.setRequestProperty("Content-Type", contentType);
    con.setRequestProperty("Authorization", "Y0ptqMpChiQ7o99pS2Ygp7jL");
    // Send post request
    con.setDoOutput(true);

var wr = new java.io.DataOutputStream(con.getOutputStream());
    wr.writeBytes(JSON.stringify({"channel": "C02S8KD4U3H", "text" : "Bitte die Kundenzahlung zum Auftrag: " + order.orderID + " durchfuehren"}));
    wr.flush();
    wr.close();

 var inReader = new java.io.BufferedReader(new java.io.InputStreamReader(con.getInputStream()));
    var inputLine;
    var response = new java.lang.StringBuffer();

    while ((inputLine = inReader.readLine()) != null) {
           response.append(inputLine);
    }
    inReader.close();

