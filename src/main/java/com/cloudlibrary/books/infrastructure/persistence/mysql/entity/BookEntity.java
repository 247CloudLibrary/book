package com.cloudlibrary.books.infrastructure.persistence.mysql.entity;


import com.cloudlibrary.books.application.domain.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "book")
public class BookEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rid;

    @Column(nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String thumbNailImage;

    @Column(nullable = false)
    private String coverImage;

    @Column(nullable = false)
    private String author;

    private String translator;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contents;

    @Column(nullable = false)
    private String publisher;

    private LocalDate publishDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookType bookType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookGenre genre;

    @Column(nullable = false)
    private String barcode;

    private String rfid;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookStatus bookStatus;

    @Column(nullable = false)
    private Long libraryId;

    @Column(nullable = false)
    private String libraryName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;


    public Book toBook() {
        return Book.builder()
                .id(this.id)
                .rid(this.rid)
                .isbn(this.isbn)
                .title(this.title)
                .thumbNailImage(this.thumbNailImage)
                .coverImage(this.coverImage)
                .author(this.author)
                .translator(this.translator)
                .contents(this.contents)
                .publisher(this.publisher)
                .publishDate(this.publishDate)
                .bookType(this.bookType.getType())
                .genre(this.genre.getGenre())
                .barcode(this.barcode)
                .rfid(this.rfid)
                .bookStatus(this.bookStatus.getStatus())
                .libraryId(this.libraryId)
                .libraryName(this.libraryName)
                .category(this.category.getValue())
                .createdAt(super.getCreatedAt())
                .updatedAt(super.getUpdatedAt())
                .build();
    }

    public BookEntity(Book book) {
        this.id = book.getId();
        this.rid = book.getRid();
        this.isbn =book.getIsbn();
        this.title= book.getTitle();
        this.thumbNailImage=book.getThumbNailImage();
        this.coverImage = book.getCoverImage();
        this.author = book.getAuthor();
        this.translator = book.getTranslator();
        this.contents = book.getContents();
        this.publisher = book.getPublisher();
        this.publishDate = book.getPublishDate();
        this.bookType = BookType.find(book.getBookType());
        this.genre = BookGenre.find(book.getGenre());
        this.barcode = book.getBarcode();
        this.rfid = book.getRfid();
        this.category = Category.findCategory(book.getCategory());
        this.bookStatus = BookStatus.find(book.getBookStatus());
        this.libraryId = book.getLibraryId();
        this.libraryName = book.getLibraryName();
    }

    /**
     * 도서 삭제
     */

    public void changeStatus(BookStatus status) {
        this.bookStatus = status;
    }

    /**
     * 도서 상태 변경
     */
    public void updateBookStatus(Long id, String status) {
        this.id = id;
        this.bookStatus = BookStatus.find(status);
    }
}
