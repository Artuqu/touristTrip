# App for tourist office manage

## For the correct operation of the program, it is necessary to add below queries in SQL.

### All data you need is in file tables.sql, path:resources/sql

### Application secured by Spring Security. To get full version you need to be log in. Password is hashed by BCrypt.
### First option to register the user with admin authority is to go /addUser address and send data.
### Second disable Bean BCrypt in SecurityConfig and enable NoOpPasswordEncoder. After that you can add user just by SQL Query.
insert into Conductor (id,full_name,pesel) values
(1,'Roman Wojtkowski', 88021256633),
(2,'Władysław Nop', 99030314845),
(3,'Marek Knot', 78051616816),
(4,'Mateusz Wojciechowski', 92092309563),
(5,'Iwona Matlęga', 96080932562);


insert into Trip(id,images,destination,description,price,conductor_id) values
(1,'images/czech-prague.jpg','Czech, Prague','Prague is one of the oldest and most beautiful cities in Europe. Be sure to see the Charles Bridge.', 500.00,1),
(2,'images/egypt-giza.jpg','Egypt, Gyza','Explore the land of the Pharaohs and take a photo with the mysterious sphinx.', 800.00,2),
(3,'images/spain-barcelona.jpeg','Spain, Barcelona','Southern climate and beautiful beaches of the Mediterranean Sea. Be sure to see one of the most famous cathedrals in Europe.', 600.00,3),
(4,'images/turkey-istambul.jpg','Turkey, Istambul','Former capital of Eastern Rome. The extraordinary Hagia Sophia intrigues with its momentum to this day.', 700.00,4),
(5,'images/italy-rome.jpg','Italy, Rome','All roads lead to Rome. See the Colosseum and the Roman Forum.', 550.00,5),
(6,'images/bulgaria-sun.jpg','Bulgaria, Sunny Beach','Sunny Beach is the most famous resort in Bulgaria. Get to know the cheapest riviera of Europe.', 550.00,3);


insert into Trip_Date (trip_id, start_date, end_date)values
(1,'01.03.2023', '22.03.2023'), (1,'01.04.2023', '12.04.2023'),(1,'13.11.2022', '22.11.2022'),
(2,'03.03.2023', '25.03.2023'), (2,'04.04.2023', '16.04.2023'),(2,'15.11.2022', '25.11.2022'),
(3,'03.02.2023', '25.02.2023'), (3,'04.03.2023', '16.03.2023'),(3,'15.12.2022', '25.12.2022'),
(4,'03.05.2023', '25.05.2023'), (4,'04.05.2023', '16.05.2023'),(4,'15.12.2023', '25.12.2023'),
(5,'03.06.2023', '25.06.2023'), (5,'04.06.2023', '16.06.2023'),(5,'15.09.2023', '25.09.2023'),
(6,'03.07.2023', '25.07.2023'), (6,'04.07.2023', '16.07.2023'),(6,'15.10.2023', '25.10.2023');

insert into Role (role_id, name)values (1, 'ROLE_ADMIN');