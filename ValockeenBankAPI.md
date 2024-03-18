
# Valockeen Bank API Endpoints

## Endpoints

### Create Account
- **Method**: POST
- **URL**: `/api/accounts`
- **Request Body**:
  ```json
  {
    "iban": "string (IBAN format)",
    "balance": "decimal number"
  }
  ```
- **Response**: AccountDTO object
  ```json
  {
    "id": "UUID",
    "iban": "string",
    "balance": "decimal number"
  }
  ```

### Get Account
- **Method**: GET
- **URL**: `/api/accounts/{accountId}`
- **Path Variable**: `accountId` (UUID)
- **Response**: AccountDTO object
  ```json
  {
    "id": "UUID",
    "iban": "string",
    "balance": "decimal number"
  }
  ```

### Delete Account
- **Method**: DELETE
- **URL**: `/api/accounts/{accountId}`
- **Path Variable**: `accountId` (UUID)
- **Response**: No content

### Create Transaction
- **Method**: POST
- **URL**: `/api/transactions`
- **Request Body**:
  ```json
  {
    "amount": "decimal number",
    "from_account": "string (IBAN format)",
    "to_account": "string (IBAN format)"
  }
  ```
- **Response**: TransactionDTO object
  ```json
  {
    "id": "UUID",
    "amount": "decimal number",
    "fromAccount": "string",
    "toAccount": "string"
  }
  ```

### Get Transaction
- **Method**: GET
- **URL**: `/api/transactions/{transactionId}`
- **Path Variable**: `transactionId` (UUID)
- **Response**: TransactionDTO object
  ```json
  {
    "id": "UUID",
    "amount": "decimal number",
    "fromAccount": "string",
    "toAccount": "string"
  }
  ```

### Delete Transaction
- **Method**: DELETE
- **URL**: `/api/transactions/{transactionId}`
- **Path Variable**: `transactionId` (UUID)
- **Response**: No content


## Data Transfer Objects (DTOs)

### AccountDTO
Represents an account with the following properties:
- `id` (UUID): Unique identifier of the account.
- `iban` (String): The International Bank Account Number.
- `balance` (BigDecimal): Current balance of the account.

### TransactionDTO
Represents a transaction with the following properties:
- `id` (UUID): Unique identifier of the transaction.
- `amount` (BigDecimal): The amount transferred in the transaction.
- `fromAccount` (AccountDTO): The account from which the amount was transferred.
- `toAccount` (AccountDTO): The account to which the amount was transferred.
