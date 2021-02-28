CREATE FUNCTION get_document_id_and_dates(p_id bigint) RETURNS TABLE(id bigint, issued_date date, valid_date date) AS $$
		SELECT d.id, d.issued_date, d.valid_date FROM document d LEFT JOIN passenger_to_document psd ON d.id = psd.document_id
			WHERE psd.passenger_id = p_id;
	$$ LANGUAGE SQL;

CREATE FUNCTION check_passenger_date() RETURNS TRIGGER AS $check_passenger_date$
        DECLARE p_id bigint;
                doc record;
                p_birthdate date;
                valid_date date;
                issued_date date;
        BEGIN
            p_id := NEW.id;
            p_birthdate := NEW.birthdate;
            IF p_id IS NULL OR p_birthdate IS NULL THEN RETURN NEW;
            END IF;

            FOR doc in SELECT get_document_id_and_dates(p_id) LOOP
                valid_date := doc.valid_date;
                issued_date := doc.issued_date;

                IF valid_date IS NOT NULL AND valid_date <= p_birthdate THEN
                    RAISE EXCEPTION 'doc with id % has valid date that less or equal than passenger birthdate (passenger id is %', doc.id, p_id;
                END IF;

                IF issued_date IS NOT NULL AND issued_date < p_birthdate THEN
                    RAISE EXCEPTION 'doc with id % has issued date that less than passenger birthdate (passenger id is %', doc.id, p_id;
                END IF;
            END LOOP;
        RETURN NEW;
        END;
    $check_passenger_date$ LANGUAGE plpgsql;

CREATE TRIGGER check_passenger_date BEFORE UPDATE ON passenger
    FOR EACH ROW EXECUTE PROCEDURE check_passenger_date();

CREATE FUNCTION get_passenger_id_and_birthdate(doc_id bigint, OUT id bigint, OUT birthdate date) RETURNS record AS $$
        SELECT id, birthdate FROM passenger ps LEFT JOIN passenger_to_document psd ON ps.id = psd.passenger_id WHERE psd.document_id = doc_id;
    $$ LANGUAGE SQL;

CREATE FUNCTION check_document_dates() RETURNS TRIGGER AS $check_document_dates$
    declare
        d_id bigint;
        issued_date date;
        valid_date date;
        ps record;
        ps_id bigint;
        birthdate date;
    begin
        d_id := NEW.id;
        issued_date := NEW.issued_date;
        valid_date := NEW.valid_date;

        if d_id IS NULL OR issued_date IS NULL AND valid_date IS NULL THEN
           RETURN NEW;
        end if;

        ps := get_passenger_id_and_birthdate(d_id);
        ps_id := ps.id;
        birthdate := ps.birthdate;

        if ps_id IS NULL OR birthdate IS NULL THEN
            RETURN NEW;
        end if;

        if issued_date IS NOT NULL AND birthdate > issued_date THEN
           RAISE EXCEPTION 'passenger with id % has birthdate more than doc issued date with doc id %', ps_id, d_id;
        end if;

        if valid_date IS NOT NULL AND birthdate >= valid_date THEN
            RAISE EXCEPTION 'passenger with id % has birthdate more than doc valid date with doc id %', ps_id, d_id;
        end if;

        RETURN NEW;
    end;
    $check_document_dates$ LANGUAGE plpgsql;

CREATE TRIGGER check_document_dates BEFORE UPDATE ON document
    FOR EACH ROW EXECUTE PROCEDURE check_document_dates();

CREATE FUNCTION get_passenger_birthdate(p_id bigint) RETURNS date AS $$
        SELECT birthdate FROM passenger WHERE passenger.id = p_id;
    $$ LANGUAGE sql;

CREATE FUNCTION get_document_dates(doc_id bigint, OUT issued_date date, OUT valid_date date) RETURNS record AS $$
        SELECT issued_date, valid_date FROM document WHERE document.id = doc_id;
    $$ LANGUAGE sql;

CREATE FUNCTION check_passenger_and_document_dates() RETURNS TRIGGER AS $check_passenger_and_document_dates$
    declare
        p_id bigint;
        doc_id bigint;
        birthdate date;
        valid_date date;
        issued_date date;
        doc_dates record;
    begin
        p_id := NEW.passenger_id;
        doc_id := NEW.document_id;

        if p_id IS NULL OR doc_id IS NULL THEN
            RETURN NEW;
        end if;

        birthdate := get_passenger_birthdate(p_id);
        if birthdate is NULL THEN
            RETURN NEW;
        end if;

        if issued_date IS NOT NULL AND birthdate > issued_date THEN
            RAISE EXCEPTION 'passenger with id % has birthdate more than doc issued date with doc id %', p_id, doc_id;
        end if;

        if valid_date IS NOT NULL AND birthdate >= valid_date THEN
            RAISE EXCEPTION 'passenger with id % has birthdate more than doc valid date with doc id %', p_id, doc_id;
        end if;

        RETURN NEW;
    end;
    $check_passenger_and_document_dates$ LANGUAGE plpgsql;

CREATE TRIGGER check_passenger_and_document_dates BEFORE INSERT OR UPDATE ON passenger_to_document
    FOR EACH ROW EXECUTE PROCEDURE check_passenger_and_document_dates();