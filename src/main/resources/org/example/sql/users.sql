create table users (
`id` int not null primary key auto_increment,
`first_name` varchar(255) not null,
`last_name` varchar(255) not null,
`email_address` varchar(255) not null,
`date_of_birth` date not null,
`phone_number` varchar(15) not null,
`password` varchar(255) not null,
`account_type` enum('student', 'instructor', 'admin') not null
);