INSERT INTO role (type)
VALUE            ("ADMIN"),
                 ("USER");
INSERT INTO car (license_plate, repair_date , customer_name           , catalog          , car_maker)
VALUES          ('29H-66666' , '2003-11-16', 'Ngô Nhật Trường', 'Bảo dưỡng lần 1', 'BMW'  ),
                ('29E-22222' , '2013-10-02', 'Vũ Ngọc Duy', 'Bảo dưỡng lần 3', 'Mazda'  ),
                ('30H-88888' , '2012-01-09', 'Trương Tiến Mạnh', 'Bảo dưỡng lần 1', 'Honda'  ),
                ('30K-55555' , '2020-08-17', 'Nguyễn Xuân Bắc', 'Bảo dưỡng lần 2', 'Nissan'  ),
                ('29K-99999' , '2021-03-05', 'Hà Thục Khánh Huyền' , 'Bảo dưỡng lần 4', 'Mercedez-Benz' );

INSERT INTO accessory (license_plate, repair_date , name         , price  , status_damaged, repair_status)
VALUES                ('29K-99999' , '2021-03-05', 'Cần gạt mưa', 999000 , 'Bị gãy'      , 'Thay mới'   ),
                      ('29H-66666' , '2003-11-16', 'Lọc gió'    , 199000 , 'Bị bụi bẩn'  , 'Làm sạch'   ),
                      ('29H-66666' , '2003-11-16', 'Lốp xe'     , 2000000, 'Bị thủng'    , 'Thay lốp'   ),
                      ('29H-66666' , '2003-11-16', 'Bình ắc quy', 1465000, 'Bị hết điện' , 'Sạc điện'   ),
                      ('29E-22222' , '2013-10-02', 'Gương chiếu hậu', 4990000, 'Bị gãy' , 'Thay mới'   ),
                      ('30H-88888' , '2012-01-09', 'Kính chắn gió', 8990000, 'Bị vỡ' , 'Thay mới'   ),
                      ('30K-55555' , '2020-08-17', 'Đèn pha'     , 369000 , 'Bị vỡ nhựa bảo vệ'       , 'Thay lớp nhựa'   );

