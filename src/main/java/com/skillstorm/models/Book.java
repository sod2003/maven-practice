package com.skillstorm.models;

public class Book {
    private int bookId;
    private String title;
    private int authorId;
    private int publicationYear;
    private String ISBN;
    private int genreId;

    public Book(int bookId, String title, int authorId, int publicationYear, String ISBN, int genreId) {
        this.bookId = bookId;
        this.title = title;
        this.authorId = authorId;
        this.publicationYear = publicationYear;
        this.ISBN = ISBN;
        this.genreId = genreId;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + bookId;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + authorId;
        result = prime * result + publicationYear;
        result = prime * result + ((ISBN == null) ? 0 : ISBN.hashCode());
        result = prime * result + genreId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (bookId != other.bookId)
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (authorId != other.authorId)
            return false;
        if (publicationYear != other.publicationYear)
            return false;
        if (ISBN == null) {
            if (other.ISBN != null)
                return false;
        } else if (!ISBN.equals(other.ISBN))
            return false;
        if (genreId != other.genreId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", title=" + title + ", authorId=" + authorId + ", publicationYear="
                + publicationYear + ", ISBN=" + ISBN + ", genreId=" + genreId + "]";
    }
}
