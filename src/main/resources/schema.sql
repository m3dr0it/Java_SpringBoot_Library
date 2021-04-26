drop table if exists books;
drop table if exists genres;

create table genres (
    id uuid primary key not null default uuid_generate_v4(),
    genre varchar(255)
    );

create table books (
    id uuid primary key not null default uuid_generate_v4(),
    title varchar(255),
    author varchar(255),
    genre_id uuid,
    constraint fk_genre
    foreign key(genre_id) references genres(id)
    );