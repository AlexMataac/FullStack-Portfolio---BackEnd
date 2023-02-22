-- Navbar
INSERT INTO navbar (id, logo, home, about_me, resume, experience, project, contact_me)
VALUES (1, 'Vincent', 'Home', 'About Me', 'Resume', 'Experience', 'Project', 'Contact Me');

--SocialLinks
INSERT INTO social_links (id, face_book, linked_in, git_hub, mail, resume)
VALUES (1, 'https://facebook.com', 'https://www.linkedin.com/in/alex-john-vincent-mataac-55192a22a/', 'https://github.com/Mokotokuragi', 'mailto:alexmataac057@gmail.com', '/CV - Alex John Vincent Mataac.pdf');

-- Home
INSERT INTO home (id, name, type_Writer, description, image, resume)
VALUES (1, 'I''m Alex John','Junior Software Engineer','Working in Cognizant Softvision in Makati City, Philippines','hero.JPG','CV - Alex John Vincent Mataac.pdf');

-- About Me
INSERT INTO about_me (id, name, birthday, age, education, study, hobbies, location, image)
VALUES (1, 'Alex John Vincent O. Mataac', 'August 31, 1999', '23 years old', 'Bachelor of Science in Computer Engineering', 'Emilio Aguinaldo College- Cavite', 'Playing basketball, online games', 'Bacoor, Cavite', 'Program.jpg');

-- Resume
INSERT INTO resume (id, job, place, period)
VALUES (1, 'BS Computer Engineering', 'Emilio Aguinaldo College-Cavite', '2018-2022'),
       (2, 'Mobile Development Front-End (OJT)', 'Erovoutika Robotics and Automation Solutions', 'February-April 2022'),
       (3, 'Junior Software Engineer', 'Cognizant Softvision', '2022-present');


-- Experience
INSERT INTO experience (id, items, images)
VALUES (1, 'HTML', 'html.png'),
       (2, 'CSS', 'css.png'),
       (3, 'JavaScript', 'javascript.png'),
       (4, 'React', 'react.png'),
       (5, 'Java', 'Java.png'),
       (6, 'Spring Boot', 'springboot.png'),
       (7, 'PostgreSQL', 'Postgre sql.png'),
       (8, 'Git Hub', 'github.png'),
       (9, 'Tailwind', 'tailwind.png');

-- Project
INSERT INTO project (id, image, title, description, link)
VALUES (1, 'images.jpg', 'Mjolnir Project', 'The user''s story need to create get by id, can post a member, can update a member, can retrieve all people and also can delete. It cannot retrieve the inactive member.', 'https://github.com/Mokotokuragi/MjolnirProject');

-- Contact Me
INSERT INTO contact_me (id, name, email, message)
VALUES (1, 'Alex', 'abc@def.com', 'hello');
-- Footer
INSERT INTO footer (id, face_book, linked_in, git_hub, mail, closing_tag)
VALUES (1, 'https://facebook.com', 'https://www.linkedin.com/in/alex-john-vincent-mataac-55192a22a/', 'https://github.com/Mokotokuragi', 'mailto:alexmataac057@gmail.com', 'Copyright @ Vincent - 2023. All rights reserved');
