#language:ru
@test

Функционал: Тестирование сервиса PetStore
  - Создание нового юзера POST запросом с телом из json файла, значения которого заполняем сгенерированным значениями
  - После создания нового юзера, GET запросом запрашиваем данного юзера и проверяем, что его данные соответствует данными из тела запроса

  Сценарий: Размещение заказа на питомца
    # Генерится дандомная страка по маске
        # E - Английская буква,
        # R - русская буква,
        # D - цифра. Остальные символы игнорятся
        # Условна дана строка TEST_EEE_DDD_RRR - снегерится примерно такая - TEST_QRG_904_ЙЦУ
    * сгенерировать переменные
      | id         | 23187      |
      | petId      | 7          |
      | quantity   | 1          |
      | shipDate   | 2021-12-01 |
      | status     | placed     |
      | complete   | true       |
    * создать запрос
      | method | path         | body                    |
      | POST   | /store/order | order.json              |
    * добавить header
      | Content-Type | application/json |
    * отправить запрос
    * статус код 200
    * сравнить значения
      | ${orderId} | != | null |

    # Вторая часть теста - запрос заказа и проверка его данных
    * создать запрос
      | method | path               |
      | GET    | /store/order/${id} |
    * добавить header
      | accept | application/json   |
    * отправить запрос
    * статус код 200
    * извлечь данные
      | resp_id | $.id |
    * сравнить значения
      | ${id}   | == | ${resp_id}   |

    #Удаляем заказ
    * создать запрос
      | method | path               | body                    |
      | DELETE | /store/order/${id} | order.json              |
    * добавить header
      | Content-Type | application/json |
    * отправить запрос
    * статус код 200

    #Проверяем, что заказ не существует
    * создать запрос
      | method | path               |
      | GET    | /store/order/${id} |
    * добавить header
      | accept | application/json   |
    * отправить запрос
    * статус код 404