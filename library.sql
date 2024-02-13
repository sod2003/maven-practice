-- Create the library schema
CREATE SCHEMA IF NOT EXISTS library;

-- Create the author table
CREATE TABLE IF NOT EXISTS library.author (
    author_id INT AUTO_INCREMENT PRIMARY KEY,
    author_name VARCHAR(100) NOT NULL,
    birth_year INT,
    nationality VARCHAR(100)
);

-- Create the genre table
CREATE TABLE IF NOT EXISTS library.genre (
    genre_id INT AUTO_INCREMENT PRIMARY KEY,
    genre_name VARCHAR(50) NOT NULL
);

-- Create the book table
CREATE TABLE IF NOT EXISTS library.book (
    book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author_id INT NOT NULL,
    publication_year INT,
    isbn VARCHAR(20),
    genre_id INT,
    FOREIGN KEY (author_id) REFERENCES library.author(author_id),
    FOREIGN KEY (genre_id) REFERENCES library.genre(genre_id)
);

-- Insert statements for genres
INSERT INTO library.genre (genre_name) VALUES
    ('Fiction'),
    ('Non-fiction'),
    ('Mystery'),
    ('Thriller'),
    ('Science Fiction'),
    ('Fantasy'),
    ('Romance'),
    ('Biography'),
    ('History'),
    ('Self-help');

-- Insert statements for authors
INSERT INTO library.author (author_name, birth_year, nationality) VALUES
    ('Jane Austen', 1775, 'English'),
    ('Fyodor Dostoevsky', 1821, 'Russian'),
    ('Mark Twain', 1835, 'American'),
    ('Leo Tolstoy', 1828, 'Russian'),
    ('George Orwell', 1903, 'English'),
    ('J.K. Rowling', 1965, 'British'),
    ('Agatha Christie', 1890, 'English'),
    ('Ernest Hemingway', 1899, 'American'),
    ('Stephen King', 1947, 'American'),
    ('Harper Lee', 1926, 'American');

-- Insert statements for books
INSERT INTO library.book (title, author_id, publication_year, isbn, genre_id) VALUES
    ('Pride and Prejudice', 1, 1813, '9780141199078', 1),
    ('Crime and Punishment', 2, 1866, '9780140449136', 3),
    ('The Adventures of Huckleberry Finn', 3, 1884, '9780141199009', 1),
    ('War and Peace', 4, 1869, '9780140447934', 1),
    ('1984', 5, 1949, '9780451524935', 4),
    ('Harry Potter and the Philosopher''s Stone', 6, 1997, '9781408855652', 6),
    ('And Then There Were None', 7, 1939, '9780062073488', 3),
    ('The Old Man and the Sea', 8, 1952, '9780684801223', 2),
    ('The Shining', 9, 1977, '9780307743657', 4),
    ('To Kill a Mockingbird', 10, 1960, '9780061120084', 1);

SELECT title, author_name, genre_name FROM book JOIN author USING (author_id) JOIN genre USING (genre_id);