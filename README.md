# Money Transfer App

## Features

### Onboarding Screens
Users are greeted with onboarding screens the first time they use the app to introduce them to the features and functionality.

### Account Creation
Users can create an account by entering their personal information, including name, email, and a secure password.  
Passwords must be 6 characters long and include one uppercase letter, one lowercase letter, and one special character (e.g., $%^).

### Profile Completion
Users must complete their profile by providing additional details such as country and date of birth (DOB) to fully utilize the app.

### Login
Users can log in to their account using their credentials to access account details and perform transactions.

### Account Balance
Users can view their account balance to keep track of available funds.

### Transaction History
Users can view their transaction history, including transaction date, recipient name, and transaction amount.

### Send Money
Users can send money to other users by entering recipient details, including name and account number.

### Verify Recipient
Users can verify recipient account details via an API call before confirming a transaction to ensure correctness.

### Transaction Confirmation
Users receive confirmation or notifications after completing a successful transaction.

### Error Notifications
Users receive error messages or notifications for issues during transactions, such as insufficient funds or invalid recipient details.

### Update Profile
Users can update their profile information, including email address, country, DOB, or password.

### Support Options
Users can contact support via phone or email if they encounter issues with the app.

### Inactivity Alert
Users receive an alert dialog after two minutes of inactivity, prompting them to log in again.

### Favorites
Users can save and manage favorite recipients for quicker transfers while also editing or deleting favorites. They can also call them to copy info while transferring money.

### Server Errors and Connectivity
Users are informed about connectivity issues through specified screens in the design.

..................................................................

PATCH 1.2v (after deadline)

Fixed Issues:

-Fixed SignIn retention from Home Screen

-MORE package: Modified logout option


Additions:

-Kotlin file Transfer.PH1: Fixed favorite card view in ModalSheet 

-Added logout_view_model to viewmodels package


Known Issues:

-Error 404 does not navigate to its origin screen

-Website option in more list does not redirect to any website

-Adding Cards option are only made as a concept UI without saving real data in any database

-In some occations InActive dialogue works incorrectly

- Favorites Screen add's new favorites however fails to refresh the screen automatically after adding
