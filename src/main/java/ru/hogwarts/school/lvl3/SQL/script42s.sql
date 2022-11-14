ALTER TABLE student
    ALTER COLUMN name SET NOT NULL;
ALTER TABLE student
    ADD CONSTRAINT nickname_unique UNIQUE (name);
ALTER TABLE student
    ADD CONSTRAINT age_constraint CHECK ( age > 15);
ALTER TABLE student
    ALTER COLUMN age SET default 20;