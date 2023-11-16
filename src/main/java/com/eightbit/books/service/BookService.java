package com.eightbit.books.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eightbit.books.entity.Book_master;
import com.eightbit.books.entity.Books;
import com.eightbit.books.entity.Genre;
import com.eightbit.books.entity.History;
import com.eightbit.books.entity.Status;
import com.eightbit.books.entity.Tag_master;
import com.eightbit.books.model.BookSearchQuery;
import com.eightbit.books.repository.Book_masterRepository;
import com.eightbit.books.repository.BooksRepository;
import com.eightbit.books.repository.GenreRepository;
import com.eightbit.books.repository.HistoryRepository;
import com.eightbit.books.repository.StatusRepository;
import com.eightbit.books.repository.Tag_masterRepository;

@Service
public class BookService {

	@Autowired
	private BooksRepository booksRepo;
	
	@Autowired
	private Book_masterRepository book_masterRepo;

	@Autowired
	private HistoryRepository historyRepo;

	@Autowired
	private GenreRepository genreRepo;
	
	@Autowired
	private Tag_masterRepository Tag_masterRepo;

	@Autowired
	private StatusRepository statusRepo;

	public List<Book_master> findAll(){
		return book_masterRepo.findAll();
	}
	
	public Book_master findById(int bookId) {		
		return book_masterRepo.findByBookId(bookId);
	}
	
	public List<Book_master> searchBook(BookSearchQuery searchQuery) {
		int radioValue = searchQuery.getRadioValue();
		String queryText = searchQuery.getQueryText();

		List<Book_master> bookList = null;
		if (radioValue == 0) {
//			書籍名検索
			bookList = book_masterRepo.findByTitleContaining(queryText);
		} else {
//			著者検索
			bookList = book_masterRepo.findByAuthorContaining(queryText);
		}

		return bookList;
	}

	/** 
	 * todo
	 * 複数タグで検索できるようにjson等を使用してなんとかする
	 */
//	public List<Books> searchBookGenre(int genreId) {
//		List<Books> bookList = booksRepo.findByGenreGenreId(genreId);
//		return bookList;
//	}

	/**
	 * 特定の書籍データを削除する 該当書籍IDをもつHistoryテーブルのデータも全て削除する
	 * 
	 * @param bookId
	 */
//	public void deleteBookAndHistoryData(int bookId) {
//		List<History> historyList = historyRepo.findByBooksBookId(bookId);
//		List<Integer> historyIdList = historyList.stream().map(b -> b.getId()).collect(Collectors.toList());
//		historyIdList.stream().forEach(id -> historyRepo.deleteById(id.longValue()));
////		historyRepo.deleteAllById(historyIdList);
//		booksRepo.deleteById((long) bookId);
//	}

	public void updateBookStock(int bookId, int stock, int status) {

		Book_master book = book_masterRepo.getReferenceById((long) bookId);
		book.setStock(stock);

		switch (status) {
		case 0:
//		    stockのみ更新
			break;
		case 1:
//			Not Available → Available
			book.setStatus(statusRepo.getReferenceById((long) 1));
			break;
		case 2:
//			Available → Not Available
			book.setStatus(statusRepo.getReferenceById((long) 2));
		}
		book_masterRepo.save(book);
	}

	public List<Tag_master> getTagAll() {
		List<Tag_master> tagList = Tag_masterRepo.findAll();
		return tagList;
	}

	public void bookRegist(Book_master book, int genreId) {
//		Genre genre = genreRepo.getReferenceById((long) genreId);
		Status status = statusRepo.getReferenceById((long) 1);
//		book.setGenre(genre);
		book.setStatus(status);
//		book.setReg_date(new Date());

		book_masterRepo.save(book);
	}
	
	public List<History> getCurrentBookInfo(int bookId){
//		同書籍の在庫一覧を取得
		List<Books> bookList = booksRepo.findByBookMasterBookId(bookId);
//		bookList.stream().forEach(b -> System.out.println(b.getManage_number()));
//		それぞれの在庫のIDをリスト化
		List<Integer> bookIdList = bookList.stream().map(b -> b.getId()).toList();
		List<History> resultList = new ArrayList<>();
		
		bookIdList.forEach(id -> {
//			存在しなければサイズ0の該当履歴リストを取得する
			List<History> hisList = historyRepo.findByBookId(id);
//			hisList.forEach(h -> System.out.println(h.getId()));
//			Historyテーブルに貸出履歴が存在する在庫
			if (hisList.size() > 0) {
				int maxId = 0;
				for(History h: hisList){
					System.out.println(h.getId());
					if (h.getId() > maxId) {
						maxId = h.getId(); 
					}
				}
				resultList.add(historyRepo.getReferenceById((long) maxId));
				
			}else {
//				Historyテーブルに貸出履歴が存在しない在庫
				History hisObj = new History();
				hisObj.setBook(booksRepo.getReferenceById((long) id));
				resultList.add(hisObj);
			}
		});
		
		return resultList;
	}
}
