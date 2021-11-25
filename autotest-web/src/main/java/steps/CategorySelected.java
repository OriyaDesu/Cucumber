package steps;

public enum CategorySelected {
        Любая_категория("Любая категория", 1),
        Транспорт("Транспорт", 2),
        Автомобили("Автомобили", 3),
        Мотоциклы_и_мототехника("Мотоциклы и мототехника", 4),
        Грузовики_и_спецтехника("Грузовики и спецтехника", 5),
        Водный_транспорт("Водный транспорт", 6),
        Запчасти_и_аксессуары("Запчасти и аксессуары", 6),
        Недвижимость("Недвижимость", 8),
        Квартиры("Квартиры", 9),
        Комнаты("Комнаты", 10),
        Дома_дачи_коттеджи("Дома дачи коттеджи",11),
        Гаражи_и_машиноместа("Гаражи и машиноместа", 12),
        Земельные_участки("Земельные участки", 13),
        Коммерческая_недвижимость("Коммерческая недвижимость", 14),
        Недвижимость_за_рубежом("Недвижимость за рубежом", 15),
        Работа("Работа", 16),
        Вакансии("Вакансии", 17),
        Резюме("Резюме", 18),
        Услуги("Услуги", 19),
        Личные_вещи("Личные вещи", 20),
        Одежда_обувь_аксессуары("Одежда обувь аксессуары", 21),
        Детская_одежда_и_обувь("Детская одежда и обувь", 22),
        Товары_для_детей_и_игрушки("Товары для детей и игрушки", 23),
        Часы_и_украшения("Часы и украшения", 24),
        Красота_и_здоровье("Красота и здоровье", 25),
        Для_дома_и_дачи("Для дома и дачи",26),
        Бытовая_техника("Бытовая техника",27),
        Мебель_и_интерьер("Мебель и интерьер",28),
        Посуда_и_товары_для_кухни("Посуда и товары для кухни", 29),
        Продукты_питания("Продукты питания",30),
        Ремонт_и_строительство("Ремонт и строительство",31),
        Растения("Растения", 32),
        Бытовая_электроника("Бытовая электроника",33),
        Аудио_и_видео("Аудио и видео",34),
        Игры_приставки_и_программы("Игры приставки и программы", 35),
        Настольные_компьютеры("Настольные компьютеры", 36),
        Ноутбуки("Ноутбуки",37),
        Оргтехника_и_расходники("Оргтехника и расходники",99),
        Планшеты_и_электронные_книги("Планшеты и электронные книги",39),
        Телефоны("Телефоны",40),
        Товары_для_компьютера("Товары для компьютера",41),
        Фототехника("Фототехника",42),
        Хобби_и_отдых("Хобби и отдых",43),
        Билеты_и_путешествия("Билеты и путешествия",44),
        Велосипеды("Велосипеды",45),
        Книги_и_журналы("Книги и журналы",46),
        Коллекционирование("Коллекционирование",47),
        Музыкальные_инструменты("Музыкальные инструменты", 48),
        Охота_и_рыбалка("Охота и рыбалка",49),
        Спорт_и_отдых("Спорт и отдых", 50),
        Животные("Животные",51),
        Собаки("Собаки",52),
        Кошки("Кошки",53),
        Птицы("Птицы",54),
        Аквариум("Аквариум",55),
        Другие_животные("Другие животные",56),
        Товары_для_животных("Товары для животных",57),
        Готовый_бизнес_и_оборудование("Готовый бизнес и оборудование",58),
        Готовый_бизнес("Готовый бизнес",59),
        Оборудование_для_бизнеса("Оборудование для бизнеса",60);

        private String categorySelected;
        private int id;

        CategorySelected(String categorySelected, int id) {
                this.categorySelected = categorySelected;
                this.id = id;
        }

        public String getCategorySelected() {
                return categorySelected;
        }

        public int getId() {
                return id;
        }
}