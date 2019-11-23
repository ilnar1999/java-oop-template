package com.epam.izh.rd.online.repository;

import com.epam.izh.rd.online.entity.SchoolBook;
import org.apache.commons.lang3.ArrayUtils;

public class SimpleSchoolBookRepository implements BookRepository<SchoolBook> {
    SchoolBook[] schoolBooks = new SchoolBook[]{};

    @Override
    public boolean save(SchoolBook book) {
        schoolBooks = ArrayUtils.add(schoolBooks, book);
        return true;
    }

    @Override
    public SchoolBook[] findByName(String name) {
        SchoolBook[] foundBooks = new SchoolBook[]{};
        for (SchoolBook newBook: schoolBooks) {
            if (newBook.getName().equals(name)) {
                foundBooks = ArrayUtils.add(foundBooks, newBook);
            }
        }
        return foundBooks;
    }

    @Override
    public boolean removeByName(String name) {
        SchoolBook[] onDelete = findByName(name);
        int index;
        if (onDelete.length == 0) {
            return false;
        }
        for (SchoolBook bookOnDelete: onDelete) {
            index = ArrayUtils.indexOf(schoolBooks, bookOnDelete);
            schoolBooks = ArrayUtils.remove(schoolBooks, index);
        }
        return true;
    }

    @Override
    public int count() {
        return schoolBooks.length;
    }
}
