Инструкция:
1. Создайте в pg admin базу bankcardsystem
2. В ней создайте схему s_bankcard
3. Поменяйте в application.yaml значений свойст username и password на свои
4. Запустите приложение
5. Перейдите по URL: http://localhost:8081/swagger-ui/index.html
6. Всё :) Можно покидать джейсонки на эндпоинты

JSON для тестов:

    {
        "cardNumber": "1234567890123456",
        "cardholderName": "John",
        "cardholderSurname": "Doe",
        "issuingBank": "SBER",
        "cardType": "CREDIT",
        "expirationDate": "2024-12-31 23:59:00",
        "cvcCode": "123",
        "paymentSystem": "MIR",
        "additionalBenefits": "Reward Points",
        "issueDate": "2024-01-01 00:00:00",
        "status": "true",
        "balance": 1000.0,
        "creditLimit": 5000.0,
        "overdraftLimit": 200.0,
        "currency": "RUB"
    }