create table customer
(
    id                   uuid                        not null,
    created_by_member_id uuid                        not null,
    date_create          timestamp(6) with time zone not null,
    date_update          timestamp(6) with time zone not null,
    is_deleted           boolean                     not null,
    updated_by_member_id uuid                        not null,
    full_name            varchar(255)                not null,
    identification       varchar(255)                not null,
    identification_type  varchar(255)                not null,
    primary key (id)
)
create table customer_contact
(
    id                       uuid                        not null,
    created_by_member_id     uuid                        not null,
    date_create              timestamp(6) with time zone not null,
    date_update              timestamp(6) with time zone not null,
    is_deleted               boolean                     not null,
    updated_by_member_id     uuid                        not null,
    communication_type       varchar(255)                not null,
    communication_type_value varchar(255)                not null,
    customer_id              uuid                        not null,
    primary key (id)
)
create table customer_room_reservation
(
    id                     uuid                        not null,
    created_by_member_id   uuid                        not null,
    date_create            timestamp(6) with time zone not null,
    date_update            timestamp(6) with time zone not null,
    is_deleted             boolean                     not null,
    updated_by_member_id   uuid                        not null,
    reservation_end_date   timestamp(6)                not null,
    reservation_start_date timestamp(6)                not null,
    customer_id            uuid                        not null,
    room_id                uuid                        not null,
    primary key (id)
)
create table customer_room_reservation_details
(
    id                           uuid                        not null,
    created_by_member_id         uuid                        not null,
    date_create                  timestamp(6) with time zone not null,
    date_update                  timestamp(6) with time zone not null,
    is_deleted                   boolean                     not null,
    updated_by_member_id         uuid                        not null,
    detail_key                   varchar(255)                not null,
    detail_value                 varchar(255)                not null,
    customer_room_reservation_id uuid                        not null,
    primary key (id)
)
create table customer_room_reservation_feedback
(
    id                           uuid                        not null,
    created_by_member_id         uuid                        not null,
    date_create                  timestamp(6) with time zone not null,
    date_update                  timestamp(6) with time zone not null,
    is_deleted                   boolean                     not null,
    updated_by_member_id         uuid                        not null,
    feedback                     varchar(1024),
    rating_value                 float(53)                   not null,
    customer_room_reservation_id uuid                        not null,
    primary key (id)
)
create table customer_room_reservation_payment
(
    id                           uuid                        not null,
    created_by_member_id         uuid                        not null,
    date_create                  timestamp(6) with time zone not null,
    date_update                  timestamp(6) with time zone not null,
    is_deleted                   boolean                     not null,
    updated_by_member_id         uuid                        not null,
    is_refund                    boolean                     not null,
    is_transaction_closed        boolean,
    transaction_id               varchar(255)                not null,
    customer_room_reservation_id uuid                        not null,
    primary key (id)
)
create table room
(
    id                   uuid                        not null,
    created_by_member_id uuid                        not null,
    date_create          timestamp(6) with time zone not null,
    date_update          timestamp(6) with time zone not null,
    is_deleted           boolean                     not null,
    updated_by_member_id uuid                        not null,
    floor                integer                     not null,
    identification_value varchar(255)                not null,
    is_room_available    boolean                     not null,
    primary key (id)
)
create table room_details
(
    id                   uuid                        not null,
    created_by_member_id uuid                        not null,
    date_create          timestamp(6) with time zone not null,
    date_update          timestamp(6) with time zone not null,
    is_deleted           boolean                     not null,
    updated_by_member_id uuid                        not null,
    detail_key           varchar(255)                not null,
    detail_value         varchar(255)                not null,
    room_id              uuid                        not null,
    primary key (id)
)
alter table if exists room drop constraint if exists UKkaunsvfxgv8tc8kx410ntpdyc
alter table if exists room add constraint UKkaunsvfxgv8tc8kx410ntpdyc unique (identification_value)
alter table if exists customer_contact add constraint FKf5gcjgxfa02aqsygqsrsl270t foreign key (customer_id) references customer
alter table if exists customer_room_reservation add constraint FKa9ng8nuxtawg1gesc0jpcu28s foreign key (customer_id) references customer
alter table if exists customer_room_reservation add constraint FK13027645q9iu1ucgnmij6eacn foreign key (room_id) references room
alter table if exists customer_room_reservation_details add constraint FKacry4nr21bpxh8dnd3e6xl5q9 foreign key (customer_room_reservation_id) references customer_room_reservation
alter table if exists customer_room_reservation_feedback add constraint FKr88eg8p8ktlfsq5y9n6j2ujtw foreign key (customer_room_reservation_id) references customer_room_reservation
alter table if exists customer_room_reservation_payment add constraint FK1oy21ifm6g5g4lh9mxprpb9c7 foreign key (customer_room_reservation_id) references customer_room_reservation
alter table if exists room_details add constraint FK8qmfm6ov3y62iw1cskkcvw5gn foreign key (room_id) references room