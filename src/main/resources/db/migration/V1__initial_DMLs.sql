insert into question_tag(name, created_at, updated_at)
select 'Brezilya', now(), now();

insert into question_tag(name, created_at, updated_at)
select 'Türkiye', now(), now();

insert into question_tag(name, created_at, updated_at)
select '2021', now(), now();

insert into question (lang_code, question_text, created_at, updated_at, question_tag_id)
select 'TR', 'En iyi takım hangisi', now(), now(), 1;

insert into question (lang_code, question_text, created_at, updated_at, question_tag_id)
select 'TR', 'Hem sütlü çikolata olup, Hem Türkiye forması giyen oyuncu kimdir', now(), now(), 3;

insert into question_question_tag (question_id, question_tag_id)
select (select id from question where question_text = 'En iyi takım hangisi'), (select id from question_tag where name = 'Brezilya');

insert into question_question_tag (question_id, question_tag_id)
select (select id from question where question_text = 'Hem sütlü çikolata olup, Hem Türkiye forması giyen oyuncu kimdir'), (select id from question_tag where name = 'Türkiye');

insert into choice(choice_text, correct, question_id, created_at, updated_at)
select 'Brezilya', true, (select id from question where question_text = 'En iyi takım hangisi') , now(), now();

    insert into choice(choice_text, correct, question_id, created_at, updated_at)
select 'İngiltere', false, (select id from question where question_text = 'En iyi takım hangisi') , now(), now();

    insert into choice(choice_text, correct, question_id, created_at, updated_at)
select 'İspanya', false, (select id from question where question_text = 'En iyi takım hangisi') , now(), now();

    insert into choice(choice_text, correct, question_id, created_at, updated_at)
select 'Türkiye', false, (select id from question where question_text = 'En iyi takım hangisi') , now(), now();


    insert into users(identifier, created_at, updated_at)
select 'Enes Bulut', now(), now();

    insert into users(identifier, created_at, updated_at)
select 'Afgani Türkmen', now(), now();

    insert into users(identifier, created_at, updated_at)
select 'Muhammed Akbulut', now(), now();

    insert into users(identifier, created_at, updated_at)
select 'İsmail Yavuz', now(), now();