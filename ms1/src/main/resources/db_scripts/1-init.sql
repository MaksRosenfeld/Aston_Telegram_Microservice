create table if not exists public.mentor
(
    id   serial      not null,
    name varchar(50) not null,
    primary key (id)
);

insert into public.mentor(name)
values ('jack'), ('bob'), ('maks');