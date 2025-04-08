-- Display the list of ALL the Accounts registered 
-- in the banking system, sorted in descending order of the Account Balances. 
-- Include the Customer data for each Account. 

SELECT 
a.accountId,a.accountNumber,a.dateOpened,a.status,a.balance,
ct.accountTypeName,
c.firstName,c.lastName, c.telephone
FROM accounts a
join accountCustomers ac on ac.accountId = a.accountId
join customers c on ac.customerId = c.customerId
join accountTypes ct on ct.accountTypeId = a.accountType
order by a.balance desc;


-- Display the list of ALL Transactions with a Value Amount greater than 500.00. Include in the result, 
-- the Account Numbers. 
-- And sort the list in ascending order of the Tansaction Date and Time. 

select 
t.*, a.accountNumber
from transactions t
join accounts a on a.accountId = t.accountId
where t.valueAmount > 500
order by t.transactionDate desc, t.transactionTime desc;