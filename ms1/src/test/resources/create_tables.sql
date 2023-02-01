create table tag (
	id serial not null,
	name text not null,
	primary key (id)
);

create table mentor(
	id serial not null,
	name text not null,
	surname text not null,
	tag_id integer not null,
	experience_in_years integer,
	price money not null,
	is_avaliable boolean not null,
	primary key(id),
	foreign key(tag_id) references tag(id)
);

create table course(
    id serial not null,
    name text not null,
    description text,
    tag_id integer not null,
    group_size integer, 
    mentor_id integer not null,
    primary key(id),
    foreign key(tag_id) references tag(id),
    foreign key(mentor_id) references mentor(id)
);