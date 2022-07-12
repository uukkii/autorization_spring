## Домашнее задание к занятию 7.2: REST

### Задача Сервис авторизации

**v. 1.0**

Задание реализовано:

- Точка входа в программу - `Application.java`

- В пакете `ru.netology.authorization_spring.authorities` содержится **ENUM** `Authorities` с 
перечислением модификаторов доступа.

- В пакете `ru.netology.authorization_spring.controller` содержится класс контроллера 
`AuthorizationController`, который содержит в себе маппинг и два хэндлера исключений.

- В пакете `ru.netology.authorization_spring.exceptions` содержатся классы исключений - 
`InvalidCredentials` и `UnauthorizedUser`.

- В пакете `ru.netology.authorization_spring.repository` находится класс репозитория UserRepository, содержащий метод
`public List<Authorities> getUserAuthorities(String user, String password)`, который произодит записывает
модификаторы доступа пользователей в список. 
В случае незаполнения поля **"user"** или **"password"**, выбрасывается исключение `InvalidCredentials`.
В случае отсуствия пользователя в базе или допущена ошибка при вводе пароля - выбрасывается 
исключение `UnauthorizedUser`.

- В пакете `ru.netology.authorization_spring.service` содержится класс сервиса `AuthorizationService`.

После запуска сервера: 
1. На **GET-запрос** `localhost:8080/authorize?user=admin&password=admin` получаем ответ _200 OK_:
```
[
"READ",
"WRITE",
"DELETE"
]
```

2. На **GET-запрос** `localhost:8080/authorize?user=admin&password=user` получаем ответ _401 Unauthorized_:
```   
Unknown user admin
```

3. На **GET-запрос** `localhost:8080/authorize?user=&password=` получаем ответ _400 Bad Request_:
```
User name or password is empty
```