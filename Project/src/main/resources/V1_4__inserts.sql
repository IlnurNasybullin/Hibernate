INSERT INTO dict_airline VALUES (1, 'Победа'),
                                (2, 'Аэрофлот'),
                                (3, 'ЮВТ АЭРО');

INSERT INTO dict_country VALUES (1, 'Российская Федерация'),
                                (2, 'США'),
                                (3, 'Канада');

INSERT INTO dict_operated_company VALUES (1, 'Уральские авиалинии'),
                                         (2, 'АвиаТИС'),
                                         (3, 'АвисКом');

INSERT INTO dict_phone_number VALUES (nextval('phone_number_seq'), '8-912-45-32-235'),
                                     (nextval('phone_number_seq'), '8-912-55-12-565'),
                                     (nextval('phone_number_seq'), '8-952-05-32-002');

INSERT INTO dict_postal_index VALUES (420000, '420000'),
                                     (423800, '423800'),
                                     (422980, '422980');

INSERT INTO address_object(id, country_id, region, city, postal_index_id)
    VALUES (nextval('address_object_seq'), 1, 'Республика Татарстан', 'Казань', 420000),
           (nextval('address_object_seq'), 1, 'Республика Татарстан', 'Казань', 420000),
            (nextval('address_object_seq'), 1, 'Республика Татарстан', 'Казань', 420000);