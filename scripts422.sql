CREATE TABLE car
(
    id    SERIAL primary key,
    brand TEXT,
    model TEXT,
    price REAL
)
CREATE TABLE Human
(
    id      Serial primary key,
    name    TEXT,
    age     INTEGER,
    licence BOOLEAN,
    car_id  SERIAL REFERENCES car (id)
);
