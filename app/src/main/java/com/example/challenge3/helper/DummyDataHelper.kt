package com.example.challenge3.helper

import com.example.challenge3.R
import com.example.challenge3.data.BookList

class DummyDataHelper {
    companion object {
        fun generateDummyData(): List<BookList> {
            val books = mutableListOf<BookList>()

            val bookData = arrayOf(
                BookData(1, R.drawable.img_a, "All We Had by Annie Weatherwax"),
                BookData(2, R.drawable.img_a1, "Airman by Eoin Colfer"),
                BookData(3, R.drawable.img_a2, "Absolute Brightness by James Lecesne"),
                BookData(4, R.drawable.img_b, "Beauty and the Beast by The (MinaLima Edition)"),
                BookData(5, R.drawable.img_b1, "Baby Brains by Simon James"),
                BookData(6, R.drawable.img_b2, "Brown Bear, Brown Bear, What Do You See? by Eric Carle"),
                BookData(7, R.drawable.img_c, "Calling Me Home by Julie Kibler"),
                BookData(8, R.drawable.img_c1, "California by Edan Lepucki"),
                BookData(9, R.drawable.img_c2, "Cupcake by Charise Mericle Harper"),
                BookData(10, R.drawable.img_d, "Dune by Frank Herbert"),
                BookData(11, R.drawable.img_d1, "Damnation Spring by Ash Davidson"),
                BookData(12, R.drawable.img_d2, "Daisy Jones & The Six : A Novel by Taylor Jenkins Reid"),
                BookData(13, R.drawable.img_e, "Eleanor Oliphant Is Completely Fine by Gail Honeyman"),
                BookData(14, R.drawable.img_e1, "Edgar and Lucy by Victor Lodato"),
                BookData(15, R.drawable.img_e2, "Educated : A Memoir by Tara Westover"),
                BookData(16, R.drawable.img_f, "Frankenstein by Mary Shelley"),
                BookData(17, R.drawable.img_f1, "Fall of Giants : Book One of the Century Trilogy by Ken Follett"),
                BookData(18, R.drawable.img_f2, "Fallen Land by Taylor Brown"),
                BookData(19, R.drawable.img_g, "Grave's End by William Shaw"),
                BookData(20, R.drawable.img_g1, "Galileo's Daughter : A Historical Memoir of Science, Faith, and Love by Dava Sobel"),
                BookData(21, R.drawable.img_g2, "Galore by Michael Crummey"),
                BookData(22, R.drawable.img_h, "Harry Potter and the Sorcerer's Stone by J.K. Rowling"),
                BookData(23, R.drawable.img_h1, "Harry Potter and The Chamber of Secrets by J.K. Rowling"),
                BookData(24, R.drawable.img_h2, "Harry Potter and the Prisoner of Azkaban by J.K. Rowling"),
                BookData(25, R.drawable.img_i, "I Let You Go by Clare Mackintosh"),
                BookData(26, R.drawable.img_i1, "I Must Betray You by Ruta Sepetys"),
                BookData(27, R.drawable.img_i2, "I Will Die in a Foreign Land by Kalani Pickhart"),
                BookData(28, R.drawable.img_j, "Jurassic Park by Michael Crichton"),
                BookData(29, R.drawable.img_j1, "Jackie & Me by Louis Bayard"),
                BookData(30, R.drawable.img_j2, "Jim The Boy by Tony Earley")
            )

            bookData.forEach { book ->
                books.add(BookList(book.id, book.imageResource, book.name))
            }

            return books
        }

        private data class BookData(val id: Int, val imageResource: Int, val name: String)
    }
}