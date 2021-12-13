let orderInformation = execution.get ("Orderinformationen");
let accountID = execution.get("accountID");
orderInformation = JSON.parse(orderInformation);

let order = {};
order.orderLineItems = [];
for (let index = 0; index < orderInformation.length; index++) {
    const element = orderInformation[index];
    order.orderLineItems.push({articleID : element.articleID, amount : element.amount, price: element.price, itemstatus : "erstellt"});
}
order.accountInfoID = accountID;
order.status = "erstellt";
