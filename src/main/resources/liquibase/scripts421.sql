

--changeset Vasiliy:1
ALTER TABLE student ADD CONSTRAINT age_constraint CHECK (age > 16);
ALTER TABLE student ADD CONSTRAINT name_unique UNIQUE (name);
ALTER TABLE faculty ADD CONSTRAINT name_color_uniq UNIQUE (name,color);
ALTER TABLE student ALTER age SET DEFAULT 20;