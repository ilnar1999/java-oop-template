package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.Author;
import org.apache.commons.lang3.ArrayUtils;

public class SimpleAuthorRepository implements AuthorRepository {
    Author[] authors = new Author[]{};

    @Override
    public boolean save(Author author) {
        if (findByFullName(author.getName(),author.getLastName()) == null) {
            authors = ArrayUtils.add(authors, author);
            return true;
        }
        return false;
    }

    @Override
    public Author findByFullName(String name, String lastname) {
        for (Author author: authors) {
            if (author.getName().equals(name) && author.getLastName().equals(lastname)) {
                return author;
            }
        }
        return null;
    }

    @Override
    public boolean remove(Author author) {
        if (findByFullName(author.getName(),author.getLastName()) != null) {
            int index = ArrayUtils.indexOf(authors, author);
            authors = ArrayUtils.remove(authors, index);
        }
        return false;
    }

    @Override
    public int count() {
        return authors.length;
    }
}
