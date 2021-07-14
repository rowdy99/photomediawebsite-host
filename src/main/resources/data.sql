INSERT INTO `roles` (`id`, `description`, `name`) VALUES
(1, 'Akses role ADMIN', 'ROLE_ADMIN'),
(2, 'Akses role MEMBER', 'ROLE_MEMBER');
INSERT INTO `users` (`id`, `email`, `firstname`, `lastname`, `password`, `username`) VALUES
(1, 'sarkarrahul90933@gmail.com', 'Subham', 'Sarkar', '$2a$10$2dvaIOyte/u78G2YRum5ZOAtLEN6LF03n06qbjf0OLuGafgjoCQsW', 'Subham99'),
(2, 'tcsreg@gmail.com', 'tcs', 'reg', '$2a$10$nO7SVss2lzIEyCGi.rAb3Oe1g14xJE0Z/c/jJR3aVTMi0JA6zMauO', 'tcsreg');
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 2);

-- password: @Asdf123