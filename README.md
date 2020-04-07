# Proiect-PAO - Credite

## Actions:

- register user
- sign-in user
- sign-out user
- ask for a credit
- ask for interest rate
- pay installment
- ask details about your credit
- check bank balance
- ask for delay
- ask for help

## Objects:

- User
- AuthService
- Client 
- Credit
- CreditService
- Card
- TransactionService
- DatabaseService

# Documentatie

In proiect am o clasa Client care deriva din clasa de baza User, o interfata DatabaseService care este implementata de ListDatabaseService (momentan baza de date consta intr-un ArrayList de users si un HashMap de users si credite), clasele servicii AuthService, CreditService, ListDatabaseService si TransactionService (dintre care doar AuthService si CreditService sunt folosite in functia main() ) si clasele model Card si Credit.
