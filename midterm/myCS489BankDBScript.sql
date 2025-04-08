
create table customers(
customerId integer not null, 
firstName varchar(255),
lastName varchar(255),
telephone varchar(255),
PRIMARY KEY (customerId)
);

INSERT INTO customers (firstName,lastName,telephone)
VALUES 
    ('Daniel', 'Agar', NULL),
    ('Bernard', 'Shaw','(641) 472-1234'),
    ('Carly', 'DeFiori', NULL);



create TABLE accountTypes (
    accountTypeId INT NOT NULL AUTO_INCREMENT,
    accountTypeName VARCHAR(255) NOT NULL,
    PRIMARY KEY (accountTypeId)
);

    INSERT INTO accountTypes (accountTypeId, accountTypeName)
VALUES
    (1, 'Checking'),
    (2, 'Savings'),
    (3, 'Loan');


CREATE TABLE accounts (
    accountId INT NOT NULL AUTO_INCREMENT,
    accountNumber VARCHAR(255) NOT NULL UNIQUE,
    dateOpened DATE NOT NULL,
    status VARCHAR(255) NOT NULL,
    balance VARCHAR(255) NOT NULL,
    customerId INT NOT NULL,
    accountType INT NOT NULL,
    PRIMARY KEY (accountId),
    FOREIGN KEY (customerId) REFERENCES customers(customerId),
    FOREIGN KEY (accountType) REFERENCES accountTypes(accountTypeId)
);

CREATE TABLE accountCustomers (
    accountId INT NOT NULL,
    customerId INT NOT NULL,
    PRIMARY KEY (accountId, customerId),
    FOREIGN KEY (accountId) REFERENCES accounts(accountId) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (customerId) REFERENCES customers(customerId) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into accountCustomers(accountId,customerId)
VALUES
    (1, 3),
    (2, 1),
    (2,2),
    (3,3),
    (4,3);

CREATE TABLE transactions (
    transactionId INT NOT NULL AUTO_INCREMENT,
    transactionNumber VARCHAR(255) NOT NULL UNIQUE,
    description VARCHAR(255),
    valueAmount VARCHAR(255),
    transactionDate DATE,
    transactionTime VARCHAR(255),
    transactionType VARCHAR(255),
    accountId INT NOT NULL,
    PRIMARY KEY (transactionId),
    FOREIGN KEY (accountId) REFERENCES accounts(accountId)
);

insert into transactions (transactionNumber,description, valueAmount, transactionDate,transactionTime,
transactionType,accountId)
VALUES 
('D0187-175', 'Deposit to Savings', '100,000.00', '2021-10-15', '12:15:00', 'Deposit', 2),
    ('W1736-142', 'Teller counter withdrawal', '550.00', '2022-08-24', '10:05:00', 'Withdrawal', 2),
    ('DD001-142', 'Direct deposit – wage', '2475.75', '2014-03-01', '05:00:00', 'Direct deposit ', 1),
    ('P162-0017', 'Merch purchase online', '150.95 ', '2019-12-15', '14:19:00 ', 'Purchase', 1);



