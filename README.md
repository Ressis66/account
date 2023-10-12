# Spring Boot "Account" Example Project

This is a sample Java / Maven / Spring Boot (version 2.7.16) application. I hope it helps you.

## How to Run 

Here are some endpoints you can call:

### Get information about accounts.

```
http://127.0.0.1:8080/accounts

```
### Create an account

```
POST http://127.0.0.1:8080/create?name=12&pinCode=2223
```

### Deposit money to an account

```
POST http://127.0.0.1:8080/deposit?id=2&sum=2223
```

### Withdraw money from an account

```
POST http://127.0.0.1:8080/withdraw?id=2&pinCode=2223&sum=2
```

### Transfer money

```
POST http://127.0.0.1:8080/transfer
Accept: application/json
{
    "firstId": 2,
    "secondId": 1,
    "pinCode": 2223,
    "sum": 8
}
```