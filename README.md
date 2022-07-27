## Домашнее задание к занятию 7.4: Разворачивание Spring Boot приложений (nginx, systemd, firewall, journalctl)

### Задача Прокси на nginx.

**v. 1.0**

Задание реализовано:

1. В nginx.conf добавлена следующая конфигурация:

```
location /singin {
            root   html;
            index  singin.html;
        }

        location / {
        proxy_pass http://localhost:8080;
        }
```

В результате после перехода по адресу https://localhost/singin.html появляется html-форма, находящаяся
по адресу `.../nginx/html/singin.html`.

Сам файл **nginx.conf** добавлен в репозиторий.

3. В `.../nginx/html` корневой папки **nginx** добавлен файл **singin.html** (также вложен в репозиторий):
```
<html>
    <body>
        <h1>Sign in form</h1>

        <form action="/authorize" method="get" target="_blank">
          <label for="user">User name:</label>
          <input type="text" id="user" name="user"><br><br>
          <label for="password">Password:</label>
          <input type="text" id="password" name="password"><br><br>
          <button type="submit">Submit</button>
        </form>
    </body>
</html>
```