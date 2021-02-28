ALTER TABLE airplane ADD CONSTRAINT airplane_date_chronological_constraint
    CHECK(rolling_date <= maiden_flight_date AND maiden_flight_date <= registration_date
              AND registration_date <= nearest_operation_date);

ALTER TABLE airport
    ADD CONSTRAINT icao_id_constraint CHECK(icao_id ~ '^[A-Z]{4}$'),
    ADD CONSTRAINT iata_id_constraint CHECK(iata_id ~ '^[A-Z]{3}$');

ALTER TABLE flight
    ADD CONSTRAINT flight_date_chronological_constraint CHECK(start_time < end_time),
    ADD CONSTRAINT flight_real_date_chronological_constraint CHECK(real_start_time < real_end_time);

ALTER TABLE document
    ADD CONSTRAINT document_chronological_date_constraint CHECK(issued_date < valid_date)