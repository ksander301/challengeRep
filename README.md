Смысл такой. Если я все классы собираю в один пакет (ru.test. неудачное название я уже понял) то мое приложение запускается 
(хотя при попытке выполнить package или test валится с ошибкой) и я могу по адресу обратиться к контроллеру получить json 
и прочее бла бла бла.

Но как только я разделя. классы на пакеты (bookmarks, repository,rest) у меня сыпется ошибка при запуске приложения

Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'bookmarkRepository': 
Invocation of init method failed; nested exception is java.lang.IllegalArgumentException: Not a managed type: class ru.test.bookmarks.Bookmark

Тут определнно есть магия которую я не знаю, почему он не может создать Bean находящийся в другом пакете.
