create table users (
                       id serial primary key,
                       identifier text not null,
                       created_at timestamp not null,
                       updated_at timestamp not null,
                       enabled boolean not null default true
);

create table question (
                          id serial primary key,
                          langCode text not null,
                          question text not null,
                          created_at timestamp not null,
                          updated_at timestamp not null,
                          enabled boolean not null default true
);


create table user_question(
                              user_id integer references users(id),
                              question_id integer references question(id),
                              is_correct boolean,
                              created_at timestamp not null
);

create table choice(
                       id serial primary key,
                       choice_text text not null,
                       correct boolean,
                       question_id integer not null references question(id),
                       created_at timestamp not null,
                       updated_at timestamp not null,
                       enabled boolean not null default true
);


create table question_tag (
                              id serial primary key,
                              name text not null,
                              created_at timestamp not null,
                              updated_at timestamp not null,
                              enabled boolean not null default true
);

create table question_question_tag (
                                       question_id integer not null references question(id),
                                       question_tag_id integer not null references question_tag(id)
);


select * from question q inner join choice c on q.id = c.question_id