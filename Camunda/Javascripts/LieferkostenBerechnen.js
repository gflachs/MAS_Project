var orderInformation = execution.getVariable("Orderinformationen");

orderInformation = JSON.parse(orderInformation);
var shippingCosts = orderInformation.articleAmount/10 * 0.5;

orderInformation.shippingCosts = shippingCosts;

execution.setVariable("Orderinformationen", S(JSON.stringify(orderInformation)));
