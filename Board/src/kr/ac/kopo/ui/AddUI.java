package kr.ac.kopo.ui;

import kr.ac.kopo.BoardServiceFactory;
import kr.ac.kopo.service.BoardService;
import kr.ac.kopo.vo.BoardVO;

public class  AddUI extends BaseUI {
	
	
	private BoardService boardService;
	
	public AddUI() {
		boardService =BoardServiceFactory.getInstance();
	}
	
	@Override
	public void execute() throws Exception {

		 String title = scanStr("등록할 제목을 입력하세요 : ");
		 String writer = scanStr("글쓴이를 입력하세요 : ");
	
		 BoardVO board = new BoardVO();
		 board.setTitle(title);   // 제목
		 board.setWriter(writer); // 작성자
		 // 지난거에 이어서 하기..!!
		 // 번호랑, 등록일 등 추가할게 많음! --> 이건 키보드 입력과는 상관이 없음! 
		 
		 // 서비스클랩 ..?
		 
		 
		 //dao가 보드리스트에 추가되어서 게시글 자체를 crud하도록 하려고 함 
		 // 게시글 수정, 추가, 삭제 등 이런 모든 것의 위치는 그때그때마다 달라질 수 가 있음
		 // 중요한 건 각각에 저장되는 위치에서 명령어를 만들어줘야함 
		 
		 //여기서 ui는 키보드의 입력을 받고 일어나는 결과값을 화면에 띄어주는것뿐 !
		 // 그렇게 때문에 ui를 이용해 오더를 내리는 것은 무식한 방법!! (ui는 관심이 없기 때문!)
		 //dao는 일반적으로 여러개의(프로덕트, DB 등)  dao가 있으며 이 여러개의 그것들을 억세스 해야함 
		 // 그것들을 어디서 구성할 거냐가 중요한대! , 이 구성을 [서비스]에서 할 거임!
		 
		 
		 //                       (게시글을 CRUD)
		 // ui ------>[서비스] ----> DAO ------> RAM
		 //   <-------      <-------   <-------
  		 
		 
		 
		 boardService.insertBoard(board);
		 
		 System.out.println("새글 등록을 완료하였습니다");
	}

	
}