package site.metacoding.awsv5.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import site.metacoding.awsv5.service.BookService;
import site.metacoding.awsv5.web.dto.BookRespDto;
import site.metacoding.awsv5.web.dto.BookSaveReqDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BookApiController {

    private final BookService bookService;

    //LB가 EC2에jar 배포후 / 로 헬스 체크하는 주소
    @GetMapping("/")
    public String home() {
        return "<h1>aws-v5</h1>";
    }

    //책목록보는
    @PostMapping("/api/book")
    public ResponseEntity<?> bookSave(@RequestBody BookSaveReqDto reqDto) {
        BookRespDto respDto = bookService.책등록(reqDto);
        return new ResponseEntity<>(respDto, HttpStatus.CREATED);
    }

    @GetMapping("/api/book")
    public ResponseEntity<?> bookList() {
        List<BookRespDto> respDtos = bookService.책목록보기();
        return new ResponseEntity<>(respDtos, HttpStatus.OK);
    }
}
